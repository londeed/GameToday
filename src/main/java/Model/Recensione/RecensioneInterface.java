package Model.Recensione;

import Model.Commento.Commento;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RecensioneInterface
{
    Recensione doRetrieveByCodice(int codice) throws SQLException;
    Recensione doRetrieveByTitolo(String titolo) throws SQLException;
    List<Recensione> doRetrieveByAutore(String autore) throws SQLException;
    Boolean insertRecensione(Recensione recensione) throws SQLException;
    Boolean updateRecensione(Recensione recensione, int codice) throws SQLException;
    Boolean deleterecensione(int codice) throws SQLException;
    int countAll() throws SQLException;
    List<Recensione> doRetrieveAllByDataPubblicazione() throws SQLException;
}