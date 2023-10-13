package tn.enis.publicationservice.service;

import tn.enis.publicationservice.entity.Publication;

import java.util.List;

public interface IPublicationService {
    Publication addPublication(Publication publication);
    Publication findPublication(Long id);
    List<Publication> findAll();
    void deletePublication(Long id);
    Publication updatePublication(Publication publication);
}
