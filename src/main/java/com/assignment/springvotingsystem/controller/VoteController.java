package com.assignment.springvotingsystem.controller;

import com.assignment.springvotingsystem.service.VoteService;
import com.assignment.springvotingsystem.service.exceptions.InvalidRequestParamException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(path = "/enterCandidate")
    public ResponseEntity<?> enterCandidate(@RequestParam final String name){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.addCandidate(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }

    @PostMapping(path = "/castVote")
    public ResponseEntity<?> castVote(@RequestParam final String name){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.castVote(name));
        }catch (InvalidRequestParamException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }

    @GetMapping(path = "/countVote")
    public ResponseEntity<?> countVote(@RequestParam final String name){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.countVote(name));
        }catch (InvalidRequestParamException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
        }
    }
}
