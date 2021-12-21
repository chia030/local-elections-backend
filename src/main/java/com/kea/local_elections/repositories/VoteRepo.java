package com.kea.local_elections.repositories;

import com.kea.local_elections.entities.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteRepo extends CrudRepository<Vote,Integer> {
    List<Vote> findAllByVotedCandidate_CandidateId(int candidateId);
    List<Vote> findAllByVotedParty_Id(int id);
    List<Vote> findAllByVotedCandidate_Party_Id(int id);
}
