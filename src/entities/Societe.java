package entities;

public abstract class Societe {

    private int idSociete;
    private String raisonSocialeSociete;
    private String telSociete;
    private String emailSociete;
    private String commentaireSociete;
    private Adresse adresseSociete;

    public Societe() {}

    public Societe(int idSociete, String raisonSocialeSociete, String telSociete, String emailSociete, String commentaireSociete, Adresse adresseSociete) {
        setIdSociete(idSociete);
        setRaisonSocialeSociete(raisonSocialeSociete);
        setTelSociete(telSociete);
        setEmailSociete(emailSociete);
        setCommentaireSociete(commentaireSociete);
        setAdresseSociete(adresseSociete);
    }

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    public String getRaisonSocialeSociete() {
        return raisonSocialeSociete;
    }

    public void setRaisonSocialeSociete(String raisonSocialeSociete) {
        this.raisonSocialeSociete = raisonSocialeSociete;
    }

    public String getTelSociete() {
        return telSociete;
    }

    public void setTelSociete(String telSociete) {
        this.telSociete = telSociete;
    }

    public String getEmailSociete() {
        return emailSociete;
    }

    public void setEmailSociete(String emailSociete) {
        this.emailSociete = emailSociete;
    }

    public String getCommentaireSociete() {
        return commentaireSociete;
    }

    public void setCommentaireSociete(String commentaireSociete) {
        this.commentaireSociete = commentaireSociete;
    }

    public Adresse getAdresseSociete() {
        return adresseSociete;
    }

    public void setAdresseSociete(Adresse adresseSociete) {
        this.adresseSociete = adresseSociete;
    }

    @Override
    public String toString() {
        return "Societe{" +
                "idSociete=" + this.idSociete +
                ", raisonSociale='" + this.raisonSocialeSociete + '\'' +
                ", tel='" + this.telSociete + '\'' +
                ", email='" + this.emailSociete + '\'' +
                ", commentaire='" + this.commentaireSociete + '\'' +
                ", adresse=" + this.adresseSociete +
                '}';
    }
}


