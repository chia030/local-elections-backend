package com.kea.local_elections.rest;

import com.kea.local_elections.dtos.VoteDTO;
import com.kea.local_elections.services.VoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/votes")
public class VoteController {

    VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    List<VoteDTO> getVotes(@RequestParam(required = false) String candidateId,
                           @RequestParam(required = false) String partyId,
                           @RequestParam(defaultValue = "false") boolean totalPartyVotes) {
        return voteService.getVotes(candidateId, partyId, totalPartyVotes);
    }

    @GetMapping("/{id}")
    VoteDTO getVote(@PathVariable int id) {
        return voteService.getVote(id);
    }

    @PostMapping
    VoteDTO addVote(@RequestParam(required = false) String candidateId,
                    @RequestParam(required = false) String partyId) {
        return voteService.addVote(candidateId, partyId);
    }

}
