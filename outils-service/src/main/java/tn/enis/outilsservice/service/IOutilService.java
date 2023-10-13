package tn.enis.outilsservice.service;

import tn.enis.outilsservice.entity.Outil;

import java.util.List;

public interface IOutilService {
    Outil addOutil(Outil outil);
    Outil findOutil(Long id);
    List<Outil> findAll();
    public void deleteOutil(Long id);
    public Outil updateOutil(Outil outil);}
