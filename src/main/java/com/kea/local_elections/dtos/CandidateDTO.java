package com.kea.local_elections.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kea.local_elections.entities.Candidate;
import com.kea.local_elections.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CandidateDTO {

    int candidateId;
    String fullName;
    Party party;

    public CandidateDTO(String fullName, Party party) {
        this.fullName = fullName;
        this.party = party;
    }

    public CandidateDTO(Candidate candidate) {
        this.candidateId = candidate.getCandidateId();
        this.fullName = candidate.getFullName();
        this.party = candidate.getParty();
    }

    public static List<CandidateDTO> CandidateDTOSfromCandidate(Iterable<Candidate> candidates) {
        List<CandidateDTO> dtos = new ArrayList<>();
        for(Candidate candidate : candidates) {
            CandidateDTO aCandidate = new CandidateDTO(candidate);
            dtos.add(aCandidate);
        }
        return dtos;
    }

    public static Candidate candidateFromCandidateDTO(CandidateDTO candidate) {
        return new Candidate(candidate.getFullName(), candidate.getParty());
    }

}
