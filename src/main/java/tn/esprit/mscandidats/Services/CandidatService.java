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
        return null;
    }

    @Override
    public Candidat updateCandidat(int id, Candidat newCandidat) {
        return null;
    }

    @Override
    public String deleteCandidat(int id) {
        return "";
    }
}
