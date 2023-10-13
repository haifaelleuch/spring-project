package tn.enis.Evenementservice.service;

import tn.enis.Evenementservice.entity.Evenement;

import java.util.List;

public interface IEvenementService {
    Evenement addEvenement(Evenement eve);
    Evenement findEvenement(Long id);
    List<Evenement> findAll();
    public void deleteEvenement(Long id);
    public Evenement updateEvenement(Evenement eve);


}
