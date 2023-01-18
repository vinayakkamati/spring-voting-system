package com.assignment.springvotingsystem.serviceTest;

import com.assignment.springvotingsystem.models.CandidateDetails;
import com.assignment.springvotingsystem.service.impl.VoteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static com.assignment.springvotingsystem.mock.VoteServiceMock.getCandidateDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoteServiceImplTest {

    @InjectMocks
    VoteServiceImpl voteService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Positive case: add candidate")
    void addCandidate() {
        CandidateDetails expectedValue = getCandidateDetails();
        CandidateDetails actualValue = voteService.addCandidate("Amol");
        assertNotNull(actualValue);
        assertEquals(expectedValue,actualValue);
    }
}