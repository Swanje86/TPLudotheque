package fr.eni.tpludotheque.dal;

import fr.eni.tpludotheque.bo.Jeu;
import org.apache.tomcat.websocket.WsIOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootApplication
public class JeuRepositoryTest {

    @Autowired
    private JeuRepositoryTest jeuRepositoryTest;
    @Autowired
    private JeuRepository jeuRepository;

    @Test
    @DisplayName("Test de création de jeu")
    public void testCreationJeu (){
        //Arrange
        Jeu jeu = new Jeu("Jungle Speed","1254585454JSP",5);
        jeu.setAgeMin(7);
        jeu.setDescription("Description Jungle Speed");
        jeu.setDuree(35);

        //Act
        Jeu jeuBD = jeuRepository.save(jeu);

        //Assert
        assertNotNull(jeuBD);
        assertNotNull(jeuBD.getNoJeu());
        assertEquals ("Jungle Speed",jeuBD.getTitre());
        assertEquals("1254585454JSP",jeuBD.getReference());
        assertEquals(5,jeuBD.getTarifJour());

        //WIP




    }


}
