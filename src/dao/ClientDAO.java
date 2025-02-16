package dao;

import entities.Adresse;
import entities.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static logging.MonLogger.LOGGER;



public class ClientDAO {

    public ClientDAO() {
        // Plus besoin d'initialiser la connexion ici
    }

    // ✅ Lire toute la table (findAll)
    public List<Client> findAll() throws DaoException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";

        try (Connection connection = Connexion.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Adresse adresse = new Adresse(
                        rs.getString("numeroRue"),
                        rs.getString("nomRue"),
                        rs.getString("codePostal"),
                        rs.getString("ville")
                );

                Client client = new Client(
                        rs.getString("raisonSocialeSociete"),
                        rs.getString("telSociete"),
                        rs.getString("emailSociete"),
                        rs.getString("commentaireSociete"),
                        adresse,
                        rs.getInt("chiffreAffaire"),
                        rs.getInt("nbEmploye")
                );
                clients.add(client);
            }

        } catch (Exception e) {
            throw new DaoException("Erreur lors de la récupération des clients : " + e.getMessage());

        }
        return clients;
    }

    // ✅ Lire un enregistrement (find)
    public Client find(Integer id) throws DaoException {
        String sql = "SELECT * FROM Client WHERE idClient = ?";
        Client client = null;

        try (Connection connection = Connexion.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Adresse adresse = new Adresse(
                        rs.getString("numeroRue"),
                        rs.getString("nomRue"),
                        rs.getString("codePostal"),
                        rs.getString("ville")
                );
                client = new Client(
                        rs.getString("raisonSocialeSociete"),
                        rs.getString("telSociete"),
                        rs.getString("emailSociete"),
                        rs.getString("commentaireSociete"),
                        adresse,
                        rs.getInt("chiffreAffaire"),
                        rs.getInt("nbEmploye")
                );
            }

        } catch (Exception e) {
            throw new DaoException("Erreur lors de la recherche du client avec l'ID " + id + " : " + e.getMessage());
        }
        return client;
    }

    // ✅ Insérer un enregistrement (create)
    public boolean create(Client client) throws DaoException {
        String sql = "INSERT INTO Client (raisonSocialeSociete, telSociete, emailSociete, commentaireSociete, " +
                "numeroRue, nomRue, codePostal, ville, chiffreAffaire, nbEmploye) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Connexion.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, client.getRaisonSocialeSociete());
            stmt.setString(2, client.getTelSociete());
            stmt.setString(3, client.getEmailSociete());
            stmt.setString(4, client.getCommentaireSociete());
            stmt.setString(5, client.getAdresseSociete().getNumeroRue());
            stmt.setString(6, client.getAdresseSociete().getNomRue());
            stmt.setString(7, client.getAdresseSociete().getCodePostal());
            stmt.setString(8, client.getAdresseSociete().getVille());
            stmt.setInt(9, client.getChiffreAffaire());
            stmt.setInt(10, client.getNbEmploye());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la création du client : " + e.getMessage());
        }
    }

    // ✅ Modifier un enregistrement (save)
    public boolean save(Client client, Integer id) throws DaoException {
        String sql = "UPDATE Client SET raisonSocialeSociete = ?, telSociete = ?, emailSociete = ?, commentaireSociete = ?, " +
                "numeroRue = ?, nomRue = ?, codePostal = ?, ville = ?, chiffreAffaire = ?, nbEmploye = ? " +
                "WHERE idClient = ?";

        try (Connection connection = Connexion.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, client.getRaisonSocialeSociete());
            stmt.setString(2, client.getTelSociete());
            stmt.setString(3, client.getEmailSociete());
            stmt.setString(4, client.getCommentaireSociete());
            stmt.setString(5, client.getAdresseSociete().getNumeroRue());
            stmt.setString(6, client.getAdresseSociete().getNomRue());
            stmt.setString(7, client.getAdresseSociete().getCodePostal());
            stmt.setString(8, client.getAdresseSociete().getVille());
            stmt.setInt(9, client.getChiffreAffaire());
            stmt.setInt(10, client.getNbEmploye());
            stmt.setInt(11, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la mise à jour du client avec l'ID " + id + " : " + e.getMessage());
        }
    }

    // ✅ Supprimer un enregistrement (delete)
    public boolean delete(int id) throws DaoException {
        String sql = "DELETE FROM Client WHERE idClient = ?";

        try (Connection connection = Connexion.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DaoException("Erreur lors de la suppression du client avec l'ID " + id + " : " + e.getMessage());
        }
    }
}
