package com.kea.local_elections.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kea.local_elections.entities.Candidate;
import com.kea.local_elections.entities.Party;
import com.kea.local_elections.entities.Vote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VoteDTO {

    int voteId;
    Candidate votedCandidate;
    Party votedParty;

    public VoteDTO(Candidate votedCandidate, Party votedParty) {
        this.votedCandidate = votedCandidate;
        this.votedParty = votedParty;
    }

    public VoteDTO(Vote vote) {
        this.voteId = vote.getVoteId();
        this.votedCandidate = vote.getVotedCandidate();
        this.votedParty = vote.getVotedParty();
    }

    public static List<VoteDTO> VoteDTOSfromVote(Iterable<Vote> votes) {
        List<VoteDTO> dtos = new ArrayList<>();
        for(Vote vote : votes) {
            VoteDTO aVote = new VoteDTO(vote);
            dtos.add(aVote);
        }
        return dtos;
    }

    public static Vote voteFromVoteDTO(VoteDTO vote) {
        return new Vote(vote.getVotedParty(), vote.getVotedCandidate());
    }
}
