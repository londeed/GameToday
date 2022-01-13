package Model.Supervisione;

import Model.Connessione.ConPool;
import Model.Recensione.Recensione;
import Model.Verifica.Verifica;
import Model.Verifica.VerificaExtraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupervisioneDAO {

    public Supervisione doRetrieveSupervisioneByCodice(String codice) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM supervisione WHERE Codice = ?")) {
                ps.setString(1, codice);
                ResultSet rs = ps.executeQuery();
                Supervisione supervisione = new Supervisione();
                SupervisioneExtraction supervisioneExtraction = new SupervisioneExtraction();
                if (rs.next()) {
                    supervisione = supervisioneExtraction.mapping(rs);
                }
                rs.close();
                return supervisione;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public List<Supervisione> doRetrieveSupervisioneByNickname(String amNickname) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM supervisione WHERE AmNickname = ?")) {
                ps.setString(1, amNickname);
                ResultSet rs = ps.executeQuery();
                List<Supervisione> supervisione = new ArrayList<>();
                SupervisioneExtraction supervisioneExtraction = new SupervisioneExtraction();
                while (rs.next()) {
                    supervisione.add(supervisioneExtraction.mapping(rs));
                }
                rs.close();
                return supervisione;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Boolean update(Recensione recensione, String codice) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("UPDATE recensione SET Codice=?, AuNickname=?, RData=?, RTesto=?, AuNome=?, Titolo=? WHERE Codice=?")) {
                ps.setString(1, recensione.getCodice());
                ps.setString(2, recensione.getAuNickname());
                ps.setDate(3, recensione.getData());
                ps.setString(4, recensione.getTesto());
                ps.setString(5, recensione.getAuNome());
                ps.setString(6, recensione.getTitolo());
                ps.setString(7, codice);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }


    public Boolean insertByAmministratore(String codice, String amNickname) throws SQLException {
        int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO supervisione(AmNickname, Codice) VALUES (?,?);")) {
                ps.setString(1, amNickname);
                ps.setString(2, codice);
                 rows = ps.executeUpdate();
            }
        }
        return rows == 1;
    }
}

