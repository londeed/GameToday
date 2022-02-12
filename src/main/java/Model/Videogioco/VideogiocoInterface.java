package Model.Videogioco;

import java.sql.SQLException;
import java.util.List;

public interface VideogiocoInterface
{
    Videogioco doRetrieveByTitolo(String titolo) throws SQLException;
    List<Videogioco> doRetriveBymediaValutazioni(double mediaValutazioni) throws SQLException;
    List<Videogioco> doRetriveByCasaProduttrice(String casaProduttrice) throws SQLException;
    List<Videogioco> doRetriveByPiattaforma(String piattaforma) throws SQLException;
    Boolean insertVideogioco(Videogioco videogioco) throws SQLException;
    Boolean updateVideogioco(Videogioco videogioco, String titolo) throws SQLException;
    Boolean deleteVideogico(String titolo) throws SQLException;
    int countAll() throws SQLException;
    List<Videogioco> doRetrieveAllByTitolo() throws SQLException;
    List<Videogioco> doRetrieveAllByTitoloSearch(String s) throws SQLException;
    List<Videogioco> doRetrieveByNull() throws SQLException;
    List<Videogioco> doRetrieveByData() throws SQLException;
}
