package Model.Recensione;

import Model.Commento.Commento;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RecensioneInterface
{
    Recensione doRetrieveByCodice(String codice) throws SQLException;
    Recensione doRetrieveByTitolo(String titolo) throws SQLException;
    List<Recensione> doRetrieveByAutore(String autore) throws SQLException;
    Boolean insertRecensione(Recensione recensione) throws SQLException;
    Boolean updateRecensione(Recensione recensione, String codice) throws SQLException;
    Boolean updateRecensioneText(String recensione, String codice) throws SQLException;
    Boolean updateRecensioneTextbis(String recensione, String titolo) throws SQLException;
    Boolean deleterecensione(String codice) throws SQLException;
    int countAll() throws SQLException;
    List<Recensione> doRetrieveAllByDataPubblicazione() throws SQLException;
    List<Recensione> doRetrieveAllByDataisNull() throws SQLException;
    Boolean updateRecensioneApprovata(String titolo) throws SQLException;
    Recensione doRetrieveByDataUltima() throws SQLException;
    Recensione doRetrieveByDataPrima() throws SQLException;
}