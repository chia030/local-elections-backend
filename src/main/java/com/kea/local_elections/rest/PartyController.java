package com.kea.local_elections.rest;

import com.kea.local_elections.dtos.PartyDTO;
import com.kea.local_elections.services.PartyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/parties")
public class PartyController {

    PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    List<PartyDTO> getParties() {
        return partyService.getParties();
    }

    @GetMapping("/{id}")
    PartyDTO getParty(@PathVariable int id) {
        return partyService.getParty(id);
    }

}
