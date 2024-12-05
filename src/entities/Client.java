package entities;

import java.util.Collections;
import java.util.Comparator;

import static entities.ListeClient.listeClient;

/**
 * Classe représentant un client, qui est une spécialisation de la classe abstraite {@link Societe}.
 * Elle contient des informations spécifiques à un client, telles que le chiffre d'affaires et le nombre d'employés.
 */
public class Client extends Societe {

    /** Chiffre d'affaires réalisé par le client. */
    private Long chiffreAffaire;

    /** Nombre d'employés travaillant pour le client. */
    private int nbEmploye;

    /** Identifiant unique global pour tous les clients. */
    private static int idClient = 1;

    /**
     * Constructeur par défaut.
     * Utilisé pour créer une instance de Client sans initialiser ses champs.
     */
    public Client() {
        super();
    }

    /**
     * Constructeur avec tous les champs de la classe Client et de sa classe parente {@link Societe}.
     *
     * @param idSociete          Identifiant unique de la société.
     * @param raisonSocialeSociete Raison sociale de la société (nom commercial).
     * @param telSociete          Numéro de téléphone de la société.
     * @param emailSociete        Adresse e-mail de la société.
     * @param commentaireSociete  Commentaires ou notes sur la société.
     * @param adresseSociete      Adresse complète de la société.
     * @param chiffreAffaire      Chiffre d'affaires réalisé par le client.
     * @param nbEmploye           Nombre d'employés travaillant pour le client.
     */
    public Client(
            int idSociete, String raisonSocialeSociete, String telSociete, String emailSociete,
                  String commentaireSociete, Adresse adresseSociete, Long chiffreAffaire, int nbEmploye) throws Exception {
        super(idSociete, raisonSocialeSociete, telSociete, emailSociete, commentaireSociete, adresseSociete);
        setChiffreAffaire(chiffreAffaire);
        setNbEmploye(nbEmploye);
        idClient++;
    }

//    private void incrementeIdClient() {
//        idClient = IdSociete++;
//    }

    /**
     * Récupère le chiffre d'affaires du client.
     *
     * @return Le chiffre d'affaires réalisé par le client.
     */
    public double getChiffreAffaire() {
        return chiffreAffaire;
    }

    /**
     * Modifie le chiffre d'affaires du client.
     *
     * @param chiffreAffaire Le nouveau chiffre d'affaires réalisé par le client.
     */
    public void setChiffreAffaire(Long chiffreAffaire) throws ExoException {
        // Vérifie si chiffreAffaire est null, égal à zéro, ou inférieur à 200
        if (chiffreAffaire == null || chiffreAffaire == 0 || chiffreAffaire < 200) {
            throw new ExoException("Chiffre d'affaire non valide : il ne doit pas être nul ou égal à zéro, et doit être supérieur ou égal à 200.");
        }
        // Affecte la valeur si elle est valide
        this.chiffreAffaire = chiffreAffaire;
    }



    /**
     * Récupère le nombre d'employés travaillant pour le client.
     *
     * @return Le nombre d'employés.
     */
    public int getNbEmploye() {
        return nbEmploye;
    }

    /**
     * Modifie le nombre d'employés travaillant pour le client.
     *
     * @param nbEmploye Le nouveau nombre d'employés.
     */
    public void setNbEmploye(int nbEmploye) {
        this.nbEmploye = nbEmploye;
    }

    /**
     * Récupère l'identifiant global du client.
     *
     * @return L'identifiant unique global du client.
     */
    public static int getIdClient() {
        return idClient;
    }

    /**
     * Modifie l'identifiant global du client.
     *
     * @param idClient Le nouvel identifiant global pour les clients.
     */
    public static void setIdClient(int idClient) {
        Client.idClient = idClient;
    }
}
