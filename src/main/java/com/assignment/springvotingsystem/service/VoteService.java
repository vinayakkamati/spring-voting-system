package com.assignment.springvotingsystem.service;

import com.assignment.springvotingsystem.models.CandidateDetails;

import java.util.Map;

public interface VoteService {
    CandidateDetails addCandidate(String name);

    Long castVote(String name);

    Long countVote(String name);

    Map<String, Long> listVote();

    String getWinner();
}
