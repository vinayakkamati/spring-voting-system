package com.assignment.springvotingsystem.service.impl;

import com.assignment.springvotingsystem.service.VoteService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteServiceImpl implements VoteService {

    HashMap<String, Integer> candidateDetails = new HashMap<>();
    @Override
    public Map<String, Integer> addCandidate(String name) {
        if (!candidateDetails.containsKey(name)){
            candidateDetails.put(name,0);
        }
        return candidateDetails;
    }
}
