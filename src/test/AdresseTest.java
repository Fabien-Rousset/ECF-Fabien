package test;

import entities.Adresse;
import entities.ExoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdresseTest {

    @Test
    void testConstructeurAvecValeursValides() throws Exception {
        Adresse adresse = new Adresse("123", "Rue Principale", "75000", "Paris");
        assertEquals("123", adresse.getNumeroRue());
        assertEquals("Rue Principale", adresse.getNomRue());
        assertEquals("75000", adresse.getCodePostal());
        assertEquals("Paris", adresse.getVille());
    }

    @Test
    void testSetNumeroRueValide() throws Exception {
        Adresse adresse = new Adresse();
        adresse.setNumeroRue("123");
        assertEquals("123", adresse.getNumeroRue());
    }

    @Test
    void testSetNumeroRueInvalide() {
        Adresse adresse = new Adresse();
        Exception exception = assertThrows(ExoException.class, () -> adresse.setNumeroRue(""));
        assertEquals("Ce champs doit être renseigné", exception.getMessage());
    }

    @Test
    void testSetNomRueValide() throws Exception {
        Adresse adresse = new Adresse();
        adresse.setNomRue("Rue des Fleurs");
        assertEquals("Rue des Fleurs", adresse.getNomRue());
    }

    @Test
    void testSetNomRueInvalide() {
        Adresse adresse = new Adresse();
        Exception exception = assertThrows(ExoException.class, () -> adresse.setNomRue(""));
        assertEquals("Ce champs doit etre renseigné", exception.getMessage());
    }

    @Test
    void testSetCodePostalValide() throws Exception {
        Adresse adresse = new Adresse();
        adresse.setCodePostal("75000");
        assertEquals("75000", adresse.getCodePostal());
    }

    @Test
    void testSetCodePostalInvalideNull() {
        Adresse adresse = new Adresse();
        Exception exception = assertThrows(ExoException.class, () -> adresse.setCodePostal(null));
        assertEquals("Ce champs doit être renseigné", exception.getMessage());
    }

    @Test
    void testSetCodePostalInvalideFormat() {
        Adresse adresse = new Adresse();
        Exception exception = assertThrows(ExoException.class, () -> adresse.setCodePostal("ABC"));
        assertEquals("Le code postal doit contenir 5 chiffres", exception.getMessage());
    }

    @Test
    void testSetVilleValide() throws Exception {
        Adresse adresse = new Adresse();
        adresse.setVille("Lyon");
        assertEquals("Lyon", adresse.getVille());
    }

    @Test
    void testSetVilleInvalide() {
        Adresse adresse = new Adresse();
        Exception exception = assertThrows(ExoException.class, () -> adresse.setVille(""));
        assertEquals("Ce champs doit être remplit", exception.getMessage());
    }

    @Test
    void testConstructeurAvecValeursInvalides() {
        Exception exception = assertThrows(ExoException.class, () -> new Adresse(null, "Rue Principale", "75000", "Paris"));
        assertEquals("Ce champs doit être renseigné", exception.getMessage());
    }
}
