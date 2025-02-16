package entities;

import utilities.RegexPattern;

/**
 * Classe représentant une adresse avec des informations telles que le numéro de rue, le nom de la rue,
 * le code postal, et la ville.
 * Cette classe est utilisée pour fournir des informations d'adresse aux entités comme les clients ou sociétés.
 */
public class Adresse {

    /** Numéro de rue de l'adresse. */
    private String numeroRue;

    /** Nom de la rue de l'adresse. */
    private String nomRue;

    /** Code postal de l'adresse. */
    private String codePostal;

    /** Ville de l'adresse. */
    private String ville;

    /**
     * Constructeur par défaut.
     * Permet de créer une instance d'Adresse sans initialiser ses champs.
     */
    public Adresse() {}

    /**
     * Constructeur avec tous les champs de la classe Adresse.
     *
     * @param numeroRue Numéro de rue de l'adresse.
     * @param nomRue Nom de la rue de l'adresse.
     * @param codePostal Code postal de l'adresse.
     * @param ville Ville de l'adresse.
     */
    public Adresse(String numeroRue, String nomRue, String codePostal, String ville) throws Exception {
        setNumeroRue(numeroRue);
        setNomRue(nomRue);
        setCodePostal(codePostal);
        setVille(ville);
    }

    /**
     * Récupère le numéro de rue.
     *
     * @return Le numéro de rue de l'adresse.
     */
    public String getNumeroRue() {
        return numeroRue;
    }

    /**
     * Modifie le numéro de rue.
     *
     * @param numeroRue Le nouveau numéro de rue de l'adresse.
     */
    public void setNumeroRue(String numeroRue) throws Exception {

        if(numeroRue == null || numeroRue.isEmpty()){
            throw new ExoException("Le n° de rue doit être renseigné");
        }
        this.numeroRue = numeroRue;
    }

    /**
     * Récupère le nom de la rue.
     *
     * @return Le nom de la rue de l'adresse.
     */
    public String getNomRue() {
        return nomRue;
    }

    /**
     * Modifie le nom de la rue.
     *
     * @param nomRue Le nouveau nom de la rue de l'adresse.
     */
    public void setNomRue(String nomRue) throws ExoException {

        if(nomRue == null || nomRue.isEmpty()){
            throw new ExoException("Le nom de la rue doit être renseigné");
        }
        this.nomRue = nomRue;
    }

    /**
     * Récupère le code postal.
     *
     * @return Le code postal de l'adresse.
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Modifie le code postal.
     *
     * @param codePostal Le nouveau code postal de l'adresse.
     */
    public void setCodePostal(String codePostal) throws ExoException {
        if (codePostal == null || codePostal.isEmpty()) {
            throw new ExoException("Le code postal doit être renseigné");
        }
        if (!codePostal.matches("^\\d{5}$")) { // Validation directe
            throw new ExoException("Le code postal doit contenir 5 chiffres");
        }
        this.codePostal = codePostal;
    }


    /**
     * Récupère la ville.
     *
     * @return La ville de l'adresse.
     */
    public String getVille() {
        return ville;
    }

    /**
     * Modifie la ville.
     *
     * @param ville La nouvelle ville de l'adresse.
     */
    public void setVille(String ville) throws ExoException {
        if(ville == null || ville.isEmpty()){
            throw new ExoException("Le nom de la ville doit être renseigné");
        }
        this.ville = ville;
    }


    @Override
    public String toString() {
        return
                "" + this.numeroRue +
                "" + this.nomRue +
                "" + this.codePostal +
                "" + this.ville ;
    }


}
