package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Adresse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepo;

    @Test
    @DisplayName("Test de création d'une adresse")
    public void testCreationAdresse() {
        // Arrange
        long nbAdresse = adresseRepo.count();
        Adresse adresse = new Adresse("Rue Test", "79000", "TEST");

        // Act
        adresseRepo.save(adresse);

        // Assert
        assertNotNull(adresse.getNoAdresse());
        assertEquals(adresseRepo.count(), nbAdresse+1);

    }
}