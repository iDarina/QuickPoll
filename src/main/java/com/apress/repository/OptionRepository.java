package com.apress.repository;

import com.apress.domain.Options;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Options, Long> {

}
