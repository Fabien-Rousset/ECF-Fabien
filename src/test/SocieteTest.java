package test;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocieteTest {

    private Adresse adresse;

    @BeforeEach
    void setUp() throws Exception {
        // Initialiser l'adresse et vider les listes avant chaque test
        adresse = new Adresse("10", "Rue de Paris", "75001", "Paris");
        ListeClient.listeClient.clear();
        ListeProspect.listeProspect.clear();
    }

    @Test
    void testSetRaisonSocialeSocieteValide() throws Exception {
        // Test avec une raison sociale unique
        ConcreteSociete societe = new ConcreteSociete(1, "Entreprise A", "0123456789", "email@entreprise.com", "Commentaire", adresse);
        societe.setRaisonSocialeSociete("Entreprise B");
        assertEquals("Entreprise B", societe.getRaisonSocialeSociete());
    }

    @Test
    void testSetRaisonSocialeSocieteDuplicate() throws Exception {
        // Ajouter une raison sociale existante dans ListeClient
        Client client1 = new Client("Entreprise A", "0123456789", "email@entreprise.com", "Commentaire", adresse, 500L, 10);
        ListeClient.listeClient.add(client1);

        // Tester un doublon
        ConcreteSociete societe = new ConcreteSociete();
        Exception exception = assertThrows(ExoException.class, () -> societe.setRaisonSocialeSociete("Entreprise A"));
        assertEquals("La Raison sociale doit être unique et ne peut pas être utilisée deux fois.", exception.getMessage());
    }

    @Test
    void testSetTelSocieteValide() throws Exception {
        ConcreteSociete societe = new ConcreteSociete();
        societe.setTelSociete("+33123456789");
        assertEquals("+33123456789", societe.getTelSociete());
    }

    @Test
    void testSetTelSocieteInvalide() {
        ConcreteSociete societe = new ConcreteSociete();
        Exception exception = assertThrows(ExoException.class, () -> societe.setTelSociete("123"));
        assertEquals("Le format de votre numéro de téléphone n'est pas valide", exception.getMessage());
    }

    // Ajoutez les autres tests comme avant...
}
