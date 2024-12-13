package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.Interet;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour la classe Prospect.
 * Les tests valident le bon fonctionnement des méthodes et des règles de validation spécifiques aux prospects.
 */
public class ProspectTest {

    private Prospect prospect;

    @BeforeEach
    void setUp() throws Exception {
        // Initialisation d'une instance Prospect avec des valeurs valides.
        prospect = new Prospect(
                "Raison Sociale",
                "0123456789",
                "test@example.com",
                "Commentaire",
                new Adresse("123", "Rue de Paris", "75000", "Paris"),
                "01/01/2023",
                "oui"
        );
    }

    @Test
    void testConstructeurComplet() throws Exception {
        // Test du constructeur complet pour vérifier que tous les champs sont correctement initialisés.
        assertEquals("Raison Sociale", prospect.getRaisonSocialeSociete());
        assertEquals("0123456789", prospect.getTelSociete());
        assertEquals("test@example.com", prospect.getEmailSociete());
        assertEquals("Commentaire", prospect.getCommentaireSociete());
        assertNotNull(prospect.getAdresseSociete());
        assertEquals(LocalDate.of(2023, 1, 1), prospect.getDateProspection());
        assertEquals(Interet.OUI, prospect.getInterested());
    }

    @Test
    void testSetDateProspectionValide() throws Exception {
        // Test de l'attribution d'une date de prospection valide.
        prospect.setDateProspection("15/08/2023");
        assertEquals(LocalDate.of(2023, 8, 15), prospect.getDateProspection());
    }

    @Test
    void testSetDateProspectionInvalide() {
        // Test de l'attribution d'une date de prospection invalide.
        Exception exception = assertThrows(Exception.class, () -> prospect.setDateProspection("2023-15-08"));
        assertEquals("Date invalide, veuillez saisir au format jj/MM/aaaa.", exception.getMessage());
    }

    @Test
    void testSetInterestedValide() {
        // Test de l'attribution d'un état d'intérêt valide.
        prospect.setInterested("non");
        assertEquals(Interet.NON, prospect.getInterested());
    }

    @Test
    void testSetInterestedInvalide() {
        // Test de l'attribution d'un état d'intérêt invalide.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> prospect.setInterested("peut-être"));
        assertTrue(exception.getMessage().contains("No enum constant"));
    }

    @Test
    void testGetIdProspect() {
        // Test pour vérifier que l'ID prospect est correctement incrémenté.
        assertTrue(Prospect.getIdProspect() > 0);
    }


}
