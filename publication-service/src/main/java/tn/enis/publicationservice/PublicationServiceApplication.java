package tn.enis.publicationservice;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.enis.publicationservice.dao.PublicationRepository;
import tn.enis.publicationservice.entity.Publication;
import tn.enis.publicationservice.service.IPublicationService;

import java.util.Date;
@AllArgsConstructor
@SpringBootApplication
public class PublicationServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PublicationServiceApplication.class, args);
	}
    PublicationRepository publicationRepository;
	IPublicationService publicationService;
	@Override
	public void run(String... args) throws Exception {

		Publication publication1 = Publication.builder()
				.type("type1")
				.titre("1ere pub")
				.lien("pub.com")
				.date(new Date())
				.sourcepdf("pdf1")
				.build();

        publication1 = publicationRepository.save(publication1);

		Publication publication = publicationRepository.findById(publication1.getId()).orElse(null);

		if (publication != null) {
			System.out.println("Type de la pub : " + publication.getType());
			System.out.println("Titre de la pub : " + publication.getTitre());
			System.out.println("Liende la pub : " + publication.getLien());
			System.out.println("Date de la pub : " + publication.getDate());
			System.out.println("Sourcepdf de la pub : " + publication.getSourcepdf());

		} else {
			System.out.println("Pub non trouvé.");
		}

	}
}
