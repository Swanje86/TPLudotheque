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
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noAdresse;

    @NonNull
    @Column(nullable = false, length = 50)
    private String rue;

    @NonNull
    @Column(nullable = false, length = 5)
    private String codePostal;

    @NonNull
    @Column(nullable = false, length = 50)
    private String ville;

    @OneToOne
    @JoinColumn (name = "no_client", nullable = false)
    private Client noClient;

}
