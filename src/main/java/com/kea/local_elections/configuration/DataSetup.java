package com.kea.local_elections.configuration;

import com.kea.local_elections.entities.Candidate;
import com.kea.local_elections.entities.Party;
import com.kea.local_elections.entities.Vote;
import com.kea.local_elections.repositories.CandidateRepo;
import com.kea.local_elections.repositories.PartyRepo;
import com.kea.local_elections.repositories.VoteRepo;
import com.kea.local_elections.rest.CandidateController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetup implements CommandLineRunner {

    private CandidateRepo candidateRepo;
    private PartyRepo partyRepo;
    private VoteRepo voteRepo;

    public DataSetup(CandidateRepo candidateRepo, PartyRepo partyRepo, VoteRepo voteRepo) {
        this.candidateRepo = candidateRepo;
        this.partyRepo = partyRepo;
        this.voteRepo = voteRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        // wipe previous data
        partyRepo.deleteAll();
        candidateRepo.deleteAll();
        voteRepo.deleteAll();

        // create parties
        Party p1 = partyRepo.save(new Party("A", "Socialdemokratiet"));
        Party p2 = partyRepo.save(new Party("C", "Det konservative Folkeparti"));
        Party p3 = partyRepo.save(new Party("F", "SF, Socialistisk Folkeparti"));
        Party p4 = partyRepo.save(new Party("O", "Dansk Folkeparti"));
        Party p5 = partyRepo.save(new Party("V", "Venstre, Danmarks Liberale Parti"));
        Party p6 = partyRepo.save(new Party("Ø", "Enhedslisten + De Rød Grønn"));

        // create candidates
        Candidate c1 = candidateRepo.save(new Candidate("Marcel Meijer", p1));
        candidateRepo.save(new Candidate("Michael Kristensen", p1));
        candidateRepo.save(new Candidate("Helle Hansen", p1));
        candidateRepo.save(new Candidate("Karina Knobelauch", p1));
        candidateRepo.save(new Candidate("Stefan Hafstein Wolffbrandt", p1));
        candidateRepo.save(new Candidate("Robert V. Rasmussen", p1));
        candidateRepo.save(new Candidate("Pia Ramsing", p1));
        candidateRepo.save(new Candidate("Anders Baun Sørensen", p1));

        Candidate c2 = candidateRepo.save(new Candidate("Per Urban Olsen", p2));
        candidateRepo.save(new Candidate("Peter Askjær", p2));
        candidateRepo.save(new Candidate("Martin Sørensen", p2));
        candidateRepo.save(new Candidate("Louise Bramstorp", p2));
        candidateRepo.save(new Candidate("Sigfred Jensen", p2));
        candidateRepo.save(new Candidate("Jørn C. Nissen", p2));
        candidateRepo.save(new Candidate("Morten Ø. Kristensen", p2));
        candidateRepo.save(new Candidate("Susanne Andersen", p2));
        candidateRepo.save(new Candidate("Iulian V. Paiu", p2));
        candidateRepo.save(new Candidate("Per Hingel", p2));

        Candidate c3 = candidateRepo.save(new Candidate("Ulla Holm", p3));
        candidateRepo.save(new Candidate("Kjeld Bønkel", p3));
        candidateRepo.save(new Candidate("Anne Grethe Olsen", p3));
        candidateRepo.save(new Candidate("Lone Krag", p3));
        candidateRepo.save(new Candidate("Børge S. Buur", p3));

        Candidate c4 = candidateRepo.save(new Candidate("Per Mortensen", p4));

        Candidate c5 = candidateRepo.save(new Candidate("Søren Wiese", p5));
        candidateRepo.save(new Candidate("Anita Elgaard Højholt Olesen", p5));
        candidateRepo.save(new Candidate("Carsten Bruun", p5));
        candidateRepo.save(new Candidate("Mogens Exner", p5));
        candidateRepo.save(new Candidate("Anja Guldborg", p5));
        candidateRepo.save(new Candidate("Klaus Holdorf", p5));

        Candidate c6 = candidateRepo.save(new Candidate("Katrine Høegh Mc Quaid", p6));
        candidateRepo.save(new Candidate("Jette M. Søgaard", p6));
        candidateRepo.save(new Candidate("Søren Caspersen", p6));
        candidateRepo.save(new Candidate("Pia Birkmand", p6));

        // create votes (sample, added via the web interface later on)

        //candidate votes
        voteRepo.save(new Vote(c1));
        voteRepo.save(new Vote(c2));
        voteRepo.save(new Vote(c3));
        voteRepo.save(new Vote(c4));
        voteRepo.save(new Vote(c5));
        voteRepo.save(new Vote(c6));
        //party votes
        voteRepo.save(new Vote(p1));
        voteRepo.save(new Vote(p2));
        voteRepo.save(new Vote(p3));
        voteRepo.save(new Vote(p4));
        voteRepo.save(new Vote(p5));
        voteRepo.save(new Vote(p6));

    }
}
