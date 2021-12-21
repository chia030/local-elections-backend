package com.kea.local_elections.services;

import com.kea.local_elections.dtos.VoteDTO;
import com.kea.local_elections.entities.Candidate;
import com.kea.local_elections.entities.Party;
import com.kea.local_elections.entities.Vote;
import com.kea.local_elections.repositories.CandidateRepo;
import com.kea.local_elections.repositories.PartyRepo;
import com.kea.local_elections.repositories.VoteRepo;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class VoteService {

    VoteRepo voteRepo;
    CandidateRepo candidateRepo;
    PartyRepo partyRepo;

    public VoteService(VoteRepo voteRepo, CandidateRepo candidateRepo, PartyRepo partyRepo) {
        this.voteRepo = voteRepo;
        this.candidateRepo = candidateRepo;
        this.partyRepo = partyRepo;
    }

    public List<VoteDTO> getVotes(String candidateId, String partyId, boolean totalPartyVotes) {
        if (candidateId != null) {
            int id = Integer.parseInt(candidateId);
            return VoteDTO.VoteDTOSfromVote(voteRepo.findAllByVotedCandidate_CandidateId(id));
        }
        else if (partyId != null && totalPartyVotes) {
            int id = Integer.parseInt(partyId);
            List<Vote> partyVotes = voteRepo.findAllByVotedParty_Id(id);
            List<Vote> candidateVotes = voteRepo.findAllByVotedCandidate_Party_Id(id);
            partyVotes.addAll(candidateVotes);
            return VoteDTO.VoteDTOSfromVote(partyVotes);
        }
        else if (partyId != null) {
            int id = Integer.parseInt(partyId);
            return VoteDTO.VoteDTOSfromVote(voteRepo.findAllByVotedParty_Id(id));
        }
        else {
            return VoteDTO.VoteDTOSfromVote(voteRepo.findAll());
        }
    }

    public VoteDTO getVote(int id) {
        Vote vote = voteRepo.findById(id).orElseThrow();
        return new VoteDTO(vote);
    }

    public VoteDTO addVote(String candidateId, String partyId) {
        if (candidateId != null) {
            Candidate candidate = candidateRepo.findById(Integer.parseInt(candidateId)).orElseThrow();
            return new VoteDTO (voteRepo.save(new Vote(candidate)));
        }
        else if (partyId != null) {
            Party party = partyRepo.findById(Integer.parseInt(partyId)).orElseThrow();
            return new VoteDTO (voteRepo.save(new Vote(party)));
        }
        else throw new IllegalArgumentException();
    }

}
