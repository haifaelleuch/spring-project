package tn.enis.publicationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.publicationservice.entity.Publication;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByTitre(String titre);
    List<Publication> findByDate(Date date);
    List<Publication> findByLien(String lien);
    List<Publication> findByType(String type);
    List<Publication> findBySourcepdf(String sourcepdf);
}
