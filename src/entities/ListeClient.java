package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListeClient {

    public static ArrayList<Client> listeClient = new ArrayList<>();

    public ListeClient() {
    }

    public void ajouterClient(Client client) {
        listeClient.add(client);
    }

}
