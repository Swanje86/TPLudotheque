package fr.eni.tpludotheque.bll;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import fr.eni.tpludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientServiceImplTest {

    @Autowired
    ClientService clientService;

    @MockitoBean
    private ClientRepository clientRepository;

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

    @Test
    @DisplayName("Trouver les clients dont le nom commence par")
    public void testRechercheClientCommencantPar () {
        String nom = "DUP";
        Adresse adresse = new Adresse("rue des Cormorans", "44860", "Saint Aignan Grand Lieu");
        Client client1 = new Client("DUPIEUX", "Quentin", "e1",  adresse);
        Adresse adresse2 = new Adresse("rue 2", "44860", "Saint Aignan Grand Lieu");
        Client client2 = new Client("DUPONT", "Jacques", "e2", adresse2);

        List<Client> resultats = new ArrayList<>();
        resultats.add(client1);
        resultats.add(client2);
        when(clientRepository.findClientsByNomStartingWith(nom)).thenReturn(resultats);

        //Act
        List<Client> clients = clientService.trouverClientCommencantPar(nom);

        // Assert
        assertThat(clients).hasSize(2);


    }
}
