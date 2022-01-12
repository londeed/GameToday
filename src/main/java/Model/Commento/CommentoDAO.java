package Model.Commento;

import Model.Autore.Autore;
import Model.Autore.AutoreExtraction;
import Model.Connessione.ConPool;

import java.sql.*;

public class CommentoDAO
{
    public Commento doRetrieveByCodice(String codice) throws SQLException
    {
        try(Connection connection= ConPool.getConnection())
        {
            try(PreparedStatement ps= connection.prepareStatement("SELECT * FROM Commento WHERE CommentoCod = ?")){
                ps.setString(1, codice);
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

    public Boolean insertCommento(Commento commento) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("INSERT INTO Commento(CommentoCod, Codice, CLike, CDislike, CTesto) VALUES (?,?,?,?,?);")){
                ps.setString(1, commento.getComCodice());
                ps.setString(2, commento.getCodice());
                ps.setInt(3, commento.getLike());
                ps.setInt(4, commento.getDislike());
                ps.setString(5, commento.getTesto());
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean updateCommento(Commento commento, String comCodice) throws SQLException
    {
        try(Connection connection = ConPool.getConnection()){
            try(PreparedStatement ps = connection.prepareStatement("UPDATE Commento SET CommentoCod=?, Codice=?, CLike=?, CDislike=?, CTesto=? WHERE CommentoCod=?")){
                ps.setString(1, commento.getComCodice());
                ps.setString(2, commento.getCodice());
                ps.setInt(3, commento.getLike());
                ps.setInt(4, commento.getDislike());
                ps.setString(5, commento.getTesto());
                ps.setString(6, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            }
        }
    }

    public Boolean deleteCommento(String comCodice) throws SQLException
    {
        try(Connection con = ConPool.getConnection()) {
            try(PreparedStatement ps = con.prepareStatement("DELETE FROM Commento WHERE CommentoCod = ?")){
                ps.setString(1, comCodice);
                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int countAll() throws SQLException
    {
        try(Connection con = ConPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM Commento")){
                ResultSet rs = ps.executeQuery();
                int size = 0;
                if(rs.next()){
                    size = rs.getInt(1);
                }
                return  size;
            }
        }
    }
}
