package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository <Jeu, Integer> {
}
