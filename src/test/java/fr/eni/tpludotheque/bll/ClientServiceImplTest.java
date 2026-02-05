package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceImplTest {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Test
    void testCreationClient () {
        // Arrange
        Adresse adresse = new Adresse("rue de Konoha", "79000","KONOHA");
        Client client = new Client("UZUMAKI", "Naruto", "nuzumaki@mail.fr",adresse);

        //Act
        clientService.ajouterClient(client);

        // Assert
        Client clientBD = clientRepository.findById(client.getNoClient()).orElse(null);
        Assertions.assertNotNull(clientBD);
        Assertions.assertEquals(client, clientBD);


    }
}
