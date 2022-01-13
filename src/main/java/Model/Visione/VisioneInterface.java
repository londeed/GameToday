package Model.Visione;

import java.sql.SQLException;
import java.util.List;

public interface VisioneInterface
{
    List<Visione> doRetrieveVisioneByAutore(String auNickname) throws SQLException;
    List<Visione> doRetrieveVisioneByTitolo(String titolo) throws SQLException;
    Boolean insertVisione(String auNickname,String titolo) throws SQLException;
}