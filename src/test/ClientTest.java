package test;

import entities.Adresse;
import entities.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour la classe Client.
 * Les tests valident le bon fonctionnement des méthodes et des règles de validation spécifiques aux clients.
 */
public class ClientTest {

    private Client client;

    @BeforeEach
    void setUp() throws Exception {
        // Initialisation d'une instance Client avec des valeurs valides.
        client = new Client(
                "Raison Sociale",
                "0123456789",
                "test@example.com",
                "Commentaire",
                new Adresse("123", "Rue de Paris", "75000", "Paris"),
                1000L,
                10
        );
    }

    @Test
    void testConstructeurComplet() throws Exception {
        // Test du constructeur complet pour vérifier que tous les champs sont correctement initialisés.
        assertEquals("Raison Sociale", client.getRaisonSocialeSociete());
        assertEquals("0123456789", client.getTelSociete());
        assertEquals("test@example.com", client.getEmailSociete());
        assertEquals("Commentaire", client.getCommentaireSociete());
        assertNotNull(client.getAdresseSociete());
        assertEquals(1000L, client.getChiffreAffaire());
        assertEquals(10, client.getNbEmploye());
    }

    @Test
    void testSetChiffreAffaireValide() throws Exception {
        // Test de l'attribution d'un chiffre d'affaires valide.
        assertDoesNotThrow(() -> client.setChiffreAffaire(5000L));
        assertEquals(5000L, client.getChiffreAffaire());
    }

    @Test
    void testSetChiffreAffaireInvalide() {
        // Test de l'attribution d'un chiffre d'affaires invalide.
        Exception exception = assertThrows(Exception.class, () -> client.setChiffreAffaire(0L));
        assertEquals("Chiffre d'affaire non valide : il ne doit pas être nul ou égal à zéro, et doit être supérieur ou égal à 200.", exception.getMessage());
    }

    @Test
    void testSetNbEmployeValide() throws Exception {
        // Test de l'attribution d'un nombre d'employés valide.
        assertDoesNotThrow(() -> client.setNbEmploye(20));
        assertEquals(20, client.getNbEmploye());
    }

    @Test
    void testSetNbEmployeInvalide() {
        // Test de l'attribution d'un nombre d'employés invalide.
        Exception exception = assertThrows(Exception.class, () -> client.setNbEmploye(-5));
        assertEquals("le nombre d'employé doit être renseigné et strictement supérieur à 0", exception.getMessage());
    }

    @Test
    void testGetIdClient() {
        // Test pour vérifier que l'ID client est correctement incrémenté.
        assertTrue(Client.getIdClient() > 0);
    }

    @Test
    void testToString() {
        // Test de la méthode toString pour vérifier la représentation en chaîne.
        String expected = "Societe{id=1, raisonSociale='Raison Sociale', tel='0123456789', email='test@example.com', commentaire='Commentaire', adresse=Adresse{numeroRue='123', nomRue='Rue de Paris', codePostal='75000', ville='Paris'}}Client{chiffreAffaire=1000, nbEmploye=10}";
        assertEquals(expected, client.toString());
    }
}
