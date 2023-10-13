package tn.enis.lab_project.service;

import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import tn.enis.lab_project.dao.EnseignantChercheurRepository;
import tn.enis.lab_project.dao.EtudiantRepository;
import tn.enis.lab_project.dao.MembreRepository;
import tn.enis.lab_project.entity.EnseignantChercheur;
import tn.enis.lab_project.entity.Etudiant;
import tn.enis.lab_project.entity.Membre;

import java.util.List;

@Service
@AllArgsConstructor
public class MembreImpl implements IMembreService{
    MembreRepository membreRepository;
    EtudiantRepository etudiantRepository;
    EnseignantChercheurRepository enseignantChercheurRepository;



    @Override
    public Membre addMember(Membre m) {
        membreRepository.save(m);
        return m;
    }

    @Override
    public void deleteMember(Long id) {
        membreRepository.deleteById(id);
    }

    @Override
    public Membre updateMember(Membre m) {
        return membreRepository.saveAndFlush(m);    }

    @Override
    public Membre findMember(Long id) {
        Membre m= (Membre)membreRepository.findById(id).get();
        return m;
    }

    @Override
    public List<Membre> findAll() {
        List<Membre> mbrs=membreRepository.findAll();

        return mbrs;

    }

    @Override
    public Membre findByCin(String cin)  {
            Membre membre = membreRepository.findByCin(cin);



            return membre;
        }



    @Override
    public Membre findByEmail(String email) {
        Membre membre = membreRepository.findByEmail(email);
        return membre;
    }

    @Override
    public List<Membre> findByNom(String nom) {
        return (List<Membre>) membreRepository.findByNom(nom);

    }

    @Override
    public List<Etudiant> findByDiplome(String diplome) {
        return (List<Etudiant>) etudiantRepository.findByDiplome(diplome);
    }

    @Override
    public List<EnseignantChercheur> findByGrade(String grade) {
        return (List<EnseignantChercheur>) enseignantChercheurRepository.findByGrade(grade);
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement(String etablissement) {
        return (List<EnseignantChercheur>) enseignantChercheurRepository.findByEtablissement(etablissement);
    }
    public void affecterEtudianttoEnseignantChercheur(Long idEtud,Long idEns){
        Etudiant etd = etudiantRepository.findById(idEtud).get();
        EnseignantChercheur ens =enseignantChercheurRepository.findById(idEns).get();
        etd.setEncadrant(ens);
        etudiantRepository.save(etd);


    }
    public List<Etudiant> findEtudiantsEncadresParEnseignant(Long idEns){
        EnseignantChercheur enseignant = enseignantChercheurRepository.findById(idEns).get();
        return etudiantRepository.findByEncadrant(enseignant);



    }
}
