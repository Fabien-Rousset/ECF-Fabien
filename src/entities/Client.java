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
    private Integer nbEmploye;

    /** Identifiant unique global pour tous les clients. */
    public static int idClient = 1;



    /**
     * Constructeur par défaut.
     * Utilisé pour créer une instance de Client sans initialiser ses champs.
     */


    /**
     * Constructeur complet pour la classe Client.
     *
     * @param raisonSocialeSociete La raison sociale de la société.
     * @param telSociete           Le numéro de téléphone de la société.
     * @param emailSociete         L'adresse email de la société.
     * @param commentaireSociete   Les commentaires relatifs à la société.
     * @param adresseSociete       L'adresse de la société.
     * @param chiffreAffaire       Le chiffre d'affaires réalisé par le client.
     * @param nbEmploye            Le nombre d'employés travaillant pour le client.
     * @throws Exception           Si une valeur fournie est invalide.
     */
    public Client(
            String raisonSocialeSociete, String telSociete, String emailSociete,
            String commentaireSociete, Adresse adresseSociete, Long chiffreAffaire, Integer nbEmploye) throws Exception {

        // Appelle le constructeur de la classe parente (Societe)
        super(idClient++, raisonSocialeSociete, telSociete, emailSociete, commentaireSociete, adresseSociete);

        // Utiliser les setters pour les autres champs
        setChiffreAffaire(chiffreAffaire);
        setNbEmploye(nbEmploye);
    }

    public static int renvoiProchainId(){
        return idClient;
    }




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
    public void setNbEmploye(Integer nbEmploye) throws ExoException {
        if (nbEmploye == null || nbEmploye < 0 ) {
            throw new ExoException("le nombre d'employé doit être renseigné et strictement supérieur à 0");
        }


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

    @Override
    public String toString() {
        return super.toString() + "Client{" +
                "chiffreAffaire=" + this.chiffreAffaire +
                ", nbEmploye=" + this.nbEmploye +
                '}';
    }
}
