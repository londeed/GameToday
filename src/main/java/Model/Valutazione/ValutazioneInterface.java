package Model.Valutazione;

import Model.Videogioco.Videogioco;

import java.sql.SQLException;
import java.util.List;

public interface ValutazioneInterface
{
    List<Valutazione> doRetrieveValutazioneByUtente(String utNickname) throws SQLException;
    List<Valutazione> doRetrieveValutazioneByTitolo(String titolo) throws SQLException;
    Valutazione insertByUtente(String titolo, String utNickname) throws SQLException;
    Videogioco updateValutazione(String titolo, int value) throws SQLException;
    Valutazione doRetrieveValutazione(String titolo,String utNickname) throws SQLException;
}
