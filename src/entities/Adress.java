package entities;

public class Adress {

    private String numeroRue;
    private String nomRue;
    private String codePostal;
    private String ville;

    public Adress() {}

    public Adress(String numeroRue, String nomRue, String codePostal, String ville) {
        setNumeroRue(numeroRue);
        setNomRue(nomRue);
        setCodePostal(codePostal);
        setVille(ville);
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse :" + "numero='" + this.numeroRue + ", Rue='" + this.nomRue + '\'' + ", code postal='" + this.codePostal + '\'' +
                ", ville='" + this.ville + '\'' +
                '}';
    }
}
