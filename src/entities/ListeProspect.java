package entities;

import java.util.ArrayList;

public class ListeProspect {

    public static ArrayList<Client> listeProspect = new ArrayList<>();

    public ListeProspect() {
    }

    public void ajouterClient(Client client) {
        listeProspect.add(client);
    }
}
