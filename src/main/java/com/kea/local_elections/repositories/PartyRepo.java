package com.kea.local_elections.repositories;

import com.kea.local_elections.dtos.PartyDTO;
import com.kea.local_elections.entities.Party;
import org.springframework.data.repository.CrudRepository;

public interface PartyRepo extends CrudRepository<Party,Integer> {
}
