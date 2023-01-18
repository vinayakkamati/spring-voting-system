package com.assignment.springvotingsystem.service.impl;

import com.assignment.springvotingsystem.models.CandidateDetails;
import com.assignment.springvotingsystem.service.VoteService;
import com.assignment.springvotingsystem.service.exceptions.InvalidRequestParamException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {

    HashMap<String, Long> candidateDetails = new HashMap<>();
    @Override
    public Map<String, Long> addCandidate(String name) {
        if (!candidateDetails.containsKey(name)){
            candidateDetails.put(name, 0L);
        }
        return candidateDetails;
    }

    @Override
    public CandidateDetails castVote(String name) {
        if (candidateDetails.containsKey(name)){
            long candidateValue = candidateDetails.get(name);
            candidateDetails.replace(name,candidateValue,candidateValue + 1);
            return CandidateDetails.builder()
                    .name(name)
                    .vote(candidateDetails.get(name)).build();
        }else{
            throw new InvalidRequestParamException("Unable to find candidate :" + name);
        }
    }
}