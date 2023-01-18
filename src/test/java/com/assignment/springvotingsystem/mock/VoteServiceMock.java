package com.assignment.springvotingsystem.mock;

import com.assignment.springvotingsystem.models.CandidateDetails;

import java.util.HashMap;
import java.util.Map;

import static com.assignment.springvotingsystem.constants.GenericConstants.NAME;

public class VoteServiceMock {
    public static CandidateDetails getCandidateDetails() {
        return CandidateDetails.builder()
                .name(NAME)
                .vote(0L).build();
    }

    public static Map<String,Long> getCandidatesDetails() {
        HashMap<String, Long> candidatesDetails = new HashMap<>();
        candidatesDetails.put(NAME,3L);
        return candidatesDetails;
    }
}
