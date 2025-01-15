package test;

import entities.Societe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour la classe abstraite Societe.
 * Les tests valident le bon fonctionnement des méthodes et des règles de validation spécifiques.
 */
public class SocieteTest {

    private Societe societe;

    @BeforeEach
    void setUp() {
        // Initialisation d'une instance de Societe via une classe concrète dérivée pour les tests.
        societe = new Societe() {
            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    @Test
    void testSetIdSociete() {
        // Test de l'attribution d'un ID valide.
        societe.setIdSociete(10);
        assertEquals(10, societe.getIdSociete());
    }

    @Test
    void testSetRaisonSocialeValide() throws Exception {
        // Test de l'attribution d'une raison sociale valide.
        assertDoesNotThrow(() -> societe.setRaisonSocialeSociete("Entreprise Test"));
        assertEquals("Entreprise Test", societe.getRaisonSocialeSociete());
    }

    @Test
    void testSetRaisonSocialeInvalide() {
        // Test de l'attribution d'une raison sociale invalide (null ou vide).
        Exception exception = assertThrows(Exception.class, () -> societe.setRaisonSocialeSociete(null));
        assertEquals("La Raison sociale de la société doit être renseignée", exception.getMessage());
    }

    @Test
    void testSetTelSocieteValide() throws Exception {
        // Test de l'attribution d'un numéro de téléphone valide.
        assertDoesNotThrow(() -> societe.setTelSociete("0123456789"));
        assertEquals("0123456789", societe.getTelSociete());
    }

    @Test
    void testSetTelSocieteInvalide() {
        // Test de l'attribution d'un numéro de téléphone invalide.
        Exception exception = assertThrows(Exception.class, () -> societe.setTelSociete("abcd1234"));
        assertEquals("Le format de votre numéro de téléphone n'est pas valide", exception.getMessage());
    }

    @Test
    void testSetEmailSocieteValide() throws Exception {
        // Test de l'attribution d'un email valide.
        assertDoesNotThrow(() -> societe.setEmailSociete("contact@test.com"));
        assertEquals("contact@test.com", societe.getEmailSociete());
    }

    @Test
    void testSetEmailSocieteInvalide() {
        // Test de l'attribution d'un email invalide.
        Exception exception = assertThrows(Exception.class, () -> societe.setEmailSociete("invalid-email"));
        assertEquals("Le format de votre email n'est pas valide", exception.getMessage());
    }

//    @Test
//    void testSetAdresseSociete() {
//        // Test de l'attribution d'une adresse valide.
//        Adresse adresse = new Adresse("123", "Rue de Paris", "75000", "Paris");
//        societe.setAdresseSociete(adresse);
//        assertEquals(adresse, societe.getAdresseSociete());
//    }
}
