package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findClientsByNomStartingWith(String nom);

}
