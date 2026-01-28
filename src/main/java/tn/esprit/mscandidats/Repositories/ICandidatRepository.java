package tn.esprit.mscandidats.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.mscandidats.Entities.Candidat;

public interface ICandidatRepository extends JpaRepository<Candidat, Integer> {
}
