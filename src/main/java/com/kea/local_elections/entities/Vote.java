package com.kea.local_elections.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "votes")
@Getter @Setter
public class Vote {

    @Id
    @GeneratedValue
    private int voteId;

//    @Column(length = 3, nullable = true)
//    private int votedCandidate;

    @ManyToOne
    @JsonManagedReference
    Party votedParty;

    @ManyToOne
    @JsonManagedReference
    Candidate votedCandidate;

//    @Column(length = 1, nullable = true)
//    private String votedPartyId;

    public Vote() {}

    public Vote(Party votedParty) {
        this.votedParty = votedParty;
    }

    public Vote(Candidate votedCandidate) {
        this.votedCandidate = votedCandidate;
    }

    public Vote(Party votedParty, Candidate votedCandidate) {
        this.votedParty = votedParty;
        this.votedCandidate = votedCandidate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return voteId == vote.voteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteId);
    }
}
