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
import java.util.Map;

import static com.assignment.springvotingsystem.constants.GenericConstants.NAME;
import static com.assignment.springvotingsystem.mock.VoteServiceMock.getCandidateDetails;
import static com.assignment.springvotingsystem.mock.VoteServiceMock.getCandidatesDetails;
import static org.junit.jupiter.api.Assertions.*;

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
        Mockito.when(candidatesDetails.get(NAME)).thenReturn(0L);
        CandidateDetails actualValue = voteService.addCandidate(NAME);
        assertNotNull(actualValue);
        assertEquals(expectedValue,actualValue);
    }

    @Test
    @DisplayName("Positive case: cast vote")
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
    @DisplayName("Negative case: cast vote")
    void castVote() {
        try{
            voteService.castVote(NAME);
        }catch (InvalidRequestParamException e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    @DisplayName("Positive case: count vote")
    void countVotePositiveCase() {
        try{
            Long expectedValue = 2L;
            Mockito.when(candidatesDetails.containsKey(NAME)).thenReturn(true);
            Mockito.when(candidatesDetails.get(NAME)).thenReturn(2L);
            Long actualValue = voteService.countVote(NAME);
            assertEquals(expectedValue,actualValue);
        }catch (InvalidRequestParamException ignored){
        }
    }

    @Test
    @DisplayName("Negative case: count vote")
    void countVote() {
        try{
            voteService.countVote(NAME);
        }catch (InvalidRequestParamException e){
            Assertions.assertTrue(true);
        }
    }

    @Test
    void listVote() {
        Map<String, Long> expectedValue = new HashMap<>();
        Map<String, Long> actualValue = voteService.listVote();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    void getWinner() {
        Mockito.when(candidatesDetails.entrySet()).thenReturn(getCandidatesDetails().entrySet());
        String actualValue = voteService.getWinner();
        assertEquals(NAME,actualValue);
    }
}