package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepo;

    @Test
    @DisplayName("Test de création d'un client avec une adresse")
    public void testCreationClient() {
        // Arrange
        long nbClient = clientRepo.count();
        Adresse adresse = new Adresse("rue de Konoha", "79000","KONOHA");


        Client client = new Client("UZUMAKI", "Naruto", "nuzumaki@mail.fr");
        client.setNoAdresse(adresse);

        // important pour la relation bidirectionnelle
        adresse.setClient(client);


        // Act
        clientRepo.save(client);

        // Assert
        assertNotNull(client.getNoClient());
        assertNotNull(client.getNoAdresse());
        assertEquals(nbClient + 1, clientRepo.count());
    }
}