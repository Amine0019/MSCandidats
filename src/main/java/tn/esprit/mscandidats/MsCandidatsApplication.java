package tn.esprit.mscandidats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.mscandidats.Entities.Candidat;
import tn.esprit.mscandidats.Repositories.ICandidatRepository;

@SpringBootApplication
public class MsCandidatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsCandidatsApplication.class, args);
    }
    @Autowired
    ICandidatRepository candidatRepository;

    @Bean
    ApplicationRunner init() {
        return
                (args) -> {
                    // Vérifier si le repository est vide
                    if (candidatRepository.count() == 0) {
                        candidatRepository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
                        candidatRepository.save(new Candidat("Sarra", "ab", "sa@esprit.tn"));
                        candidatRepository.save(new Candidat("Mohamed", "ba", "mo@esprit.tn"));
                        candidatRepository.save(new Candidat("Maroua", "dh", "maroua@esprit.tn"));
                    }
                    // Affichage
                    candidatRepository.findAll().forEach(System.out::println);
                };
    }

}
