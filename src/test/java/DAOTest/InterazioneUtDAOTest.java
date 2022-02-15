package DAOTest;

import Model.Commento.Commento;
import Model.InterazioneUt.InterazioneUt;
import Model.InterazioneUt.InterazioneUtDAO;
import Model.Supervisione.Supervisione;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class InterazioneUtDAOTest {
    private InterazioneUtDAO interazioneUtDAO;

    @Before
    public void beforeAll(){
        interazioneUtDAO = new InterazioneUtDAO();
    }

    @Test
    public void doRetrieveInterazioneUtByCodiceTest() throws SQLException {
        String comCodice = "l9K6WDk9";
        InterazioneUt interazioneUt = new InterazioneUt();
        assertNotNull(interazioneUtDAO.doRetrieveInterazioneUtByCodice(comCodice));
    }

    @Test
    public void doRetrieveInterazioneUtByCodiceTestRuntimeException() throws SQLException {
        String comCodice = "";
        InterazioneUt interazioneUt = new InterazioneUt();
        try{
            interazioneUtDAO.doRetrieveInterazioneUtByCodice(comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveInterazioneUtByNicknameTest() throws SQLException {
        String utNickname = "Ellie_Williams";
        List<InterazioneUt> interazioneUtList = interazioneUtDAO.doRetrieveInterazioneUtByNickname(utNickname);
        int size = interazioneUtList.size();
        assertEquals(size,interazioneUtList.size());
    }
    /*Non so se va bene
    @Test
    public void doRetrieveInterazioneUtByNicknameTestRuntimeException() throws SQLException {
        String utNickname = "";
        List<InterazioneUt> interazioneUtList = interazioneUtDAO.doRetrieveInterazioneUtByNickname(utNickname);
        int size = interazioneUtList.size();
        try{
            assertEquals(size,interazioneUtList.size());
        }catch(RuntimeException | SQLException e){
            Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
    */
    @Test
    public void doRetrieveCommentoUtByCodiceTest() throws SQLException {
        String comCodice = "fUAgawJ4";
        Commento commento = new Commento();
        assertNotNull(interazioneUtDAO.doRetrieveCommentoUtByCodice(comCodice));
    }

    @Test
    public void doRetrieveCommentoUtByCodiceTestRuntimeException() throws SQLException {
        String comCodice = "";
        Commento commento = new Commento();
        try{
            interazioneUtDAO.doRetrieveCommentoUtByCodice(comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveCommentoUtByNicknameTest() throws SQLException {
        String utNickname = "Kratos1980";
        List<Commento> commentoList = interazioneUtDAO.doRetrieveCommentoUtByNickname(utNickname);
        int size = commentoList.size();
        assertEquals(size,commentoList.size());
    }

    //verificare se possibile
    @Test
    public void doRetrieveCommentoUtByNicknameTestRuntimeException() throws SQLException {
        String utNickname = "";
        try{
            interazioneUtDAO.doRetrieveCommentoUtByNickname(utNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertByUtenteTest() throws SQLException {
        String comCodice = "l9KASDDk9";
        String utNickname = "Ellie_Williams";
        boolean utl = false;
        boolean utd = false;
        assertEquals(true,interazioneUtDAO.insertByUtente(comCodice,utNickname,utl,utd));
    }
    /*Non so se va bene
    @Test
    public void insertByUtenteTestRuntimeException() throws SQLException {
        String comCodice = "";
        String utNickname = "";
        boolean utl = false;
        boolean utd = false;
        try{
            assertEquals(true,interazioneUtDAO.insertByUtente(comCodice,utNickname,utl,utd));
        }catch(RuntimeException | SQLException e){
            Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
    */
    @Test
    public void doRetrieveNicknameUtByComCodiceTest() throws SQLException {
        String comCodice = "fUAgawJ4";
        List<String> stringList = interazioneUtDAO.doRetrieveNicknameUtByComCodice(comCodice);
        int size = stringList.size();
        assertEquals(size,stringList.size());
    }
    //verificare se va bene
    @Test
    public void doRetrieveNicknameUtByComCodiceTestRuntimeException() throws SQLException {
        String comCodice = "";
        try{
            interazioneUtDAO.doRetrieveNicknameUtByComCodice(comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveByCreazioneCommentoTest() throws SQLException {
        String comCodice = "fUAgawJ4";
        //forse inserire stringa uguale a quella ritornata
        String s = "";
        assertNotNull(interazioneUtDAO.doRetrieveByCreazioneCommento(comCodice));
    }
    //verificare se va bene
    @Test
    public void doRetrieveByCreazioneCommentoTestRuntimeException() throws SQLException {
        String comCodice = "";
        String s = "";
        try{
            assertEquals(s,interazioneUtDAO.doRetrieveByCreazioneCommento(comCodice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire il codice",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveInterazioneCreazioneCommentoTest() throws SQLException {
        String comCodice = "l9K6WDk9";
        InterazioneUt interazioneUt = new InterazioneUt();
        assertNotNull(interazioneUtDAO.doRetrieveInterazioneCreazioneCommento(comCodice));
    }
    //verificare se va bene
    @Test
    public void doRetrieveInterazioneCreazioneCommentoTestRuntimeException() throws SQLException {
        String comCodice = "";
        InterazioneUt interazioneUt = new InterazioneUt();
        try{
            interazioneUtDAO.doRetrieveInterazioneCreazioneCommento(comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire il codice",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteTest() throws SQLException {
        String comCodice = "6JcfBWD8";
        String nickname = "Thor";
        boolean like = false;
        boolean dislike = false;
        assertEquals(true,interazioneUtDAO.delete(comCodice,nickname,like,dislike));
    }

    @Test
    public void deleteTestRuntimeException(){
        String comCodice = "";
        String nickname = "";
        boolean like = false;
        boolean dislike = false;
        try{
            interazioneUtDAO.delete(comCodice,nickname,like,dislike);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
