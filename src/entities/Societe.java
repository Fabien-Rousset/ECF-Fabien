package entities;

import utilities.RegexPattern;

/**
 * Classe abstraite représentant une société avec ses informations principales.
 * Cette classe sert de modèle pour d'autres entités, telles que des clients ou des prospects.
 * Elle contient les informations de base d'une société, comme son identifiant, sa raison sociale,
 * ses coordonnées et son adresse.
 */
public abstract class Societe {

    // Attributs privés représentant les informations principales d'une société.

    /** Identifiant unique de la société. */
    private int idSociete = 1;

    /** Raison sociale de la société (nom commercial). */
    private String raisonSocialeSociete;

    /** Numéro de téléphone de la société. */
    private String telSociete;

    /** Adresse e-mail de la société. */
    private String emailSociete;

    /** Commentaires ou notes concernant la société. */
    private String commentaireSociete;

    /** Adresse complète de la société. */
    private Adresse adresseSociete;

    /**
     * Constructeur par défaut.
     * Utilisé pour créer une instance de Societe sans initialiser ses champs.
     */
    public Societe() {}

    /**
     * Constructeur avec tous les champs de la classe.
     *
     * @param idSociete          Identifiant unique de la société.
     * @param raisonSocialeSociete Raison sociale de la société.
     * @param telSociete          Numéro de téléphone de la société.
     * @param emailSociete        Adresse e-mail de la société.
     * @param commentaireSociete  Commentaires ou notes sur la société.
     * @param adresseSociete      Adresse complète de la société.
     */
    public Societe(int idSociete, String raisonSocialeSociete, String telSociete, String emailSociete,
                   String commentaireSociete, Adresse adresseSociete) throws Exception {
        setIdSociete(idSociete);
        setRaisonSocialeSociete(raisonSocialeSociete);
        setTelSociete(telSociete);
        setEmailSociete(emailSociete);
        setCommentaireSociete(commentaireSociete);
        setAdresseSociete(adresseSociete);
    }

    // Accesseurs et mutateurs (getters et setters) pour chaque champ.

    /**
     * Récupère l'identifiant de la société.
     *
     * @return L'identifiant unique de la société.
     */
    public int getIdSociete() {
        return idSociete;
    }

    /**
     * Modifie l'identifiant de la société.
     *
     * @param idSociete Le nouvel identifiant de la société.
     */
    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    /**
     * Récupère la raison sociale de la société.
     *
     * @return La raison sociale de la société.
     */
    public String getRaisonSocialeSociete() {
        return raisonSocialeSociete;
    }

    /**
     * Modifie la raison sociale de la société.
     *
     * @param raisonSocialeSociete La nouvelle raison sociale de la société.
     */
    public void setRaisonSocialeSociete(String raisonSocialeSociete) throws ExoException {
        if (raisonSocialeSociete == null || raisonSocialeSociete.trim().isEmpty()) {
            throw new ExoException("La Raison sociale de la société doit être renseignée");
        }

        // Vérifier si la raison sociale existe déjà dans les listes de clients et de prospects
        boolean existeDeja = ListeClient.listeClient.stream()
                .anyMatch(client -> client.getRaisonSocialeSociete().equalsIgnoreCase(raisonSocialeSociete))
                || ListeProspect.listeProspect.stream()
                .anyMatch(prospect -> prospect.getRaisonSocialeSociete().equalsIgnoreCase(raisonSocialeSociete));

        if (existeDeja) {
            throw new ExoException("La Raison sociale doit être unique et ne peut pas être utilisée deux fois.");
        }

        this.raisonSocialeSociete = raisonSocialeSociete;
    }


    /**
     * Récupère le numéro de téléphone de la société.
     *
     * @return Le numéro de téléphone de la société.
     */
    public String getTelSociete() {
        return telSociete;
    }

    /**
     * Modifie le numéro de téléphone de la société.
     *
     * @param telSociete Le nouveau numéro de téléphone de la société.
     */
    public void setTelSociete(String telSociete) throws ExoException {
        if (telSociete == null || telSociete.trim().isEmpty()) {
            throw new ExoException("Ce champs doit être renseigné");}

        else if (!RegexPattern.PATTERN_TELEPHONE.matcher(telSociete).matches()) {
            throw new ExoException("Le format de votre numéro de téléphone n'est pas valide");
        }
        this.telSociete = telSociete;
    }

    /**
     * Récupère l'adresse e-mail de la société.
     *
     * @return L'adresse e-mail de la société.
     */
    public String getEmailSociete() {
        return emailSociete;
    }

    /**
     * Modifie l'adresse e-mail de la société.
     *
     * @param emailSociete La nouvelle adresse e-mail de la société.
     */
    public void setEmailSociete(String emailSociete) throws ExoException {
        if (emailSociete == null || emailSociete.trim().isEmpty()) {
            throw new ExoException("Ce champs doit être renseigné");
        } else if (!(RegexPattern.PATTERN_EMAIL.matcher(emailSociete).matches())) {
            throw new ExoException("Le format de votre email n'est pas valide");
        }
        this.emailSociete = emailSociete;
    }

    /**
     * Récupère les commentaires sur la société.
     *
     * @return Les commentaires ou notes concernant la société.
     */
    public String getCommentaireSociete() {
        return commentaireSociete;
    }

    /**
     * Modifie les commentaires sur la société.
     *
     * @param commentaireSociete Les nouveaux commentaires ou notes concernant la société.
     */
    public void setCommentaireSociete(String commentaireSociete) {
        this.commentaireSociete = commentaireSociete;
    }

    /**
     * Récupère l'adresse complète de la société.
     *
     * @return L'adresse de la société.
     */
    public Adresse getAdresseSociete() {
        return adresseSociete;
    }

    /**
     * Modifie l'adresse complète de la société.
     *
     * @param adresseSociete La nouvelle adresse de la société.
     */
    public void setAdresseSociete(Adresse adresseSociete) {
        this.adresseSociete = adresseSociete;
    }



}
