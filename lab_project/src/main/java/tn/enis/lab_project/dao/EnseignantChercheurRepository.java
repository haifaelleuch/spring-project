package tn.enis.lab_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.lab_project.entity.EnseignantChercheur;

import java.util.List;

public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur,Long> {
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur>findByEtablissement(String etablissement);
}
