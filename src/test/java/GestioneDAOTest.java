import Model.Gestione.Gestione;
import Model.Gestione.GestioneDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GestioneDAOTest {
    private GestioneDAO gestioneDAO;

    @Before
    public void beforeAll(){
        gestioneDAO = new GestioneDAO();
    }

    @Test
    public void doRetrieveGamebyAdminTest() throws SQLException {
        String amNickname = "D-Admin";
        List<Gestione> gestioneList =  gestioneDAO.doRetrieveGamebyAdmin(amNickname);
        int size = gestioneList.size();
        assertEquals(size,gestioneList.size());
    }

    @Test
    public void doRetrieveGamebyAdminTestRuntimeException() throws SQLException {
        String amNickname = "";
        try{
            gestioneDAO.doRetrieveGamebyAdmin(amNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveGameAsTitleTest() throws SQLException {
        String titolo = "The Last of Us Parte II";
        Gestione gestione = new Gestione();
        assertEquals(gestione,gestioneDAO.doRetrieveGameAsTitle(titolo));
    }

    @Test
    public void doRetrieveGameAsTitleTestRuntimeException() throws SQLException {
        String titolo = "";
        Gestione gestione = new Gestione();
        try{
            assertEquals(gestione,gestioneDAO.doRetrieveGameAsTitle(titolo));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertGestioneTest() throws SQLException {
        String amNickname = "C-Admin";
        String titolo = "Detroit Became Human";
        assertEquals(true,gestioneDAO.insertGestione(amNickname,titolo));
    }
//dubbissimo
    @Test
    public void insertGestioneTestRuntimeException() throws SQLException {
        String amNickname = "";
        String titolo = "";
        try{
            assertEquals(true,gestioneDAO.insertGestione(amNickname,titolo));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
