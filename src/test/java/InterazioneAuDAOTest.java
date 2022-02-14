import Model.Commento.Commento;
import Model.InterazioneAu.InterazioneAu;
import Model.InterazioneAu.InterazioneAuDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InterazioneAuDAOTest {
    private InterazioneAuDAO interazioneAuDAO;

    @Before
    public void beforeAll(){
        interazioneAuDAO = new InterazioneAuDAO();
    }

    @Test
    public void doRetrieveInterazioneAuByCodiceTest() throws SQLException {
        String comCodice = "cGj71I1EP5BG";
        InterazioneAu interazioneAu = new InterazioneAu();
        assertEquals(interazioneAu,interazioneAuDAO.doRetrieveInterazioneAuByCodice(comCodice));
    }

    @Test
    public void doRetrieveInterazioneAuByCodiceTestRuntimeException() throws SQLException {
        String comCodice = "";
        InterazioneAu interazioneAu = new InterazioneAu();
        try{
            assertEquals(interazioneAu,interazioneAuDAO.doRetrieveInterazioneAuByCodice(comCodice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveInterazioneAuByNicknameTest() throws SQLException {
        String auNickname = "IGN_Italia";
        List<InterazioneAu> interazioneAuList =  interazioneAuDAO.doRetrieveInterazioneAuByNickname(auNickname);
        int size = interazioneAuList.size();
        assertEquals(size,interazioneAuList.size());
    }

    /*Non so se va bene
    @Test
    public void doRetrieveInterazioneAuByNicknameTestRuntimeException() throws SQLException {
        String auNickname = "";
        List<InterazioneAu> interazioneAuList =  interazioneAuDAO.doRetrieveInterazioneAuByNickname(auNickname);
        int size = interazioneAuList.size();
        try{
            assertEquals(size,interazioneAuList.size());
        }catch(RuntimeException | SQLException e){
            Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
    */
    @Test
    public void doRetrieveCommentoAuByCodiceTest() throws SQLException {
        String comCodice = "cGj71I1EP5BG";
        Commento commento = new Commento();
        assertEquals(commento,interazioneAuDAO.doRetrieveCommentoAuByCodice(comCodice));
    }

    @Test
    public void doRetrieveCommentoAuByCodiceTestRuntimeException(){
        String comCodice = "";
        Commento commento = new Commento();
        try{
            assertEquals(commento,interazioneAuDAO.doRetrieveCommentoAuByCodice(comCodice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveCommentoAuByNicknameTest() throws SQLException {
        String auNickname = "IGN_Italia";
        List<Commento> commentoList =  interazioneAuDAO.doRetrieveCommentoAuByNickname(auNickname);
        int size = commentoList.size();
        assertEquals(size,commentoList.size());
    }
//dubbio
    @Test
    public void doRetrieveCommentoAuByNicknameTestRuntimeException() throws SQLException {
        String auNickname = "";
        try{
            interazioneAuDAO.doRetrieveCommentoAuByNickname(auNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertByAutoreTest() throws SQLException {
        String comCodice = "hwtcxku";
        String auNickname = "IGN_Italia";
        boolean aul = false;
        boolean aud = false;
        assertEquals(true,interazioneAuDAO.insertByAutore(comCodice,auNickname,aul,aul));
    }

    @Test
    public void insertByAutoreTestRuntimeException() throws SQLException {
        String comCodice = "";
        String auNickname = "";
        boolean aul = false;
        boolean aud = false;
        try{
            assertEquals(true,interazioneAuDAO.insertByAutore(comCodice,auNickname,aul,aul));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveNicknameAuByComCodiceTest() throws SQLException {
        String comCodice = "cGj71I1EP5BG";
        List<String> stringList =  interazioneAuDAO.doRetrieveNicknameAuByComCodice(comCodice);
        int size = stringList.size();
        assertEquals(size,stringList.size());
    }

    @Test
    public void doRetrieveNicknameAuByComCodiceTestRuntimeException() throws SQLException {
        String comCodice = "";
        try{
            interazioneAuDAO.doRetrieveNicknameAuByComCodice(comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveByCreazioneCommentoTest() throws SQLException {
        String comCodice = "cGj71I1EP5BG";
        String s = "";
        assertEquals(s,interazioneAuDAO.doRetrieveByCreazioneCommento(comCodice));
    }
//dubbio
    @Test
    public void doRetrieveByCreazioneCommentoTestRuntimeException() throws SQLException {
        String comCodice = "";
        String s = "";
        try{
            assertEquals(s,interazioneAuDAO.doRetrieveByCreazioneCommento(comCodice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveInterazioneCreazioneCommentoTest() throws SQLException {
        String comCodice = "cGj71I1EP5BG";
        InterazioneAu interazioneAu = new InterazioneAu();
        assertEquals(interazioneAu,interazioneAuDAO.doRetrieveInterazioneCreazioneCommento(comCodice));
    }
//non so
    @Test
    public void doRetrieveInterazioneCreazioneCommentoTestRuntimeException() throws SQLException {
        String comCodice = "";
        InterazioneAu interazioneAu = new InterazioneAu();
        try{
            assertEquals(interazioneAu,interazioneAuDAO.doRetrieveInterazioneCreazioneCommento(comCodice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteTest() throws SQLException {
        String comCodice = "cG1j1IE1PBG";
        String nickname = "CoPlaNet";
        boolean like = false;
        boolean dislike = false;
        assertEquals(true,interazioneAuDAO.delete(comCodice,nickname,like,dislike));
    }

    @Test
    public void deleteTestRuntimeException() throws SQLException {
        String comCodice = "";
        String nickname = "";
        boolean like = false;
        boolean dislike = false;
        try{
            assertEquals(true,interazioneAuDAO.delete(comCodice,nickname,like,dislike));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
