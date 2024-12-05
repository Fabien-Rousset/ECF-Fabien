//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.IOException;
import java.util.logging.Level;

import static logging.MonLogger.LOGGER;
import static logging.MonLogger.initialiserLogger;

public class Main {
    public static void main(String[] args) {

        //Initialisation du logger pour le programme
        try {
            initialiserLogger();
        } catch (IOException ex) {
            System.out.println("Erreur lors de l'initialisation du logger : " + ex.getMessage());
            System.exit(1);
        }
        LOGGER.log(Level.INFO, "Lancement de l'application");


//        LOGGER.log(Level.INFO, "L'application a été quittée");
    }
}