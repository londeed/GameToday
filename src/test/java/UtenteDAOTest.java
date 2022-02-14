import Model.Utente.Utente;
import Model.Utente.UtenteDAO;
import Model.Utente.UtenteExtraction;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class UtenteDAOTest {
private UtenteDAO utenteDAO;
private UtenteExtraction utenteExtraction;



    @Before
    public void beforeAll() {
        utenteDAO = new UtenteDAO();
        utenteExtraction = new UtenteExtraction();
    }

    @Test
    public void doRetrieveAllTest() throws SQLException {
        List<Utente> utenteList = utenteDAO.doRetrieveAll();
        int size = utenteList.size();
        assertEquals(size,utenteList.size());
    }

    @Test
    public void createUtenteTest() throws SQLException {
        Utente utente = new Utente();
        utente.setUtNickname("Mago Oscuro");
        utente.setNome("Marco");
        utente.setCognome("Veneto");
        utente.setEmail("marco@gmail.com");
        utente.setPassword("marcoOscuro_00*");
        utente.setValEffettuate(0);
        utente.setAvatar(15);
        utente.setLike(0);
        utente.setDislike(0);
        assertEquals(true,utenteDAO.createUtente(utente));
    }

    @Test
    public void createUtenteTestRuntimeException(){
        Utente utente = new Utente();
        try{
            utenteDAO.createUtente(utente);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateUtenteTest() throws SQLException {
        Utente utente = new Utente();
        utente.setUtNickname("Mago Oscuro");
        utente.setNome("Marco");
        utente.setCognome("Veneto");
        utente.setEmail("marco@gmail.com");
        utente.setPassword("marcoOscuro_00*");
        utente.setValEffettuate(0);
        utente.setAvatar(15);
        utente.setLike(0);
        utente.setDislike(0);
        String utNickname = "Shadow_1995";
        assertEquals(true,utenteDAO.updateUtente(utente,utNickname));
    }

    @Test
    public void updateUtenteTestRuntimeException(){
        Utente utente = new Utente();
        String utNickname = "";
        try{
            utenteDAO.updateUtente(utente,utNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteUtenteTest() throws SQLException {
        String utNickname = "Hope";
        assertEquals(true,utenteDAO.deleteUtente(utNickname));
    }

    @Test
    public void deleteUtenteTestRuntimeException(){
        String utNickname = "";
        try{
            utenteDAO.deleteUtente(utNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void loginUtenteTest() throws SQLException {
        String email = "emi1995@gmail.com";
        String password = "BigShadow1995*";
        assertFalse(Objects.isNull(utenteDAO.loginUtente(email, password)));
    }

    @Test
    public void loginUtenteTestRuntimeException(){
        String email = "";
        String password = "";
        try{
            utenteDAO.loginUtente(email, password);
        }catch(RuntimeException | SQLException e){
            assertNull("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void countAllTest() throws SQLException {
        int count = utenteDAO.countAll();
        int size = count;
        assertEquals(size,count);
    }

    @Test
    public void doRetrieveUtenteByEmailTest() throws SQLException {
        String email = "emi1995@gmail.com";
        Utente utente = utenteDAO.doRetrieveUtenteByEmail(email);
        assertEquals(utente,utenteDAO.doRetrieveUtenteByEmail(email));
    }

    @Test
    public void doRetrieveUtenteByEmailTestRuntimeException(){
        String email = "";
        try{
            utenteDAO.doRetrieveUtenteByEmail(email);
        }catch(RuntimeException | SQLException e){
            assertNull("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveUtenteByNicknameTest() throws SQLException {
        String utNickname = "Joel_Miller";
        assertFalse(Objects.isNull(utenteDAO.doRetrieveUtenteByNickname(utNickname)));
    }

    @Test
    public void doRetrieveUtenteByNicknameTestRuntimeException(){
        String utNickname = "";
        try{
            utenteDAO.doRetrieveUtenteByNickname(utNickname);
        }catch(RuntimeException | SQLException e){
            assertNull("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
