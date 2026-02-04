package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
