package entities;

import java.util.ArrayList;

/**
 * Classe représentant une liste de prospects.
 * Elle permet de gérer un ensemble de prospects, en fournissant des méthodes pour ajouter des prospects à la liste.
 */
public class ListeProspect {

    /** Liste statique contenant tous les prospects. */
    public static ArrayList<Client> listeProspect = new ArrayList<>();

    /**
     * Constructeur par défaut.
     * Permet de créer une instance de ListeProspect.
     */
    public ListeProspect() {}

    /**
     * Ajoute un prospect à la liste des prospects.
     *
     * @param client Le prospect à ajouter à la liste.
     */
    public void ajouterClient(Client client) {
        listeProspect.add(client);
    }

}
