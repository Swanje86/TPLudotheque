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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noClient;

    @NonNull
    @Column(nullable = false, length = 50)
    private String nom;

    @NonNull
    @Column(nullable = false, length = 50)
    private String prenom;

    @NonNull
    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = true, length = 10)
    private String noTelephone;

    @OneToOne
    @JoinColumn(name = "no_adresse", nullable = false)
    private Adresse noAdresse;


}