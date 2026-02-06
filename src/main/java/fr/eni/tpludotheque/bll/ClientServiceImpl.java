package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    // injection par constructeur pour couplage faible
    ClientRepository clientRepository;


    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client ajouterClient(Client client) {
        clientRepository.save(client);
        return client;
    }


    @Override
    public List<Client> trouverClientCommencantPar(String nom) {
        return clientRepository.findClientsByNomStartingWith(nom);
    }



}
