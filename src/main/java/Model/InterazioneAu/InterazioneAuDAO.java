package Model.InterazioneAu;

import Model.Commento.Commento;
import Model.Commento.CommentoExtraction;
import Model.Connessione.ConPool;
import Model.Recensione.Recensione;
import Model.Recensione.RecensioneExtraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterazioneAuDAO {

    public InterazioneAu doRetrieveInterazioneAuByCodice(String comCodice) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM interezioneAutore WHERE CommentoCod = ?")) {
                ps.setString(1, comCodice);
                ResultSet rs = ps.executeQuery();
                InterazioneAu interazioneAu = new InterazioneAu();
                InterazioneAuExtraction interazioneAuExtraction = new InterazioneAuExtraction();
                if (rs.next()) {
                    interazioneAu = interazioneAuExtraction.mapping(rs);
                }
                rs.close();
                return interazioneAu;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public List<InterazioneAu> doRetrieveInterazioneAuByNickname(String auNickname) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM interezioneAutore WHERE AuNickname = ?")) {
                ps.setString(1, auNickname);
                ResultSet rs = ps.executeQuery();
                List<InterazioneAu> interazioneAu = new ArrayList<>();
                InterazioneAuExtraction interazioneAuExtraction = new InterazioneAuExtraction();
                while (rs.next()) {
                    interazioneAu.add(interazioneAuExtraction.mapping(rs));
                }
                rs.close();
                return interazioneAu;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Commento doRetrieveCommentoAuByCodice(String comCodice) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM commento WHERE CommentoCod = ?")) {
                ps.setString(1, comCodice);
                ResultSet rs = ps.executeQuery();
                Commento commento = new Commento();
                CommentoExtraction commentoExtraction = new CommentoExtraction();
                if (rs.next()) {
                    commento = commentoExtraction.mapping(rs);
                }
                rs.close();
                return commento;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public List<Commento> doRetrieveCommentoAuByNickname(String auNickname) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT commento.CommentoCod,  commento.Codice,  commento.CLike,  commento.CDislike,  commento.CTesto \n" + "FROM interazioneAutore, commento\n" + "WHERE  interazioneAutore.CommentoCod = commento.CommentoCod AND interazioneAutore.AuNickname = ?")) {
                ps.setString(1, auNickname);
                ResultSet rs = ps.executeQuery();
                List<Commento> commento = new ArrayList();
                CommentoExtraction commentoExtraction = new CommentoExtraction();
                if (rs.next()) {
                    commento.add(commentoExtraction.mapping(rs));
                }
                rs.close();
                return commento;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Boolean insertByAutore(String comCodice, String auNickname, Boolean aul, Boolean aud) throws SQLException {
        int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO interazioneAutore(CommentoCod, AuNickname, AUL, AUD) VALUES (?,?,?,?);")) {
                ps.setString(1, comCodice);
                ps.setString(2, auNickname);
                ps.setBoolean(3, aul);
                ps.setBoolean(4, aud);
                rows = ps.executeUpdate();
            }
        }
        return rows == 1;
    }
}