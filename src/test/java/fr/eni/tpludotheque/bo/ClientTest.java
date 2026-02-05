package fr.eni.tpludotheque.bo;

import fr.eni.tpludotheque.dal.ClientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class ClientTest {

    @Test
    @DisplayName("test de creation client - cas droit")
    //Test JUnit
    public void testCreationClient() {
        Adresse adresse = new Adresse("rue de Konoha", "79000","KONOHA");
        Client client = new Client("UZUMAKI", "Naruto", "nuzumaki@mail.fr",adresse);
        Assertions.assertNotNull(client);
        Assertions.assertEquals("UZUMAKI", client.getNom());
        Assertions.assertEquals("Naruto", client.getPrenom());
        Assertions.assertEquals("nuzumaki@mail.fr", client.getEmail());
        Assertions.assertEquals(adresse, client.getAdresse());
    }

}
