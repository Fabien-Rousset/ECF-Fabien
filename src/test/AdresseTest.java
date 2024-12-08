package test;

import entities.Adresse;
import entities.ExoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.RegexPattern;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour la classe Adresse.
 * Cette classe vérifie que les différents attributs et méthodes de la classe Adresse fonctionnent correctement.
 */
public class AdresseTest {

    private Adresse adresse;

    @BeforeEach
    public void setUp() {
        // Initialise une instance d'Adresse avant chaque test.
        adresse = new Adresse();
    }

    @Test
    public void testConstructeurCompletAvecValeursValides() {
        // Teste le constructeur avec tous les champs valides.
        assertDoesNotThrow(() -> {
            Adresse adresse = new Adresse("123", "Rue de Paris", "75000", "Paris");
            assertEquals("123", adresse.getNumeroRue());
            assertEquals("Rue de Paris", adresse.getNomRue());
            assertEquals("75000", adresse.getCodePostal());
            assertEquals("Paris", adresse.getVille());
        });
    }

    @Test
    public void testSetNumeroRue_NullValue_ThrowsExoException() {
        // Vérifie que setNumeroRue lève une exception si null est fourni.
        Exception exception = assertThrows(ExoException.class, () -> {
            adresse.setNumeroRue(null);
        });
        assertEquals("Ce champs doit être renseigné", exception.getMessage());
    }

    @Test
    public void testSetNumeroRue_EmptyValue_ThrowsExoException() {
        // Vérifie que setNumeroRue lève une exception si la valeur est vide.
        Exception exception = assertThrows(ExoException.class, () -> {
            adresse.setNumeroRue("");
        });
        assertEquals("Ce champs doit être renseigné", exception.getMessage());
    }

    @Test
    public void testSetNomRue_NullValue_ThrowsExoException() {
        // Vérifie que setNomRue lève une exception si null est fourni.
        Exception exception = assertThrows(ExoException.class, () -> {
            adresse.setNomRue(null);
        });
        assertEquals("Ce champs doit etre renseigné", exception.getMessage());
    }

    @Test
    public void testSetCodePostal_IncorrectValue_ThrowsExoException() {
        // Vérifie que setCodePostal lève une exception si le code postal n'a pas 5 chiffres.
        Exception exception = assertThrows(ExoException.class, () -> {
            adresse.setCodePostal("750");
        });
        assertEquals("Le code postal doit contenir 5 chiffres", exception.getMessage());
    }

    @Test
    public void testSetCodePostal_CorrectValue_NoException() {
        // Vérifie que setCodePostal ne lève aucune exception pour une valeur correcte.
        assertDoesNotThrow(() -> {
            adresse.setCodePostal("75001");
        });
        assertEquals("75001", adresse.getCodePostal());
    }

    @Test
    public void testSetVille_NullValue_ThrowsExoException() {
        // Vérifie que setVille lève une exception si la valeur est null.
        Exception exception = assertThrows(ExoException.class, () -> {
            adresse.setVille(null);
        });
        assertEquals("Ce champs doit être remplit", exception.getMessage());
    }

    @Test
    public void testSetVille_ValidValue_NoException() {
        // Vérifie que setVille ne lève pas d'exception si une valeur correcte est fournie.
        assertDoesNotThrow(() -> {
            adresse.setVille("Paris");
        });
        assertEquals("Paris", adresse.getVille());
    }

    @Test
    public void testToString() {
        // Vérifie la méthode toString.
        assertDoesNotThrow(() -> {
            adresse = new Adresse("123", "Rue de la Paix", "75000", "Paris");
        });
        String expected = "Adresse : numero='123', Rue='Rue de la Paix', code postal='75000', ville='Paris'";
        assertEquals(expected, adresse.toString());
    }
}
