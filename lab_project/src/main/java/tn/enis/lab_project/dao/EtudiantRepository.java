package tn.enis.lab_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.lab_project.entity.EnseignantChercheur;
import tn.enis.lab_project.entity.Etudiant;

import java.util.List;
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);
    List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
}
