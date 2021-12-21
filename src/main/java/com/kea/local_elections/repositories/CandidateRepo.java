package com.kea.local_elections.repositories;

import com.kea.local_elections.entities.Candidate;
import com.kea.local_elections.entities.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepo extends CrudRepository<Candidate,Integer> {
    List<Candidate> findAllByPartyId(int id);
}
