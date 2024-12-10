package entities;

import entities.Adresse;
import entities.Societe;

public class ConcreteSociete extends Societe {
    public ConcreteSociete() {
        super();
    }

    public ConcreteSociete(int idSociete, String raisonSocialeSociete, String telSociete, String emailSociete,
                           String commentaireSociete, Adresse adresseSociete) throws Exception {
        super(idSociete, raisonSocialeSociete, telSociete, emailSociete, commentaireSociete, adresseSociete);
    }
}
