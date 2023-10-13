package tn.enis.publicationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.enis.publicationservice.entity.Publication;
import tn.enis.publicationservice.service.IPublicationService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class PublicationRestController {
    IPublicationService publicationService;

    @RequestMapping(value = "/publications", method = RequestMethod.GET)
    public List<Publication> findAllPublications() {
        return publicationService.findAll();
    }

    @GetMapping(value = "/publications/{id}")
    public Publication findPublicationById(@PathVariable Long id) {
        return publicationService.findPublication(id);
    }

    @PostMapping(value = "/publications")
    public Publication addPublication(@RequestBody Publication publication) {
        return publicationService.addPublication(publication);
    }

    @DeleteMapping(value = "/publications/{id}")
    public void deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
    }

    @PutMapping(value = "/publications/{id}")
    public Publication updatePublication(@PathVariable Long id, @RequestBody Publication publication) {
        publication.setId(id);
        return publicationService.updatePublication(publication);
    }
}
