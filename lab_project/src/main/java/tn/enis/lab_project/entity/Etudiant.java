package tn.enis.lab_project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("etd")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Etudiant extends Membre{
    @NonNull
    @Temporal(TemporalType.DATE)
    private Date dateInscription;



    @NonNull
    private String diplome;
    @NonNull
    private String sujet;
    @ManyToOne
    private EnseignantChercheur encadrant;
    @Builder
    public Etudiant(Long id, @NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance,  byte[] photo,
                    @NonNull String Cv, @NonNull String email, @NonNull String password, @NonNull Date dateInscription,
                    @NonNull String diplome, @NonNull String sujet, EnseignantChercheur encadrant) {
        super(id, cin, nom, prenom, dateNaissance, photo, Cv, email, password);
        this.dateInscription = dateInscription;
        this.diplome = diplome;
        this.sujet = sujet;
        this.encadrant = encadrant;
    }

}