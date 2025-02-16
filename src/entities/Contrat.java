package entities;

public class Contrat {
    private Integer idContrat = null;
    private Integer idClient = null;
    private String libContrat;
    private double montantContrat;

    public Contrat(String libContrat, double montantContrat) {
        this.libContrat = libContrat;
        this.montantContrat = montantContrat;
    }

    public Integer getIdContrat() {
        return idContrat;
    }

    public void setIdContrat(Integer idContrat) {
        this.idContrat = idContrat;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getLibContrat() {
        return libContrat;
    }

    public void setLibContrat(String libContrat) {
        this.libContrat = libContrat;
    }

    @Override
    public String toString() {
        return "Contrat{" +
                "idContrat=" + idContrat +
                ", idClient=" + idClient +
                ", libContrat='" + libContrat + '\'' +
                ", montantContrat=" + montantContrat +
                '}';
    }
}
