package entities;

import java.util.ArrayList;

/**
 * Classe représentant une liste de clients.
 * Elle permet de gérer un ensemble de clients, en fournissant des méthodes pour ajouter des clients à la liste.
 */
public class ListeClient {

    /** Liste statique contenant tous les clients. */
    public static final ArrayList<Client> listeClient = new ArrayList<>();



    /**
     * Ajoute un client à la liste des clients.
     *
     * @param client Le client à ajouter à la liste.
     */
    public static void ajouterClient(Client client) {

        listeClient.add(client);
    }

}

