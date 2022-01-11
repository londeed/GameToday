package Model.Valutazione;

import Model.Supervisione.Supervisione;
import Model.Videogioco.Videogioco;

import java.sql.SQLException;
import java.util.List;

public interface ValutazioneInterface
{
    List<Valutazione> doRetrieveValutazioneAsUtente(String titolo, String utNickname) throws SQLException;
    Valutazione insertByUtente(String titolo, String utNickname);
    Videogioco updateValutazione(String titolo, int value);
}
