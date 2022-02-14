import Model.Recensione.Recensione;
import Model.Supervisione.Supervisione;
import Model.Supervisione.SupervisioneDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SupervisioneDAOTest {
    private SupervisioneDAO supervisioneDAO;

    @Before
    public void beforeAll(){
        supervisioneDAO = new SupervisioneDAO();
    }

    @Test
    public void doRetrieveSupervisioneByCodiceTest() throws SQLException {
        String codice = "192GZvGC";
        Supervisione supervisione = new Supervisione();
        assertEquals(supervisione,supervisioneDAO.doRetrieveSupervisioneByCodice(codice));
    }

    @Test
    public void doRetrieveSupervisioneByCodiceTestRuntimeException() throws SQLException {
        String codice = "";
        Supervisione supervisione = new Supervisione();
        try{
            assertEquals(supervisione,supervisioneDAO.doRetrieveSupervisioneByCodice(codice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveSupervisioneByNicknameTest() throws SQLException {
        String amNickname = "V-Admin";
        List<Supervisione> supervisioneList = supervisioneDAO.doRetrieveSupervisioneByNickname(amNickname);
        int size = supervisioneList.size();
        assertEquals(size,supervisioneList.size());
    }
/*Non so se va bene
    @Test
    public void doRetrieveSupervisioneByNicknameTestRuntimeException() throws SQLException {
        String amNickname = "";
        List<Supervisione> supervisioneList = supervisioneDAO.doRetrieveSupervisioneByNickname(amNickname);
        int size = supervisioneList.size();
        try{
            assertEquals(size,supervisioneList.size());
        }catch(RuntimeException | SQLException e){
            Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
    */
    @Test
    public void updateTest() throws SQLException {
         String codice = "ViuklQ0G";
         Recensione recensione = new Recensione();
         Calendar calendar = new GregorianCalendar();
         Date date = new Date();
         calendar.set(2018, Calendar.APRIL,20);
         date = calendar.getTime();
         recensione.setTesto("buona recensione");
         recensione.setTitolo("God of War IV");
         recensione.setCodice("ViuklQ0G");
         recensione.setData((java.sql.Date) date);
         recensione.setAuNickname("IGN_Italia");
         recensione.setAuNome("Fabio");
         assertEquals(true,supervisioneDAO.update(recensione,codice));
    }

    @Test
    public void updateTestRuntimeException() throws SQLException {
        String codice = "";
        Recensione recensione = new Recensione();
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        recensione.setTesto("");
        recensione.setTitolo("");
        recensione.setCodice("");
        recensione.setData((java.sql.Date) date);
        recensione.setAuNickname("");
        recensione.setAuNome("");
        try{
            assertEquals(true,supervisioneDAO.update(recensione,codice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertByAmministratoreTest() throws SQLException {
        String codice = "X2QqDmgL";
        String amNickname = "C-Admin";
        assertEquals(true,supervisioneDAO.insertByAmministratore(codice,amNickname));
    }

    @Test
    public void insertByAmministratoreTestRuntimeException() throws SQLException {
        String codice = "";
        String amNickname = "";
        try{
            assertEquals(true,supervisioneDAO.insertByAmministratore(codice,amNickname));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
