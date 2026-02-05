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
@Table(name="CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Integer noClient;

    @NonNull
    @Column(nullable = false, length = 50)
    private String nom;

    @NonNull
    @Column(nullable = false, length = 50)
    private String prenom;

    @NonNull
    @Column(nullable = false, length = 50, unique=true)
    private String email;

    @Column(length = 10)
    private String noTelephone;

    @NonNull
    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true,optional = false,
            fetch=FetchType.EAGER)
    @JoinColumn(name = "no_adresse", nullable = false)
    private Adresse adresse;


    }