package test;

import entities.Adresse;
import entities.Prospect;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProspectTest {

    @Test
    void testConstructeurAvecValeursValides() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        Prospect prospect = new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                "05/05/2005",
                "oui"
        );

        assertEquals("Société ABC", prospect.getRaisonSocialeSociete());
        assertEquals("0123456789", prospect.getTelSociete());
        assertEquals("contact@abc.com", prospect.getEmailSociete());
        assertEquals(adresse, prospect.getAdresseSociete());
        assertEquals(LocalDate.of(2023, 10, 15), prospect.getDateProspection());
        assertEquals("oui", prospect.getInterested());
    }

    @Test
    void testConstructeurAvecDateInvalide() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");

        Exception exception = assertThrows(DateTimeException.class, () -> new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                null,
                "oui"
        ));
        assertEquals("Date invalide, veuillez saisir au format jj/MM/aaaa.", exception.getMessage());
    }

    @Test
    void testSetDateProspectionValide() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        Prospect prospect = new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                "25/05/2005",
                "oui"
        );

        prospect.setDateProspection("16/10/2023");
        assertEquals(LocalDate.of(2023, 10, 16), prospect.getDateProspection());
    }

    @Test
    void testSetDateProspectionInvalide() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        Prospect prospect = new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                "25/05/2005",
                "oui"
        );

        Exception exception = assertThrows(DateTimeException.class, () -> prospect.setDateProspection("2023-10-15"));
        assertEquals("Date invalide, veuillez saisir au format jj/MM/aaaa.", exception.getMessage());
    }

    @Test
    void testSetInterested() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        Prospect prospect = new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                "28/06/2000",
                "oui"
        );

        prospect.setInterested("non");
        assertEquals("non", prospect.getInterested());
    }

    @Test
    void testGetIdProspect() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        Prospect prospect1 = new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                "05/09/1981",
                "oui"
        );
        Prospect prospect2 = new Prospect(
                "Société XYZ",
                "0987654321",
                "contact@xyz.com",
                "Commentaire",
                adresse,
                "07/09/1981",
                "non"
        );

        assertEquals(1, prospect1.getIdProspect());
        assertEquals(2, prospect2.getIdProspect());
    }

    @Test
    void testSetIdProspect() {
        Prospect.setIdProspect(100);
        assertEquals(100, Prospect.getIdProspect());
    }

    @Test
    void testToString() throws Exception {
        Adresse adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        Prospect prospect = new Prospect(
                "Société ABC",
                "0123456789",
                "contact@abc.com",
                "Commentaire",
                adresse,
                "15/09/2015",
                "oui"
        );

        String expected = "Prospect{dateProspection=2023-10-15, interested='oui'}";
        assertEquals(expected, prospect.toString());
    }
}
