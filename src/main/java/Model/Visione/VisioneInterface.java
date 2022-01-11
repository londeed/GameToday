package Model.Visione;

import java.sql.SQLException;
import java.util.List;

public interface VisioneInterface
{
    List<Visione> doRetrieveByAutoreasTitolo(String auNickname, String titolo) throws SQLException;
}