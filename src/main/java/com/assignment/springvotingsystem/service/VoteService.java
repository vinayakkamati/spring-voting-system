package com.assignment.springvotingsystem.service;

import java.util.Map;

public interface VoteService {
    Map<String, Integer> addCandidate(String name);
}
