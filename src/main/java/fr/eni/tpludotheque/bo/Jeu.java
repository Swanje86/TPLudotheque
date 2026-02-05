package fr.eni.tpludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="JEUX")
public class Jeu {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="no_jeu")
    @EqualsAndHashCode.Exclude
    private Integer noJeu;

    @NonNull
    @Column(nullable = false, length = 50)
    private String titre;

    @NonNull
    @Column(nullable = false, length = 13, unique = true)
    private String reference;

    @Column(nullable = true, length = 2)
    private Integer ageMin;


    private String description;


    private int duree;

    @NonNull
    @Column(nullable = false, length = 3)
    private Integer tarifJour;





}
