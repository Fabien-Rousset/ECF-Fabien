package test;

import entities.Adresse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour la classe Adresse.
 * Les tests valident le bon fonctionnement des méthodes et des règles de validation.
 */
public class AdresseTest {

    // Instance d'une adresse utilisée dans les tests.
    private Adresse adresse;

    @BeforeEach
    void setUp() {
        // Initialisation d'une instance vide d'Adresse avant chaque test.
        adresse = new Adresse();
    }

    @Test
    void testConstructeurComplet() throws Exception {
        // Test du constructeur complet avec des valeurs valides.
        Adresse adresseComplete = new Adresse("123", "Rue de Paris", "75000", "Paris");
        assertEquals("123", adresseComplete.getNumeroRue()); // Vérifie le numéro de rue.
        assertEquals("Rue de Paris", adresseComplete.getNomRue()); // Vérifie le nom de la rue.
        assertEquals("75000", adresseComplete.getCodePostal()); // Vérifie le code postal.
        assertEquals("Paris", adresseComplete.getVille()); // Vérifie la ville.
    }

    @Test
    void testConstructeurCompletExceptionNumeroRue() {
        // Test du constructeur avec un numéro de rue invalide.
        Exception exception = assertThrows(Exception.class, () -> {
            new Adresse("", "Rue de Paris", "75000", "Paris");
        });
        assertEquals("Le n° de rue doit être renseigné", exception.getMessage());
    }

    @Test
    void testSetNumeroRueValide() throws Exception {
        // Test de l'attribution d'un numéro de rue valide.
        assertDoesNotThrow(() -> adresse.setNumeroRue("456"));
        assertEquals("456", adresse.getNumeroRue());
    }

    @Test
    void testSetNumeroRueInvalide() {
        // Test de l'attribution d'un numéro de rue invalide (vide).
        Exception exception = assertThrows(Exception.class, () -> adresse.setNumeroRue(""));
        assertEquals("Le n° de rue doit être renseigné", exception.getMessage());
    }

    @Test
    void testSetNomRueValide() throws Exception {
        // Test de l'attribution d'un nom de rue valide.
        assertDoesNotThrow(() -> adresse.setNomRue("Avenue des Champs-Élysées"));
        assertEquals("Avenue des Champs-Élysées", adresse.getNomRue());
    }

    @Test
    void testSetNomRueInvalide() {
        // Test de l'attribution d'un nom de rue invalide (null).
        Exception exception = assertThrows(Exception.class, () -> adresse.setNomRue(null));
        assertEquals("Le nom de la rue doit être renseigné", exception.getMessage());
    }

    @Test
    void testSetCodePostalValide() throws Exception {
        // Test de l'attribution d'un code postal valide.
        assertDoesNotThrow(() -> adresse.setCodePostal("12345"));
        assertEquals("12345", adresse.getCodePostal());
    }

    @Test
    void testSetCodePostalInvalideNull() {
        // Test de l'attribution d'un code postal null.
        Exception exception = assertThrows(Exception.class, () -> adresse.setCodePostal(null));
        assertEquals("Le code postal doit être renseigné", exception.getMessage());
    }

    @Test
    void testSetCodePostalInvalideFormat() {
        // Test de l'attribution d'un code postal avec un format invalide.
        Exception exception = assertThrows(Exception.class, () -> adresse.setCodePostal("1234"));
        assertEquals("Le code postal doit contenir 5 chiffres", exception.getMessage());
    }

    @Test
    void testSetVilleValide() throws Exception {
        // Test de l'attribution d'une ville valide.
        assertDoesNotThrow(() -> adresse.setVille("Lyon"));
        assertEquals("Lyon", adresse.getVille());
    }

    @Test
    void testSetVilleInvalide() {
        // Test de l'attribution d'une ville invalide (vide).
        Exception exception = assertThrows(Exception.class, () -> adresse.setVille(""));
        assertEquals("Le nom de la ville doit être renseigné", exception.getMessage());
    }

    @Test
    void testToString() throws Exception {
        // Test de la méthode toString pour vérifier la concaténation des champs.
        adresse.setNumeroRue("123");
        adresse.setNomRue("Rue de la Paix");
        adresse.setCodePostal("75008");
        adresse.setVille("Paris");
        assertEquals("123Rue de la Paix75008Paris", adresse.toString());
    }
}
