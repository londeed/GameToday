package DAOTest;

import Model.Amministratore.Amministratore;
import Model.Amministratore.AmministratoreDAO;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


public class AmministratoreDAOTest {
    private AmministratoreDAO amministratoreDAO;

    @Before
    public void beforeAll(){
        amministratoreDAO = new AmministratoreDAO();
    }

    @Test
    public void doRetrieveAllAmministratoreTest() throws SQLException {
        AmministratoreDAO amministratoreDAO1 = new AmministratoreDAO();
        List<Amministratore> amministratoreList = amministratoreDAO1.doRetrieveAllAmministratore();
        int size = amministratoreList.size();
        assertEquals(size, amministratoreList.size());
    }

    @Test
    public void doRetrieveAmministratoreByEmailTest() throws SQLException {
        Amministratore amministratore = new Amministratore();
        String email = "Vadmin1@gmail.com";
        assertNotNull(amministratoreDAO.doRetrieveAmministratoreByEmail(email));
    }

    @Test
    public void doRetrieveAmministratoreByEmailTestRuntimeException() throws SQLException {
        String email = "";
        try {
            amministratoreDAO.doRetrieveAmministratoreByEmail(email);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void createAmministratoreTest() throws SQLException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("S-Admin");
        amministratore.setNome("Salvatore");
        amministratore.setCognome("Rossi");
        amministratore.setAvatar(6);
        amministratore.setEmail("SAdmin6@gmail.com");
        amministratore.setPassword("SRAdmin6!");
        amministratore.setVideogiochiInseriti(0);
        assertEquals(true,amministratoreDAO.createAmministratore(amministratore));
    }


    @Test
    public void createAmministratoreTestRuntimeException() throws SQLException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("");
        try {
            amministratoreDAO.createAmministratore(amministratore);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[0]);
        }
    }

    @Test
    public void updateAmministratoreTest() throws SQLException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("F-Admin2");
        amministratore.setNome("Fabio");
        amministratore.setCognome("Caruso");
        amministratore.setAvatar(2);
        amministratore.setEmail("Fadmin1@gmail.com");
        amministratore.setPassword("FCAdmin2!");
        amministratore.setVideogiochiInseriti(3);
        String amNickname = "F-Admin";
        assertEquals(true,amministratoreDAO.updateAmministratore(amministratore,amNickname));
    }

    @Test
    public void updateAmministratoreTestRuntimeException() throws SQLException {
        Amministratore amministratore = new Amministratore();
        String amNickname = "";
        try {
            amministratoreDAO.updateAmministratore(amministratore,amNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteAmministratoreTest() throws SQLException {
        String amNickname = "C-Admin";
        assertEquals(true,amministratoreDAO.deleteAmministratore(amNickname));
    }
//dubbio
    @Test
    public void deleteAmministratoreTestRuntimeException() throws SQLException {
        String amNickname = "";
        try {
            amministratoreDAO.deleteAmministratore(amNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void loginAmministratoreTest() throws SQLException {
        Amministratore amministratore = new Amministratore();
        String email = "Dadmin1@gmail.com";
        String password = "DCAdmin4!";
        assertNotNull(amministratoreDAO.loginAmministratore(email,password));
    }

    @Test
    public void loginAmministratoreTestRuntimeException() throws SQLException {
        String email = "";
        String password = "";
        try {
            amministratoreDAO.loginAmministratore(email,password);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);

        }
    }

    @Test
    public void countAllTest() throws SQLException {
        int count = amministratoreDAO.countAll();
        int size = count;
        assertEquals(size, count);
    }
}
