package tn.enis.outilsservice.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.enis.outilsservice.entity.Outil;

import java.util.Date;
import java.util.List;

public interface OutilRepository extends JpaRepository<Outil, Long> {
    // Exemple de méthode de recherche personnalisée par source
    List<Outil> findBySource(String source);

    // Exemple de méthode de recherche personnalisée par date
    List<Outil> findByDate(Date date);

    // Exemple de méthode de recherche personnalisée par membre

}
