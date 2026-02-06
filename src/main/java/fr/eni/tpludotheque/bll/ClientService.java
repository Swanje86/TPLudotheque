package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;

import java.util.List;


public interface ClientService {

    //S2008 - Couche BLL : ajouter un client et son adresse
    public Client ajouterClient (Client client);

    //S2009 - Couche BLL : trouver les clients dont le nom commence par la chaine fournie
    public List<Client> trouverClientCommencantPar(String Nom);
}
