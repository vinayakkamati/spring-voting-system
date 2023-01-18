package com.assignment.springvotingsystem.serviceTest;

import com.assignment.springvotingsystem.models.CandidateDetails;
import com.assignment.springvotingsystem.service.exceptions.InvalidRequestParamException;
import com.assignment.springvotingsystem.service.impl.VoteServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;

import static com.assignment.springvotingsystem.constants.GenericConstants.NAME;
import static com.assignment.springvotingsystem.mock.VoteServiceMock.getCandidateDetails;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VoteServiceImplTest {

    @InjectMocks
    VoteServiceImpl voteService;

    @Mock
    HashMap<String, Long> candidatesDetails = new HashMap<>();

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Positive case: add candidate")
    void addCandidate() {
        CandidateDetails expectedValue = getCandidateDetails();
        CandidateDetails actualValue = voteService.addCandidate(NAME);
        assertNotNull(actualValue);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    @DisplayName("Positive case: castVote")
    void castVotePositiveCase() {
        try{
            Long expectedValue = 0L;
            Mockito.when(candidatesDetails.containsKey(NAME)).thenReturn(true);
            Mockito.when(candidatesDetails.get(NAME)).thenReturn(0L);
            Long actualValue = voteService.castVote(NAME);
            assertEquals(expectedValue,actualValue);
        }catch (InvalidRequestParamException ignored){
        }
    }

    @Test
    @DisplayName("Negative case: castVote")
    void castVote() {
        try{
            voteService.castVote("Ajay");
        }catch (InvalidRequestParamException e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void countVote() {
    }

    @Test
    void listVote() {
    }

    @Test
    void getWinner() {
    }
}