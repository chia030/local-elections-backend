package com.kea.local_elections.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kea.local_elections.entities.Party;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyDTO {

    int id;
    String partyId;
    String partyName;

    public PartyDTO(Party party) {
        this.id = party.getId();
        this.partyId = party.getPartyId();
        this.partyName = party.getPartyName();
    }

    public static List<PartyDTO> partyDTOSfromParty(Iterable<Party> parties) {
        List<PartyDTO> dtos = new ArrayList<>();
        for (Party party : parties) {
            PartyDTO aParty = new PartyDTO(party);
            dtos.add(aParty);
        }
        return dtos;
    }

    public static Party partyFromPartyDTO(PartyDTO party) {
        return new Party(party.getPartyId(), party.getPartyName());
    }

}
