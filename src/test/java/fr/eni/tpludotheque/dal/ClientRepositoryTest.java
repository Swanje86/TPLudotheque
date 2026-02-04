package fr.eni.tpludotheque.dal;

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
    @DisplayName("Test de création d'un client")
    public void testCreationClient() {
        // Arrange
        long nbClient = clientRepo.count();
        Client client = new Client("UZUMAKI", "Naruto", "nuzumaki@mail.fr");

        // Act
        clientRepo.save(client);

        // Assert
        assertNotNull(client.getNoClient());
        assertEquals(clientRepo.count(), nbClient+1);
    }
}