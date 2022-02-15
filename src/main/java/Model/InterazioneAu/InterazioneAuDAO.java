package Model.InterazioneAu;

import Model.Commento.Commento;
import Model.Commento.CommentoExtraction;
import Model.Connessione.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti l'InterazioneAu
 */

public class InterazioneAuDAO {

    /**
     * questo metodo restituisce un interazione tramite il commento del codice
     * @param comCodice
     * @return interazioneAu
     * @throws SQLException
     */

    public InterazioneAu doRetrieveInterazioneAuByCodice(String comCodice) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM interazioneAutore WHERE CommentoCod = ?")) {
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

    /**
     * questo metodo restituisce una lista di interazioni tramite il nickname dell'autore
     * @param auNickname
     * @return lista di interazioni
     * @throws SQLException
     */


    public List<InterazioneAu> doRetrieveInterazioneAuByNickname(String auNickname) throws SQLException {
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM interazioneAutore WHERE AuNickname = ?")) {
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

    /**
     * questo metodo restituisce una lista di commenti tramite il codice
     * @param comCodice
     * @return commento
     * @throws SQLException
     */

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

    /**
     * questo metodo restituisce una lista di commenti tramite l'interazione
     * @param auNickname
     * @return lista di commenti
     * @throws SQLException
     */

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

    /**
     * questo metodo inserisce un interazione
     * @param comCodice
     * @param auNickname
     * @param aul
     * @param aud
     * @return boolean
     * @throws SQLException
     */

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

    /**
     * questo metodo restituics una lista di nickname tramite il commento del codice
     * @param comCodice
     * @return lista di stringhe
     * @throws SQLException
     */

    public List<String> doRetrieveNicknameAuByComCodice(String comCodice) throws SQLException{
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT AuNickname FROM interazioneAutore WHERE CommentoCod = ?")) {
                ps.setString(1,comCodice);
                ResultSet rs = ps.executeQuery();
                List<String> nickname = new ArrayList();
                if (rs.next()) {
                    nickname.add(rs.getString(1));
                }
                rs.close();
                return nickname;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * restituisce il nickname dell'autore che ha scritto il commento
     * @param comCodice
     * @return stringa
     * @throws SQLException
     */

    public String doRetrieveByCreazioneCommento(String comCodice) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("SELECT AuNickname FROM interazioneAutore WHERE CommentoCod = ? AND AUL = 'false' AND AUD = 'false'")){
                ps.setString(1,comCodice);
                ResultSet rs = ps.executeQuery();
                String interazioneAu = "";
                if (rs.next()) {
                    interazioneAu = rs.getString(1);
                }
                rs.close();
                return interazioneAu;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * restituisce interazioneAu
     * @param comCodice
     * @return interazioneAu
     * @throws SQLException
     */


    public InterazioneAu doRetrieveInterazioneCreazioneCommento(String comCodice)throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM interazioneAutore WHERE CommentoCod = ? AND AUL = 'false' AND AUD = 'false'")){
                ps.setString(1,comCodice);
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

    /**
     * questo metodo permette di eliminare un interazione
     * @param comCodice
     * @param nickname
     * @param like
     * @param dislike
     * @return boolean
     * @throws SQLException
     */

    public Boolean delete(String comCodice,String nickname,boolean like,boolean dislike)throws SQLException{
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM interazioneAutore WHERE CommentoCod = ? AND AuNickname = ? AND AUL = ? AND AUD = ?")){
                ps.setString(1, comCodice);
                ps.setString(2, nickname);
                ps.setBoolean(3, like);
                ps.setBoolean(4, dislike);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}