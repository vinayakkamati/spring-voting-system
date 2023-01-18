package com.assignment.springvotingsystem.service.impl;

import com.assignment.springvotingsystem.models.CandidateDetails;
import com.assignment.springvotingsystem.service.VoteService;
import com.assignment.springvotingsystem.service.exceptions.InvalidRequestParamException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {

    HashMap<String, Long> candidatesDetails = new HashMap<>();
    @Override
    public CandidateDetails addCandidate(String name) {
        if (!candidatesDetails.containsKey(name)){
            candidatesDetails.put(name, 0L);
        }
        return CandidateDetails.builder()
                .name(name)
                .vote(candidatesDetails.get(name)).build();
    }

    @Override
    public Long castVote(String name) {
        if (candidatesDetails.containsKey(name)){
            long candidateValue = candidatesDetails.get(name);
            candidatesDetails.replace(name,candidateValue,candidateValue + 1);
            return candidatesDetails.get(name);
        }else{
            throw new InvalidRequestParamException("Unable to find candidate :" + name);
        }
    }

    @Override
    public Long countVote(String name) {
        if (candidatesDetails.containsKey(name)){
            return candidatesDetails.get(name);
        }else{
            throw new InvalidRequestParamException("Unable to find candidate :" + name);
        }
    }

    @Override
    public Map<String, Long> listVote() {
        return candidatesDetails;
    }

    @Override
    public String getWinner() {
        return Collections
                .max(candidatesDetails.entrySet(), Map.Entry.comparingByValue())
                .getKey();
    }
}
