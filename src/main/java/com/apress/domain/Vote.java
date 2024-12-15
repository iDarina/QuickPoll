package com.apress.domain;

import jakarta.persistence.*;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    @Column(name="VOTE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="OPTION_ID")
    private Options options;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Options getOption() {
        return options;
    }
    public void setOption(Options option) {
        this.options = option;
    }

    @Override
    public String toString() {
        return getId() + ", " + getOption();
    }

}
