package com.assignment.springvotingsystem.mock;

import com.assignment.springvotingsystem.models.CandidateDetails;

import static com.assignment.springvotingsystem.constants.GenericConstants.NAME;

public class VoteServiceMock {
    public static CandidateDetails getCandidateDetails() {
        return CandidateDetails.builder()
                .name(NAME)
                .vote(0L).build();
    }
}
