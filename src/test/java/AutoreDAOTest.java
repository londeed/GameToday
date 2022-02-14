import Model.Autore.Autore;
import Model.Autore.AutoreDAO;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AutoreDAOTest {
    private AutoreDAO autoreDAO;

    @Before
    public void beforeAll(){
        autoreDAO = new AutoreDAO();
    }

    @Test
    public void doRetrieveAutoreAllTest() throws SQLException {
        List<Autore> autoreList = autoreDAO.doRetrieveAutoreAll();
        int size = autoreList.size();
        assertEquals(size, autoreList.size());
    }

    @Test
    public void createAutoreTest() throws SQLException {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.set(2022, Calendar.FEBRUARY,26);
        date = calendar.getTime();
        Autore autore = new Autore();
        autore.setNome("Alberico");
        autore.setCognome("Informato");
        autore.setAuNickname("Every_Eye");
        autore.setPassword("EveEye*alb00");
        autore.setEmail("alberico@gmail.com");
        autore.setLike(0);
        autore.setDislike(0);
        autore.setScadenza((java.sql.Date) date);
        autore.setRecCommissionate("Bloodborne 2");
        autore.setRecEffettuate(0);
        autore.setAvatar(7);
        assertEquals(true,autoreDAO.createAutore(autore));
    }

    @Test
    public void createAutoreTestRuntimeException() throws SQLException {
        Autore autore = new Autore();
        try {
            autoreDAO.createAutore(autore);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateAutoreTest() throws SQLException {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.set(2020, Calendar.JANUARY,16);
        date = calendar.getTime();
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IgnIta00*");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(0);
        autore.setDislike(0);
        autore.setScadenza((java.sql.Date) date);
        autore.setRecCommissionate("");
        autore.setRecEffettuate(0);
        autore.setAvatar(0);
        String auNickname  = "IGN_Italia";
        assertEquals(true,autoreDAO.updateAutore(autore,auNickname));
    }

    @Test
    public void updateAutoreTestRuntimeException() throws SQLException {
        Autore autore = new Autore();
        String auNickname  = "";
        try {
            autoreDAO.updateAutore(autore,auNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteAutoreTest() throws SQLException {
        String auNickname = "IGN_Italia";
        assertEquals(true,autoreDAO.deleteAutore(auNickname));
    }

    @Test
    public void deleteAutoreTestRuntimeException() throws SQLException {
        String auNickname = "";
        try {
            autoreDAO.deleteAutore(auNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void loginAutoreTest() throws SQLException {
        Autore autore = new Autore();
        String email = "autore2@gmail.com";
        String password = "Coplan&3t1999";
        assertEquals(autore,autoreDAO.loginAutore(email,password));
    }

    @Test
    public void loginAutoreTestRuntimeException() throws SQLException {
        String email = "";
        String password = "";
        try {
            autoreDAO.loginAutore(email,password);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void countAllTest() throws SQLException {
        int count = autoreDAO.countAll();
        int size = count;
        assertEquals(size, count);
    }

    @Test
    public void doRetrieveAutoreByEmailTest() throws SQLException {
        Autore autore = new Autore();
        String email = "autore2@gmail.com";
        assertEquals(autore,autoreDAO.doRetrieveAutoreByEmail(email));
    }

    @Test
    public void doRetrieveAutoreByEmailTestRuntimeException() throws SQLException {
        String email = "";
        try {
            autoreDAO.doRetrieveAutoreByEmail(email);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveAutoreByNicknameTest() throws SQLException {
        Autore autore = new Autore();
        String auNickname= "CoPlaNet";
        assertEquals(autore,autoreDAO.doRetrieveAutoreByNickname(auNickname));
    }

    @Test
    public void doRetrieveAutoreByNicknameTestRuntimeException() throws SQLException {
        String auNickname= "";
        try {
            autoreDAO.doRetrieveAutoreByNickname(auNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateAutoreRecCommissionateTest() throws SQLException {
        String auNickname= "CoPlaNet";
        String titolo= "Fortnite";
        assertEquals(true,autoreDAO.updateAutoreRecCommissionate(auNickname,titolo));
    }

    @Test
    public void updateAutoreRecCommissionateTestRuntimeException() throws SQLException {
        String auNickname= "";
        String titolo= "";
        try {
            autoreDAO.updateAutoreRecCommissionate(auNickname,titolo);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateAutoreRecCommissionateBisTest() throws SQLException {
        String auNickname= "CoPlaNet";
        assertEquals(true,autoreDAO.updateAutoreRecCommissionateBis(auNickname));
    }

    @Test
    public void updateAutoreRecCommissionateBisTestRuntimeException() throws SQLException {
        String auNickname= "";
        try {
            autoreDAO.updateAutoreRecCommissionateBis(auNickname);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

}
