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
@Table(name="GENRES")
public class Genre {

    @Id
    @NonNull private Integer noGenre;
    @NonNull private String libelle;

}
