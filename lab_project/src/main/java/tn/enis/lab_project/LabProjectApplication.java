package tn.enis.lab_project;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;
import tn.enis.lab_project.dao.EnseignantChercheurRepository;
import tn.enis.lab_project.dao.MembreRepository;
import tn.enis.lab_project.entity.EnseignantChercheur;
import tn.enis.lab_project.entity.Etudiant;
import tn.enis.lab_project.entity.Membre;
import tn.enis.lab_project.service.IMembreService;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@AllArgsConstructor
public class LabProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LabProjectApplication.class, args);
	}
      MembreRepository membreRepository;
	EnseignantChercheurRepository echRepository;
	IMembreService membreService;
	@Override
	public void run(String... args) throws Exception {

	Etudiant etd1=Etudiant.builder()
			.cin("123456")
			.dateInscription(new Date())
			.dateNaissance(new Date())
			.diplome("mastère")
			.email("etd1@gmail.com")
			.password("pass1")
			.encadrant(null)
			.Cv("cv1")
			.nom("abid")
			.prenom("youssef)")
			.sujet("blockhain")
			.build();
	membreRepository.save(etd1);
		Etudiant etd2=Etudiant.builder()
				.cin("123457")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("ingenieur")
				.email("etd2@gmail.com")
				.password("pass2")
				.encadrant(null)
				.Cv("cv2")
				.nom("tayaro")
				.prenom("goofy")
				.sujet("devops")
				.build();
		membreRepository.save(etd2);
		EnseignantChercheur Ech1=EnseignantChercheur.builder()
				.cin("123458")
				.grade("Professor")
				.dateNaissance(new Date())
				.etablissement("ENIS")
				.email("ech@gmail.com")
				.password("pass3")
				.Cv("cv3")
				.nom("elleuch")
				.prenom("haifa")
				.build();
		membreRepository.save(Ech1);
		EnseignantChercheur Ech2=EnseignantChercheur.builder()
				.cin("123459")
				.grade("Professor")
				.dateNaissance(new Date())
				.etablissement("ENIS")
				.email("ech2@gmail.com")
				.password("pass4")
				.Cv("cv4")
				.nom("elleuch")
				.prenom("haifoucha")
				.build();
		membreRepository.save(Ech2);
	List<Membre> mbrs=membreRepository.findAll();
	for(Membre membre : mbrs){
		System.out.println(membre.getNom()+" ");
	}
	for (Membre membre : mbrs){
		System.out.println(membre.getCin()+" "+membre.getEmail());


	}
	//chercher un membre par son Id
	Membre m1= membreRepository.findById(2L).get();
		System.out.println(m1.getNom());
	//modifier un membre
		m1.setEmail("oussama.tayaro@enis.tn");
		membreRepository.save(m1);
		Membre m2 = membreRepository.findByNomAndPrenom("tayaro", "goofy");
		if (m2 != null) {
			System.out.println(m2.getCin());
		} else {
			System.out.println("Aucun membre trouvé pour les critères de recherche.");
		}
		System.out.println(m2.getCin());
		mbrs= membreRepository.findByNomStartingWith("t");
		for(Membre membre : mbrs){
			System.out.println(membre.getDateNaissance());
		}
		List<EnseignantChercheur>Ech=echRepository.findByGrade("Professor");
		for(EnseignantChercheur enscher : Ech){
			System.out.println(enscher.getCin());

		}
		//membreRepository.deleteById(1L);
        Membre membre= membreService.findMember(1L);
		membre.setCv("cvvvv.pdf");
		membreService.updateMember(membre);

        membreService.affecterEtudianttoEnseignantChercheur(1L,3L);
		membreService.affecterEtudianttoEnseignantChercheur(2L,3L);
Long idEnseignant=3L;
		EnseignantChercheur enseignant = echRepository.findById(idEnseignant).orElse(null);
		String prenomEnseignant = (enseignant != null) ? enseignant.getPrenom() : "Enseignant introuvable";
		List<Etudiant> etudiantsEncadres = membreService.findEtudiantsEncadresParEnseignant(3L); // Remplacez 3L par l'ID de l'enseignant que vous souhaitez tester


		System.out.println("Étudiants encadrés par l'enseignant :"+prenomEnseignant);
		for (Etudiant etudiant : etudiantsEncadres) {
			System.out.println(etudiant.getNom() + " " + etudiant.getPrenom());
		}


	}
}
