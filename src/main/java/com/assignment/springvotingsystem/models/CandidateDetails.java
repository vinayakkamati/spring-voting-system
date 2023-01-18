package com.assignment.springvotingsystem.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CandidateDetails {
    private String name;
    private Long vote;

    public void setName(String name) {
        this.name = name;
    }

    public void setVote(Long vote) {
        this.vote = vote;
    }
    public String getName() {
        return name;
    }

    public Long getVote() {
        return vote;
    }
}
