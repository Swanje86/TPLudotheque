package fr.eni.tpludotheque.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    //permet de faire transiter les infos, pas format objet voir DTO Data Transfer Object (equivalent DataPage en PEGA)
    private String nom;
    private String prenom;
    private String email;
    private String noTelephone;

    private String rue;
    private String codePostal;
    private String ville;
}
