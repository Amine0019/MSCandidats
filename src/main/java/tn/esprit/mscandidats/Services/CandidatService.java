package tn.esprit.mscandidats.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.mscandidats.Entities.Candidat;
import tn.esprit.mscandidats.Repositories.ICandidatRepository;

import java.util.List;
@Service
public class CandidatService implements ICandidatService {


    @Autowired
    private ICandidatRepository candidatRepository;

    @Override
    public List<Candidat> getAll() {
        return candidatRepository.findAll();
    }

    @Override
    public Candidat addCandidat(Candidat candidate) {
        return candidatRepository.save(candidate);

    }

    @Override
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidatRepository.findById(id).isPresent()) {
            Candidat existingCandidat = candidatRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());
            return candidatRepository.save(existingCandidat);
        } else
            return null;

    }

    @Override
    public String deleteCandidat(int id) {
        if (candidatRepository.findById(id).isPresent()) {
            candidatRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }

}
