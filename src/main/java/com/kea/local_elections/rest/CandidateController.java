package com.kea.local_elections.rest;

import com.kea.local_elections.dtos.CandidateDTO;
import com.kea.local_elections.services.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class CandidateController {

    CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    List<CandidateDTO> getCandidates(@RequestParam(defaultValue = "0") int partyId) {
        return candidateService.getCandidates(partyId);
    }

    @GetMapping("/{id}")
    CandidateDTO getCandidate(@PathVariable int id) {
        return candidateService.getCandidate(id);
    }

    @PostMapping
    CandidateDTO addCandidate(@RequestParam String fullName, @RequestParam int partyId) {
        return candidateService.addCandidate(fullName, partyId);
    }

    @PutMapping("/{id}")
    CandidateDTO editCandidate(@PathVariable int id, @RequestParam String fullName, @RequestParam int partyId) {
        return candidateService.editCandidate(id, fullName, partyId);
    }

    @DeleteMapping("/{id}")
    void deleteCandidate(@PathVariable int id) {
        candidateService.deleteCandidate(id);
    }

}
