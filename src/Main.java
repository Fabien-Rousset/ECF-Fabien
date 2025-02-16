//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import dao.ClientDAO;
import dao.DaoException;
import entities.*;
import entities.ListeClient.*;

import utilities.SocieteChoix;
import view.Accueil;
import view.MiseAjour;
import dao.Connexion;

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


            FlatLightLaf.setup();
            new Accueil().setVisible(true);



        } catch (IOException ex) {
            System.out.println("Erreur lors de l'initialisation du logger : " + ex.getMessage());
            System.exit(1);
        }




        LOGGER.log(Level.INFO, "Lancement de l'application");




    }

}