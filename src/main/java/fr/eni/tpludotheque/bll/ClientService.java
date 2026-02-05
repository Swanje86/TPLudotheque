package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import org.springframework.stereotype.Service;


public interface ClientService {

    void ajouterClient (Client client);
}
