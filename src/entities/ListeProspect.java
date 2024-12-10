package entities;

import java.util.ArrayList;

/**
 * Classe représentant une liste de prospects.
 * Elle permet de gérer un ensemble de prospects, en fournissant des méthodes pour ajouter des prospects à la liste.
 */
public class ListeProspect {

    /** Liste statique contenant tous les prospects. */
    public static final ArrayList<Client> listeProspect = new ArrayList<>();



    /**
     * Ajoute un prospect à la liste des prospects.
     *
     * @param client Le prospect à ajouter à la liste.
     */
    public void ajouterClient(Client client) {
        listeProspect.add(client);
    }

}
