package com.assignment.springvotingsystem.service;

import com.assignment.springvotingsystem.models.CandidateDetails;

import java.util.Map;

public interface VoteService {
    Map<String, Long> addCandidate(String name);

    CandidateDetails castVote(String name);
}
