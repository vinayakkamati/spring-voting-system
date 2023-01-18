package com.assignment.springvotingsystem.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateDetails {
    private String name;
    private Long vote;
}
