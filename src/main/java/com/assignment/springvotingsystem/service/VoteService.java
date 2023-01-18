package com.assignment.springvotingsystem.service;

import com.assignment.springvotingsystem.models.CandidateDetails;

import java.util.Map;

public interface VoteService {
    CandidateDetails addCandidate(String name);

    CandidateDetails castVote(String name);

    CandidateDetails countVote(String name);

    Map<String, Long> listVote();
}
