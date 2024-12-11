package com.apress.controller;

import java.net.URI;
import java.util.Optional;

import javax.inject.Inject;


import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apress.domain.Poll;
import com.apress.exception.ResourceNotFoundException;
import com.apress.repository.PollRepository;

@RestController
public class PollController {

    private final Logger logger = LoggerFactory.getLogger(PollController.class);

    @Autowired // replaced for @inject
    private PollRepository pollRepository;

    @GetMapping(value = "/polls")
    public ResponseEntity<Iterable<Poll>> getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();

        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value="/polls" )
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(poll.getId()).toUri();
        responseHeaders.setLocation(newPollUri);

        logger.info("Created a Poll successfully");
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Poll poll = pollRepository.findById(pollId).orElse(null);
        if(poll == null) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }
    @GetMapping(value="/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        Poll p = pollRepository.findById(pollId).orElse(null);

//        logger.info("Got a Poll successfully");
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    @PutMapping(value="/polls/{pollId}")
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.save(poll);

        logger.info("Updated a Poll successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);

        logger.info("Deleted a Poll successfully");
        return new ResponseEntity<>(HttpStatus.OK);
    }






}