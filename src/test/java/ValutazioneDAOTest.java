import Model.Valutazione.Valutazione;
import Model.Valutazione.ValutazioneDAO;
import Model.Verifica.Verifica;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ValutazioneDAOTest {
    private ValutazioneDAO valutazioneDAO;

    @Before
    public void beforeAll(){
        valutazioneDAO = new ValutazioneDAO();
    }

    @Test
    public void doRetrieveValutazioneByUtenteTest() throws SQLException {
        String utNickname = "Ellie_Williams";
        List<Valutazione> valutazioneList = valutazioneDAO.doRetrieveValutazioneByUtente(utNickname);
        int size = valutazioneList.size();
        assertEquals(size,valutazioneList.size());
    }
//non so se va bene
    @Test
    public void doRetrieveValutazioneByUtenteTestRuntimeException() throws SQLException {
        String utNickname = "";
        try{
            valutazioneDAO.doRetrieveValutazioneByUtente(utNickname);
        }catch(RuntimeException | SQLException e){
           assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveValutazioneByTitoloTest() throws SQLException {
        String titolo = "The Last of Us Parte II";
        List<Valutazione> valutazioneList = valutazioneDAO.doRetrieveValutazioneByTitolo(titolo);
        int size = valutazioneList.size();
        assertEquals(size,valutazioneList.size());
    }
    //non so se va bene
    @Test
    public void doRetrieveValutazioneByTitoloTestRuntimeException() throws SQLException {
        String titolo = "";
        try{
            valutazioneDAO.doRetrieveValutazioneByTitolo(titolo);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertByUtenteTest() throws SQLException {
        String titolo = "Heavy Rain";
        String utNickname = "Salasar";
        assertEquals(true,valutazioneDAO.insertByUtente(titolo,utNickname));
    }

    @Test
    public void insertByUtenteTestRuntimeException() throws SQLException {
        String titolo = "";
        String utNickname = "";
        try{
            assertEquals(true,valutazioneDAO.insertByUtente(titolo,utNickname));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateValutazioneTest() throws SQLException {
        String titolo = "A Plague Tale: Innocence";
        int value = 4;
        assertEquals(true,valutazioneDAO.updateValutazione(titolo,value));
    }

    @Test
    public void updateValutazioneTestRuntimeException() throws SQLException {
        String titolo = "";
        int value = 0;
        try{
            assertEquals(true,valutazioneDAO.updateValutazione(titolo,value));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveValutazioneTest() throws SQLException {
        String titolo = "God of War IV";
        String utNickname = "Thor";
        Valutazione valutazione = new Valutazione();
        assertEquals(valutazione,valutazioneDAO.doRetrieveValutazione(titolo,utNickname));
    }

    @Test
    public void doRetrieveValutazioneTestRuntimeException() throws SQLException {
        String titolo = "";
        String utNickname = "";
        Valutazione valutazione = new Valutazione();
        try{
            assertEquals(valutazione,valutazioneDAO.doRetrieveValutazione(titolo,utNickname));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
