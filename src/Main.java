//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.formdev.flatlaf.FlatIntelliJLaf;
import entities.*;
import entities.ListeClient.*;

import utilities.SocieteChoix;
import view.Accueil;
import view.MiseAjour;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;

import static logging.MonLogger.LOGGER;
import static logging.MonLogger.initialiserLogger;
import static utilities.RegexPattern.DATE_FORMATTER;

public class Main {
    public static void main(String[] args) {

        //Initialisation du logger pour le programme
        try {
            initialiserLogger();

            FlatIntelliJLaf.setup();
            new Accueil().setVisible(true);


        } catch (IOException ex) {
            System.out.println("Erreur lors de l'initialisation du logger : " + ex.getMessage());
            System.exit(1);
        }

        remplissageAdresseClientProspect();


        LOGGER.log(Level.INFO, "Lancement de l'application");




    }
    public static void remplissageAdresseClientProspect(){
        try {
            Adresse adresse1 = new Adresse("5","rue de la paix","75001", "Paris");
            Adresse adresse2 = new Adresse("255","rue du pipot","75002", "Paris");

            Client client1 = new Client("Nike","0754533320","kjghgk@gmail.com","pas de commentaire", adresse1, 500000000L, 50);
            Prospect prospect1 = new Prospect("Adidias","0754533320", "ljsdqf@gmail.com", "pads de commentaire", adresse2, "25/05/2005", "oui");
            ListeClient.ajouterClient(client1);
            ListeProspect.ajouterProspect(prospect1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}