package com.kea.local_elections.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "candidates")
@Getter @Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int candidateId;

    @Column(columnDefinition = "VARCHAR(80)", nullable = false)
    private String fullName;

    @ManyToOne
    @JsonManagedReference
    Party party;

    @OneToMany(orphanRemoval = true, mappedBy = "votedCandidate")
    @JsonBackReference
    List<Vote> votes;

    public Candidate() {}

    public Candidate(String fullName, Party party) {
        this.fullName = fullName;
        this.party = party;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return candidateId == candidate.candidateId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateId);
    }
}
