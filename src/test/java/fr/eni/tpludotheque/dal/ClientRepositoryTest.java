package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Adresse;
import fr.eni.tpludotheque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("test positif de creation d'un client en BD")
    @Transactional
    public void testCreationClient() {
        // Arrange
        Adresse adresse = new Adresse("rue de Konoha", "79000","KONOHA");
        Client client = new Client("UZUMAKI", "Naruto", "nuzumaki@mail.fr",adresse);


        //Act
        Client clientBD = clientRepository.save(client);

        //Assert
        assertNotNull(clientBD);
        assertNotNull(clientBD.getNoClient());
        assertEquals("UZUMAKI", clientBD.getNom());
        assertEquals("Naruto", clientBD.getPrenom());
        assertEquals("nuzumaki@mail.fr", clientBD.getEmail());
        assertNotNull(clientBD.getAdresse().getNoAdresse());
        assertEquals(adresse, clientBD.getAdresse());
    }
}