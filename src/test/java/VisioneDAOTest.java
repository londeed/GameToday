import Model.Utente.Utente;

import Model.Visione.Visione;
import Model.Visione.VisioneDAO;
import Model.Visione.VisioneExtraction;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VisioneDAOTest {
    private VisioneDAO visioneDAO;

    @Before
    public void beforeAll() {
        visioneDAO = new VisioneDAO();
    }

    @Test
    public void doRetrieveVisioneByAutoreTest() throws SQLException {
        String auNickname = "CoPlaNet";
        List<Visione> visioneList = visioneDAO.doRetrieveVisioneByAutore(auNickname);
        int size = visioneList.size();
        assertEquals(size,visioneList.size());
    }

    @Test
    public void doRetrieveVisioneByAutoreTestRuntimeException(){
        String auNickname = "";
        try{
            visioneDAO.doRetrieveVisioneByAutore(auNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveVisioneByTitoloTest() throws SQLException {
        String titolo = "God of War IV";
        List<Visione> visioneList = visioneDAO.doRetrieveVisioneByTitolo(titolo);
        int size = visioneList.size();
        assertEquals(size,visioneList.size());
    }

    @Test
    public void doRetrieveVisioneByTitoloTestRuntimeException(){
        String titolo = "";
        try{
            visioneDAO.doRetrieveVisioneByTitolo(titolo);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertVisioneTest() throws SQLException {
        String titolo = "Heavy Rain";
        String auNickname = "CoPlaNet";
        Utente utente = new Utente();
        assertEquals(true,visioneDAO.insertVisione(auNickname,titolo));
    }

    @Test
    public void insertVisioneTestRuntimeException(){
        String titolo = "";
        String auNickname = "";
        try{
            visioneDAO.insertVisione(auNickname,titolo);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
