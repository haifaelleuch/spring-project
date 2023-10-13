package tn.enis.publicationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String type;

    @NonNull
    private String titre;

    @NonNull
    private String lien;

    @NonNull
    private Date date;

    @NonNull
    private String sourcepdf;

    @Builder

    public Publication(Long id, @NonNull String type, @NonNull String titre, @NonNull String lien, @NonNull Date date, @NonNull String sourcepdf) {
        this.id = id;
        this.type = type;
        this.titre = titre;
        this.lien = lien;
        this.date = date;
        this.sourcepdf = sourcepdf;
    }
}