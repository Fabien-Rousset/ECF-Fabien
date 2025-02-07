package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Properties;

public class Connexion {
    final Properties dataProperties = new Properties();
    File fichier = new File("database.properties");

    FileInputStream input =new FileInputStream(fichier);
    dataProperties.load(input);

    public Connexion() throws FileNotFoundException {
    }
}
