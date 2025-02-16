package dao;

import entities.Contrat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratDAO {
    private Connection connection;

    public ContratDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour récupérer les contrats d'un client en fonction de son ID
    public List<Contrat> findByIdClient(int idClient) {
        List<Contrat> contrats = new ArrayList<>();
        String query = "SELECT * FROM Contrat WHERE id_client = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idClient);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contrat contrat = new Contrat(
                        rs.getString("libContrat"),
                        rs.getDouble("montantContrat")
                );
                contrat.setIdContrat(rs.getInt("idContrat"));
                contrat.setIdClient(rs.getInt("idClient"));
                contrats.add(contrat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contrats;
    }
}

