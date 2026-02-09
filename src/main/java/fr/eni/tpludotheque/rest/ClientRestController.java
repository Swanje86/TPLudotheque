package fr.eni.tpludotheque.rest;

import fr.eni.tpludotheque.bll.ClientService;
import fr.eni.tpludotheque.bo.Client;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    //S3019 - API REST pour : ajouter un client
    @PostMapping
    public ResponseEntity<Client> ajouterClient(@Valid @RequestBody Client client, BindingResult bindingResult) {
        /*if (bindingResult.hasErrors()){
            return ResponseEntity.status((HttpStatus.BAD_REQUEST)
                    .body(null);
        }*/

        Client ajouterClient = clientService.ajouterClient(client);
        return  ResponseEntity.status(HttpStatus.CREATED).header("Création","/api/clients" + ajouterClient.getNoClient())
                .body(ajouterClient);
    }


}
