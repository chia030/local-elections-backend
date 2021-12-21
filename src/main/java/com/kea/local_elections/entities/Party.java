package com.kea.local_elections.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity(name = "parties")
@Getter @Setter
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 1, nullable = false)
    private String partyId;

    @Column(length = 60, nullable = false)
    private String partyName;

    @OneToMany(orphanRemoval = true, mappedBy = "party")
    @JsonBackReference
    List<Candidate> candidates;

    @OneToMany(orphanRemoval = true, mappedBy = "votedParty")
    @JsonBackReference
    List<Vote> votes;

    public Party() {}

    public Party(String partyId, String partyName) {
        this.partyId = partyId;
        this.partyName = partyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return id == party.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

}
