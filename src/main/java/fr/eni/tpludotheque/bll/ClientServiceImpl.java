package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    // injection par constructeur pour couplage faible
    ClientRepository clientRepository;


    public ClientServiceImpl (ClientRepository clientRepository){
        this.clientRepository= clientRepository;
    }

    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);


    }
}
