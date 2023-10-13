package tn.enis.Evenementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.Evenementservice.entity.Evenement;

import java.util.Date;
import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    List<Evenement> findByTitre(String titre);
    List<Evenement> findByDate(Date date);
    List<Evenement> findByLieu(String lieu);


}
