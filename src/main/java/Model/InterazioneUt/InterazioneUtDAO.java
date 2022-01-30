package Model.InterazioneUt;

import Model.Commento.Commento;
import Model.Commento.CommentoExtraction;
import Model.Connessione.ConPool;
import Model.InterazioneAu.InterazioneAu;
import Model.InterazioneAu.InterazioneAuExtraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterazioneUtDAO {
    public InterazioneUt doRetrieveInterazioneUtByCodice(String comCodice) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM interazioneUtente WHERE CommentoCod = ?")){
                ps.setString(1, comCodice);
                ResultSet rs= ps.executeQuery();
                InterazioneUt interazioneUt=new InterazioneUt();
                InterazioneUtExtraction interazioneUtExtraction = new InterazioneUtExtraction();
                if(rs.next()){
                    interazioneUt = interazioneUtExtraction.mapping(rs);
                }
                rs.close();
                return interazioneUt;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public  List<InterazioneUt> doRetrieveInterazioneUtByNickname(String utNickname) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM interezioneUtente WHERE UtNickname = ?")){
                ps.setString(1, utNickname);
                ResultSet rs= ps.executeQuery();
                List <InterazioneUt> interazioneUt=new ArrayList<>();
                InterazioneUtExtraction interazioneUtExtraction = new InterazioneUtExtraction();
                while (rs.next()){
                    interazioneUt.add(interazioneUtExtraction.mapping(rs));
                }
                rs.close();
                return interazioneUt;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public  Commento doRetrieveCommentoUtByCodice(String comCodice) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM commento WHERE CommentoCod = ?")){
                ps.setString(1, comCodice);
                ResultSet rs= ps.executeQuery();
                Commento commento=new Commento();
                CommentoExtraction commentoExtraction=new CommentoExtraction();
                if(rs.next()){
                    commento = commentoExtraction.mapping(rs);
                }
                rs.close();
                return commento;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public List<Commento> doRetrieveCommentoUtByNickname(String utNickname) throws SQLException{
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT commento.CommentoCod,  commento.Codice,  commento.CLike,  commento.CDislike,  commento.CTesto \n" + "FROM interazioneUtente, commento\n" + "WHERE  interazioneUtente.CommentoCod = commento.CommentoCod AND interazioneAutore.UtNickname = ?")){
                ps.setString(1, utNickname);
                ResultSet rs= ps.executeQuery();
                List <Commento> commento=new ArrayList();
                CommentoExtraction commentoExtraction=new CommentoExtraction();
                if(rs.next()){
                    commento.add(commentoExtraction.mapping(rs));
                }
                rs.close();
                return commento;
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }


    public Boolean insertByUtente(String comCodice, String utNickname, Boolean utl, Boolean utd) throws SQLException {
        int rows = 0;
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("INSERT INTO interazioneUtente(CommentoCod, UtNickname, UTL, UTD) VALUES (?,?,?,?);")) {
                ps.setString(1, comCodice);
                ps.setString(2, utNickname);
                ps.setBoolean(3, utl);
                ps.setBoolean(4, utd);
                rows = ps.executeUpdate();
            }
        }
        return rows == 1;
    }


    public List<String> doRetrieveNicknameUtByComCodice(String comCodice) throws SQLException{
        try (Connection connection = ConPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT UtNickname FROM interazioneUtente WHERE CommentoCod = ?")) {
                ps.setString(1,comCodice);
                ResultSet rs = ps.executeQuery();
                List<String> nickname = new ArrayList();
                while (rs.next()) {
                    nickname.add(rs.getString(1));
                }
                rs.close();
                return nickname;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public String doRetrieveByCreazioneCommento(String comCodice) throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("SELECT UtNickname FROM interazioneUtente WHERE CommentoCod = ? AND UTL = 'false' AND UTD = 'false'")){
                ps.setString(1,comCodice);
                ResultSet rs = ps.executeQuery();
                String interazioneUt = "";
                if (rs.next()) {
                    interazioneUt = rs.getString(1);
                    System.out.println(interazioneUt);
                }
                rs.close();
                return interazioneUt;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public InterazioneUt doRetrieveInterazioneCreazioneCommento(String comCodice)throws SQLException{
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM interazioneUtente WHERE CommentoCod = ? AND UTL = 'false' AND UTD = 'false'")){
                ps.setString(1,comCodice);
                ResultSet rs = ps.executeQuery();
                InterazioneUt interazioneUt = new InterazioneUt();
                InterazioneUtExtraction interazioneUtExtraction = new InterazioneUtExtraction();
                if (rs.next()) {
                    interazioneUt = interazioneUtExtraction.mapping(rs);
                }
                rs.close();
                return interazioneUt;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}