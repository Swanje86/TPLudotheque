package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import fr.eni.tpludotheque.dto.ClientDTO;
import fr.eni.tpludotheque.exceptions.DataNotFound;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import tools.jackson.databind.util.BeanUtil;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {

    @NonNull
    // injection par constructeur pour couplage faible
    ClientRepository clientRepository;


    @Override
    public Client ajouterClient(Client client) {
        clientRepository.save(client);
        return client;
    }


    @Override
    public List<Client> trouverClientCommencantPar(String nom) {
        return clientRepository.findClientsByNomStartingWith(nom);
    }

    @Override
    public Client modifierClient(Integer noClient, ClientDTO clientDTO) {
        Client client = new Client();
        client.setNoClient(noClient);
        client.setAdresse(new Adresse());
        BeanUtils.copyProperties(clientDTO,client);
        BeanUtils.copyProperties(clientDTO,client.getAdresse());
        Client clientBD = null;
        try{
            clientBD=clientRepository.save(client);
                    }catch(OptimisticLockingFailureException e){
            throw new DataNotFound("Client", noClient);
        }

        return clientBD;


    }


}
