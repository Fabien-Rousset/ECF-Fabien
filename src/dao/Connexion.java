package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import dao.DaoException;

public class Connexion {
    private static Connexion instance;        // L'instance unique du Singleton
    private Connection connection;            // L'objet de connexion JDBC

    private Connexion() {                     // Constructeur privé
        try {
            Properties properties = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("database.properties");
            properties.load(input);

            String url = properties.getProperty("url");
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            String driver = properties.getProperty("driver");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, login, password);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Méthode d'accès pour récupérer l'instance unique
    public static Connexion getInstance() {
        if (instance == null) {
            synchronized (Connexion.class) {   // Pour rendre thread-safe
                if (instance == null) {
                    instance = new Connexion();
                }
            }
        }
        return instance;
    }

    // Méthode pour obtenir la connexion JDBC
    public Connection getConnection() {
        return connection;
    }
}
