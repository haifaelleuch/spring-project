package tn.enis.Evenementservice.entity;

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
public class Evenement {
    //les attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String titre;

    @NonNull
    private Date date;

    @NonNull
    private String lieu;

    @Builder

    public Evenement(Long id, @NonNull String titre, @NonNull Date date, @NonNull String lieu) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.lieu = lieu;
    }
}
