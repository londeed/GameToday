package Model.Supervisione;

import Model.Connessione.ConPool;
import Model.Recensione.Recensione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti Supervisione
 */

public class SupervisioneDAO {

    /**
     * metodo che interroga il database per restituire un oggetto supervisione con il Codice corrispondente alla
     * stringa passata come parametro
     * @param codice
     * @return Supervisione
     * @throws SQLException
     */

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

    /**
     * metodo che interroga il database per restituire una lista di Supervisione con AmNickname corrispondente alla
     * stringa passata come parametro
     * @param amNickname
     * @return Lista di supervisione
     * @throws SQLException
     */

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

    /**
     * metodo che interroga il database per aggiornare un elemento recensione, con Codice corrispondente alla stringa
     * passata come parametro, tramite l'oggetto recensione anch'esso passato come parametro
     * @param recensione
     * @param codice
     * @return Boolean
     * @throws SQLException
     */

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

    /**
     * metodo che interroga il database per inserire un oggetto supervisione tramite una stringa Codice e una
     * stringa AmNickname passate come parametri
     * @param codice
     * @param amNickname
     * @return Boolean
     * @throws SQLException
     */

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

