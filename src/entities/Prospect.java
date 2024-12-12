package entities;

import utilities.Interet;

import java.time.DateTimeException;
import java.time.LocalDate;

import static utilities.RegexPattern.DATE_FORMATTER;

/**
 * Classe représentant un prospect, qui est une spécialisation de la classe abstraite {@link Societe}.
 * Un prospect est une société potentiellement intéressée, avec des informations spécifiques telles que
 * la date de prospection et l'état d'intérêt.
 */
public class Prospect extends Societe {

    /** Date à laquelle la prospection a eu lieu. */
    private LocalDate dateProspection;

    /** Indique si le prospect est intéressé ou non. */
    private Interet interested;
    //A VOIR

    /** Identifiant unique global pour tous les prospects. */
    private static int idProspect = 1;


    public Prospect(String raisonSocialeSociete, String telSociete, String emailSociete,
                    String commentaireSociete, Adresse adresseSociete, String dateProspection, String interested) throws Exception {
        super(idProspect++, raisonSocialeSociete, telSociete, emailSociete, commentaireSociete, adresseSociete);
        setDateProspection(String.valueOf(dateProspection));
        setInterested(interested);


    }

    /**
     * Récupère la date de prospection.
     *
     * @return La date de la prospection.
     */
    public LocalDate getDateProspection() {
        return dateProspection;
    }

    /**
//     * Modifie la date de prospection.
     **/
    public void setDateProspection(String dateProspectionString) throws ExoException {

            // Tente de parser la chaîne avec le formatteur de date
        // Si la conversion est réussie, la valeur est affectée
        try{
            this.dateProspection = LocalDate.parse(dateProspectionString, DATE_FORMATTER);}
        catch(DateTimeException e){
            throw new ExoException("Date invalide, veuillez saisir au format jj/MM/aaaa.");
        }
            // Lève une exception si la date n'est pas au bon format

    }


    /**
     * Récupère l'état d'intérêt du prospect.
     *
     * @return Une chaîne indiquant si le prospect est intéressé ou non.
     */
    public Interet getInterested() {
        return interested;
    }

    /**
     * Modifie l'état d'intérêt du prospect.
     *
     * @param interested La nouvelle valeur indiquant si le prospect est intéressé ou non.
     */
    public void setInterested(String interested) {

        this.interested = Interet.valueOf(interested.toUpperCase());
    }

    /**
     * Récupère l'identifiant global du prospect.
     *
     * @return L'identifiant unique global du prospect.
     */
    public static int getIdProspect() {
        return idProspect;
    }

    /**
     * Modifie l'identifiant global du prospect.
     *
     * @param idProspect Le nouvel identifiant global pour les prospects.
     */
    public static void setIdProspect(int idProspect) {
        Prospect.idProspect = idProspect;
    }

    /**
     * Fournit une représentation textuelle du prospect, incluant ses champs spécifiques.
     *
     * @return Une chaîne de caractères représentant le prospect.
     */
    @Override
    public String toString() {
        return "Prospect{" +
                "dateProspection=" + this.dateProspection +
                ", interested='" + this.interested + '\'' +
                '}';
    }
}
