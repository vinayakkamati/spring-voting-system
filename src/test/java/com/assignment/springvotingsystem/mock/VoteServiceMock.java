package com.assignment.springvotingsystem.mock;

import com.assignment.springvotingsystem.models.CandidateDetails;

public class VoteServiceMock {
    public static CandidateDetails getCandidateDetails() {
        return CandidateDetails.builder()
                .name("Amol")
                .vote(0L).build();
    }
}
