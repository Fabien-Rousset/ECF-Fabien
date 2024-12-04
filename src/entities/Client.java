package entities;

import java.util.Collections;
import java.util.Comparator;

public class Client {

    private double chiffreAffaire;
    private int nbEmploye;

    private static int idClient = 1;

    public Client() {}

    public Client(double chiffreAffaire, int nbEmploye) {
        setChiffreAffaire(chiffreAffaire);
        setNbEmploye(nbEmploye);
    }

    public void ajouterClient(Client client) {
        listeClient.add(client);
    }

    public static Comparator<Client> comparerParNom = new Comparator<Client>(){
        @Override
        public int compare(Client c1, Client c2){
            return c1.getRaisonSocialeSociete().compareTo(c2.getgetRaisonSocialeSociete());
        }
    };

    public void trierParNomClient(){
        Collections.sort(listeClient, comparerParNom);
    }

    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public int getNbEmploye() {
        return nbEmploye;
    }

    public void setNbEmploye(int nbEmploye) {
        this.nbEmploye = nbEmploye;
    }

    public static int getIdClient() {
        return idClient;
    }

    public static void setIdClient(int idClient) {
        Client.idClient = idClient;
    }
}
