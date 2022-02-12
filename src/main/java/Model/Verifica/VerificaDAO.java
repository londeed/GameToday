package Model.Verifica;

import Model.Commento.Commento;
import Model.Connessione.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe che utilizza i metodi di interrogazione del database riguardanti Verifica
 */

public class VerificaDAO {

    /**
     * metodo che interroga il database per eliminare un elemento verifica con il CommentoCod corrispondente alla
     * stringa passata come parametro
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

    public Boolean delete(String comCodice) throws SQLException{
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM commento WHERE CommentoCod = ?")){
                ps.setString(1, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per aggiornare un elemento commento, con CommentoCod corrispondente alla stringa
     * passata come parametro, tramite un oggetto commento passato come parametro
     * @param commento
     * @param comCodice
     * @return boolean
     * @throws SQLException
     */

    public  Boolean update (Commento commento, String comCodice) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE commento SET CommentoCod=?, Codice=?, CLike=?, CDislike=?, CTesto=? WHERE CommentoCod=?")){
                ps.setString(1, commento.getComCodice());
                ps.setString(2, commento.getCodice());
                ps.setInt(3, commento.getDislike());
                ps.setInt(4, commento.getLike());
                ps.setString(5, commento.getTesto());
                ps.setString(6, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    /**
     * metodo che interroga il database per restituire un elemento verifica con CommentoCod corrispondente alla stringa
     * passata come parametro
     * @param comCodice
     * @return Verifica
     * @throws SQLException
     */

    public Verifica doRetrieveInterazioneAmByCodice(String comCodice) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM verifica WHERE CommentoCod = ?")){
                ps.setString(1, comCodice);
                ResultSet rs= ps.executeQuery();
                Verifica verifica=new Verifica();
                VerificaExtraction verificaExtraction = new VerificaExtraction();
                if(rs.next()){
                    verifica = verificaExtraction.mapping(rs);
                }
                rs.close();
                return verifica;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per restituire una lista di verifica con AmNickname corrispondente alla
     * stringa passata come parametro
     * @param amNickname
     * @return List<Verifica>
     * @throws SQLException
     */

    public List<Verifica> doRetrieveInterazioneAmByNickname(String amNickname) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM verifica WHERE AmNickname = ?")){
                ps.setString(1, amNickname);
                ResultSet rs= ps.executeQuery();
                List <Verifica> verifica=new ArrayList<>();
                VerificaExtraction verificaExtraction = new VerificaExtraction();
                while (rs.next()){
                    verifica.add(verificaExtraction.mapping(rs));
                }
                rs.close();
                return verifica;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * metodo che interroga il database per inserire un elemento verifica tramite amNickname dell'amministratore
     * e comCodice del commento passati come parametro
     * @param comCodice
     * @param amNickname
     * @return boolean
     * @throws SQLException
     */

  public  Boolean insertVerifica(String comCodice, String amNickname) throws SQLException{
    int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO verifica(CommentoCod,AmNickname) VALUES (?,?);")) {
            ps.setString(1, comCodice);
            ps.setString(2, amNickname);
            rows = ps.executeUpdate();
        }
    }
        return rows == 1;
}
}
