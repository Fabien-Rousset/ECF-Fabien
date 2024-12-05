package entities;

import java.util.Collections;
import java.util.Comparator;

import static entities.ListeClient.listeClient;

public class Client {

    private double chiffreAffaire;
    private int nbEmploye;

    private static int idClient = 1;

    public Client() {}

    public Client(double chiffreAffaire, int nbEmploye) {
        setChiffreAffaire(chiffreAffaire);
        setNbEmploye(nbEmploye);
    }

    public static boolean verifierRaisonSocialeUnique(String raisonSociale) {
        for (Client client : ListeClient.listeClient) {
            if (client instanceof Societe) {
                if (((Societe) client).getRaisonSocialeSociete().equals(raisonSociale)) {
                    return false;
                }
            }
        }
        return true;
    }


//    public static Comparator<Client> comparerParNom = new Comparator<Client>(){
//        @Override
//        public int compare(Client c1, Client c2){
//            return c1.getRaisonSocialeSociete().compareTo(c2.getgetRaisonSocialeSociete());
//        }
//    };
//
//    public void trierParNomClient(){
//        Collections.sort(listeClient);
//    }

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
