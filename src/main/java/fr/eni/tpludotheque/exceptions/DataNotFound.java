package fr.eni.tpludotheque.exceptions;

public class DataNotFound extends RuntimeException {
    public DataNotFound(String type, Object recherche){
        super ("L'élément recherché n'a pas été trouvé -type" + type + "-critère de recheche :"+ recherche);
    }
}
