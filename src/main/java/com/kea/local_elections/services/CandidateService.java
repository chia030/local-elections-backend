package com.kea.local_elections.services;

import com.kea.local_elections.dtos.CandidateDTO;
import com.kea.local_elections.entities.Candidate;
import com.kea.local_elections.entities.Party;
import com.kea.local_elections.repositories.CandidateRepo;
import com.kea.local_elections.repositories.PartyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    CandidateRepo candidateRepo;
    PartyRepo partyRepo;

    public CandidateService(CandidateRepo candidateRepo, PartyRepo partyRepo) {
        this.candidateRepo = candidateRepo;
        this.partyRepo = partyRepo;
    }

    public List<CandidateDTO> getCandidates(int partyId) {
        if (partyId==0) {
            return CandidateDTO.CandidateDTOSfromCandidate(candidateRepo.findAll());
        }
        else {
            return CandidateDTO.CandidateDTOSfromCandidate(candidateRepo.findAllByPartyId(partyId));
        }
    }

    public CandidateDTO getCandidate(int id) {
        Candidate candidate = candidateRepo.findById(id).orElseThrow();
        return new CandidateDTO(candidate);
    }

    public CandidateDTO addCandidate(String fullName, int partyId) {
        Party chosenParty = partyRepo.findById(partyId).orElseThrow();
        Candidate candidateToAdd = new Candidate (fullName, chosenParty);
        return new CandidateDTO(candidateRepo.save(candidateToAdd));
    }

    public CandidateDTO editCandidate(int id, String fullName, int partyId) {
        Candidate candidateOG = candidateRepo.findById(id).orElseThrow();
        candidateOG.setFullName(fullName);
        candidateOG.setParty(partyRepo.findById(partyId).orElseThrow());
        return new CandidateDTO(candidateRepo.save(candidateOG));
    }

    public void deleteCandidate(int id) {
        candidateRepo.deleteById(id);
    }

}
