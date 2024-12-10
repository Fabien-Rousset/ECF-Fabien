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
    void testSetRaisonSocialeSocieteDuplicate() throws Exception {
        // Ajouter une raison sociale existante dans ListeClient
        Client client1 = new Client("Entreprise A", "0123456789", "email@entreprise.com", "Commentaire", adresse, 500L, 10);
        ListeClient.listeClient.add(client1);


    }





    // Ajoutez les autres tests comme avant...
}
