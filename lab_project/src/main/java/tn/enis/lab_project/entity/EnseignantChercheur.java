package tn.enis.lab_project.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@DiscriminatorValue("ens")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnseignantChercheur extends Membre{
    @NonNull
    private String grade;
    @NonNull
    private String etablissement;
@Builder

    public EnseignantChercheur(Long id, @NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance, byte[] photo,
                               @NonNull String Cv, @NonNull String email,
                               @NonNull String password, @NonNull String grade, @NonNull String etablissement) {
        super(id, cin, nom, prenom, dateNaissance, photo, Cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
    }
}
