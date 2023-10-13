package tn.enis.lab_project.service;

import tn.enis.lab_project.entity.EnseignantChercheur;
import tn.enis.lab_project.entity.Etudiant;
import tn.enis.lab_project.entity.Membre;

import java.util.List;

public interface IMembreService {
    //Crud sur les membres
    public Membre addMember(Membre m);
    public void deleteMember(Long id) ;
    public Membre updateMember(Membre p) ;
    public Membre findMember(Long id) ;
    public List<Membre> findAll();
    //Filtrage par propriété
    public Membre findByCin(String cin) throws Exception;
    public Membre findByEmail(String email);
    public List<Membre> findByNom(String nom);
    //recherche spécifique des étudiants
    public List<Etudiant> findByDiplome(String diplome);
    //recherche spécifique des enseignants
    public List<EnseignantChercheur> findByGrade(String grade);
    public List<EnseignantChercheur> findByEtablissement(String etablissement);
    public void affecterEtudianttoEnseignantChercheur(Long idEtud,Long idEns);
    public List<Etudiant> findEtudiantsEncadresParEnseignant(Long idEns);
//other ...
}

