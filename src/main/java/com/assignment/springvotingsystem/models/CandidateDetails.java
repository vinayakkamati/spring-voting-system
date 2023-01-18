package com.assignment.springvotingsystem.models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class CandidateDetails {
    private String name;
    private Long vote;
}
