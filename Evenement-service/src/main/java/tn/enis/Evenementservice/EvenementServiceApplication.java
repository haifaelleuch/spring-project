package tn.enis.Evenementservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.enis.Evenementservice.dao.EvenementRepository;
import tn.enis.Evenementservice.entity.Evenement;
import tn.enis.Evenementservice.service.IEvenementService;

import java.util.Date;
@AllArgsConstructor
@SpringBootApplication
public class EvenementServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EvenementServiceApplication.class, args);
	}
    EvenementRepository evenementRepository;
	IEvenementService evenementService;
	@Override
	public void run(String... args) throws Exception {
		Evenement evenement1 = Evenement.builder()
				.titre("Mon événement")
				.date(new Date())
				.lieu("Lieu de l'événement")
				.build();

// Sauvegardez l'événement dans la base de données
		evenement1 = evenementRepository.save(evenement1);

// Récupérez l'événement par son ID
		Evenement evenement = evenementRepository.findById(evenement1.getId()).orElse(null);

		if (evenement != null) {
			System.out.println("Titre de l'événement : " + evenement.getTitre());
			System.out.println("Date de l'événement : " + evenement.getDate());
			System.out.println("Lieu de l'événement : " + evenement.getLieu());
		} else {
			System.out.println("Événement non trouvé.");
		}

	}
}
