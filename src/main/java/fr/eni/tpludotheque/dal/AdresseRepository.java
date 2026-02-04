package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
}
