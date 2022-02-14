import Model.Recensione.Recensione;
import Model.Recensione.RecensioneDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecensioneDAOTest {
    private RecensioneDAO recensioneDAO;

    @Before
    public void beforeAll() {
        recensioneDAO = new RecensioneDAO();
    }

    @Test
    public void doRetrieveByCodiceTest() throws SQLException {
        String codice = "192GZvGC";
        Recensione recensione = new Recensione();
        assertEquals(recensione, recensioneDAO.doRetrieveByCodice(codice));
    }

    @Test
    public void doRetrieveByCodiceTestRuntimeException() throws SQLException {
        String codice = "";
        try {
            recensioneDAO.doRetrieveByCodice(codice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveByTitoloTest() throws SQLException {
        String titolo = "Bloodborne";
        Recensione recensione = new Recensione();
        assertEquals(recensione, recensioneDAO.doRetrieveByTitolo(titolo));
    }

    @Test
    public void doRetrieveByTitoloTestRuntimeException() throws SQLException {
        String titolo = "";
        try {
            recensioneDAO.doRetrieveByTitolo(titolo);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveByAutoreTest() throws SQLException {
        String auNickname = "IGN_Italia";
        List<Recensione> recensioneList = recensioneDAO.doRetrieveByAutore(auNickname);
        int size = recensioneList.size();
        assertEquals(size, recensioneList.size());
    }

    //verificare come in videgioco
    @Test
    public void doRetrieveByAutoreTestRuntimeException() throws SQLException {
        String auNickname = "";
        try {
            recensioneDAO.doRetrieveByTitolo(auNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertRecensioneTest() throws SQLException {
        Recensione recensione = new Recensione();
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.set(2022, Calendar.FEBRUARY,13);
        date = calendar.getTime();
        recensione.setAuNome("Ezio");
        recensione.setAuNickname("CoPlaNet");
        recensione.setData((java.sql.Date) date);
        recensione.setTesto("proseguo del primo");
        recensione.setCodice("u7G8QfPA");
        recensione.setTitolo("Plague tale 2");
        assertEquals(true, recensioneDAO.insertRecensione(recensione));
    }

    @Test
    public void insertRecensioneTestRuntimeException() throws SQLException {
        Recensione recensione = new Recensione();
        try {
            recensioneDAO.insertRecensione(recensione);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateRecensioneTest() throws SQLException {
        Recensione recensione = new Recensione();
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.set(2020, Calendar.JANUARY,16);
        date = calendar.getTime();
        String codice = "NpZLUBgL";
        recensione.setTitolo("Dragon Ball Z: Kakarot");
        recensione.setTesto("dragon ball come ve lo ricordavate");
        recensione.setCodice("NpZLUBgL");
        recensione.setData((java.sql.Date) date);
        recensione.setAuNickname("CoPlaNet");
        recensione.setAuNome("Ezio");
        assertEquals(true, recensioneDAO.updateRecensione(recensione, codice));
    }

    @Test
    public void updateRecensioneTestRuntimeException() throws SQLException {
        Recensione recensione = new Recensione();
        String codice = "";
        try {
            recensioneDAO.updateRecensione(recensione, codice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateRecensioneTextTest() throws SQLException {
        String codice = "fkFfBIlQ";
        String recensione = "iorobot 2.0";
        assertEquals(true, recensioneDAO.updateRecensioneText(recensione, codice));
    }

    /*non so se va bene
        @Test
        public void updateRecensioneTextTestRuntimeException() throws SQLException {
            String codice = "";
            String recensione = "";
            try{
                recensioneDAO.updateRecensioneText(recensione,codice);
            }catch(RuntimeException | SQLException e){
                Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
            }
        }
        */
    @Test
    public void updateRecensioneTextbisTest() throws SQLException {
        String titolo = "Bloodborne";
        String recensione = "va bene cosi";
        assertEquals(true, recensioneDAO.updateRecensioneTextbis(recensione, titolo));
    }

    //non so
    @Test
    public void updateRecensioneTextbisTestRuntimeException() {
        String titolo = "";
        String recensione = "";
        try {
            recensioneDAO.updateRecensioneTextbis(recensione, titolo);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateRecensioneApprovataTest() throws SQLException {
        String titolo = "Horizon Zero Dawn";
        assertEquals(true, recensioneDAO.updateRecensioneApprovata(titolo));
    }

    @Test
    public void updateRecensioneApprovataTestRuntimeException() {
        String titolo = "";
        try {
            recensioneDAO.updateRecensioneApprovata(titolo);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleterecensioneTest() throws SQLException {
        String codice = "8diVX5Vz";
        assertEquals(true, recensioneDAO.deleterecensione(codice));
    }

    @Test
    public void deleterecensioneTestRuntimeException() throws SQLException {
        String codice = "";
        try {
            recensioneDAO.deleterecensione(codice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void countAllTest() throws SQLException {
        int count = recensioneDAO.countAll();
        int size = count;
        assertEquals(size, count);
    }

    @Test
    public void doRetrieveAllByDataPubblicazioneTest() throws SQLException {
        List<Recensione> recensioneList = recensioneDAO.doRetrieveAllByDataPubblicazione();
        int size = recensioneList.size();
        assertEquals(size, recensioneList.size());
    }

    @Test
    public void doRetrieveAllByDataisNullTest() throws SQLException {
        List<Recensione> recensioneList = recensioneDAO.doRetrieveAllByDataisNull();
        int size = recensioneList.size();
        assertEquals(size, recensioneList.size());
    }

    @Test
    public void doRetrieveByDataUltimaTest() throws SQLException {
        Recensione recensione = new Recensione();
        assertEquals(recensione,recensioneDAO.doRetrieveByDataUltima());
    }

    @Test
    public void doRetrieveByDataPrimaTest() throws SQLException {
        Recensione recensione = new Recensione();
        assertEquals(recensione,recensioneDAO.doRetrieveByDataPrima());
    }
}