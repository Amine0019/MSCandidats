package tn.esprit.mscandidats.Services;

import tn.esprit.mscandidats.Entities.Candidat;

import java.util.List;

public interface ICandidatService {
    public List<Candidat> getAll();
    public Candidat addCandidat(Candidat candidate);
    public Candidat updateCandidat(int id, Candidat newCandidat);
    public String deleteCandidat(int id);
}
