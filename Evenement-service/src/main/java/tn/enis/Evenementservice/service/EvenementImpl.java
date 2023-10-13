package tn.enis.Evenementservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.enis.Evenementservice.dao.EvenementRepository;
import tn.enis.Evenementservice.entity.Evenement;

import java.util.List;
@Service
@AllArgsConstructor
public class EvenementImpl implements  IEvenementService
{
    EvenementRepository evenementRepository;
    @Override
    public Evenement addEvenement(Evenement eve) {
        evenementRepository.save(eve) ;
        return eve;
    }

    @Override
    public Evenement findEvenement(Long id) {
        Evenement eve=(Evenement) evenementRepository.findById(id).get();
        return eve;
    }

    @Override
    public List<Evenement> findAll() {
        List<Evenement> eves=(List<Evenement>) evenementRepository.findAll();
        return eves;
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);

    }

    @Override
    public Evenement updateEvenement(Evenement eve) {
        return evenementRepository.saveAndFlush(eve);
    }
}
