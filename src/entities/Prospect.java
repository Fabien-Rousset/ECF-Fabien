package entities;

import java.time.LocalDate;

public class Prospect {

    private LocalDate dateProspection;
    private String interested;

    private static int idProspect;


    public Prospect(LocalDate dateProspection, String interested) {
        setDateProspection(dateProspection);
        setInterested(interested);
    }

    public LocalDate getDateProspection() {
        return dateProspection;
    }

    public void setDateProspection(LocalDate dateProspection) {
        this.dateProspection = dateProspection;
    }

    public String getInterested() {
        return interested;
    }

    public void setInterested(String interested) {
        this.interested = interested;
    }

    public static int getIdProspect() {
        return idProspect;
    }

    public static void setIdProspect(int idProspect) {
        Prospect.idProspect = idProspect;
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "dateProspection=" + this.dateProspection +
                ", interested='" + this.interested + '\'' +
                '}';
    }
}
