package com.kea.local_elections.services;

import com.kea.local_elections.dtos.PartyDTO;
import com.kea.local_elections.entities.Party;
import com.kea.local_elections.repositories.PartyRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    PartyRepo partyRepo;

    public PartyService(PartyRepo partyRepo) {
        this.partyRepo = partyRepo;
    }

    public List<PartyDTO> getParties() {
        return PartyDTO.partyDTOSfromParty(partyRepo.findAll());
    }

    public PartyDTO getParty(int id) {
        Party party = partyRepo.findById(id).orElseThrow();
        return new PartyDTO(party);
    }

}
