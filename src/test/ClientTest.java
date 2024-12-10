package test;

import entities.Adresse;
import entities.Client;
import entities.ExoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utilities.RegexPattern;

class ClientTest {

    @Test
    void testConstructeurAvecValeursValides() throws Exception {
        Adresse adresse = new Adresse("12", "Rue Principale", "75001", "Paris");
        Client client = new Client("Société XYZ", "0123456789", "contact@xyz.com",
                "Commentaire", adresse, 500L, 10);

        assertEquals("Société XYZ", client.getRaisonSocialeSociete());
        assertEquals("0123456789", client.getTelSociete());
        assertEquals("contact@xyz.com", client.getEmailSociete());
        assertEquals(adresse, client.getAdresseSociete());
        assertEquals(500L, client.getChiffreAffaire());
        assertEquals(10, client.getNbEmploye());
    }

    @Test
    void testConstructeurAvecValeursInvalides() throws Exception {
        Adresse adresse = new Adresse("12", "Rue Principale", "75001", "Paris");

        Exception exception = assertThrows(ExoException.class, () ->
                new Client("Société XYZ", "0123456789", "contact@xyz.com",
                        "Commentaire", adresse, 100L, 10));
        assertEquals("Chiffre d'affaire non valide : il ne doit pas être nul ou égal à zéro, et doit être supérieur ou égal à 200.", exception.getMessage());
    }

    @Test
    void testSetChiffreAffaireValide() throws Exception {
        Client client = new Client("Société XYZ", "0123456789", "contact@xyz.com",
                "Commentaire", new Adresse("12", "Rue Principale", "75001", "Paris"), 500L, 10);

        client.setChiffreAffaire(300L);
        assertEquals(300L, client.getChiffreAffaire());
    }

    @Test
    void testSetChiffreAffaireInvalide() throws Exception {
        Client client = new Client("Société XYZ", "0123456789", "contact@xyz.com",
                "Commentaire", new Adresse("12", "Rue Principale", "75001", "Paris"), 500L, 10);

        Exception exception = assertThrows(ExoException.class, () -> client.setChiffreAffaire(0L));
        assertEquals("Chiffre d'affaire non valide : il ne doit pas être nul ou égal à zéro, et doit être supérieur ou égal à 200.", exception.getMessage());
    }

    @Test
    void testSetNbEmployeValide() throws Exception {
        Client client = new Client("Société XYZ", "0123456789", "contact@xyz.com",
                "Commentaire", new Adresse("12", "Rue Principale", "75001", "Paris"), 500L, 10);

        client.setNbEmploye(20);
        assertEquals(20, client.getNbEmploye());
    }

    @Test
    void testSetNbEmployeInvalide() throws Exception {
        Client client = new Client("Société XYZ", "0123456789", "contact@xyz.com",
                "Commentaire", new Adresse("12", "Rue Principale", "75001", "Paris"), 500L, 10);

        Exception exception = assertThrows(ExoException.class, () -> client.setNbEmploye(-1));
        assertEquals("le nombre d'employé doit être renseigné et strictement supérieur à 0", exception.getMessage());
    }

    @Test
    void testGetIdClient() throws Exception {
        Client client1 = new Client("Société ABC", "0123456789", "contact@abc.com",
                "Commentaire", new Adresse("12", "Rue Principale", "75001", "Paris"), 500L, 10);
        Client client2 = new Client("Société XYZ", "0123456789", "contact@xyz.com",
                "Commentaire", new Adresse("34", "Rue des Fleurs", "75002", "Paris"), 700L, 15);

        assertEquals(1, Client.getIdClient());
        assertEquals(2, Client.getIdClient());
    }

    @Test
    void testSetIdClient() {
        Client.setIdClient(100);
        assertEquals(100, Client.getIdClient());
    }
}
