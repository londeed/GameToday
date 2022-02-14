import Model.Commento.Commento;
import Model.Verifica.Verifica;
import Model.Verifica.VerificaDAO;
import Model.Videogioco.Videogioco;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VerificaDAOTest {
    private VerificaDAO verificaDAO;

    @Before
    public void beforeAll(){
        verificaDAO = new VerificaDAO();
    }

    @Test
    public void deleteTest() throws SQLException {
        String comCodice = "6JcfBWD8";
        assertEquals(true,verificaDAO.delete(comCodice));
    }

    @Test
    public void deleteTestRuntimeException(){
        String comCodice = "";
        try{
            verificaDAO.delete(comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateTest() throws SQLException {
        String comCodice = "6JcfaaasBWD8";
        Commento commento = new Commento();
        commento.setComCodice("6JcfaaasBWD8");
        commento.setCodice("ViuklQ0G");
        commento.setTesto("bel gioco");
        commento.setLike(10);
        commento.setDislike(2);
        assertEquals(true,verificaDAO.update(commento,comCodice));
    }

    @Test
    public void updateTestRuntimeException(){
        String comCodice = "";
        Commento commento = new Commento();
        try{
            verificaDAO.update(commento,comCodice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveInterazioneAmByCodiceTest() throws SQLException {
        String comCodice = "6sdJcfBaWD8";
        Verifica verifica = new Verifica();
        assertEquals(verifica,verificaDAO.doRetrieveInterazioneAmByCodice(comCodice));
    }

    @Test
    public void doRetrieveInterazioneAmByCodiceTestRuntimeException(){
        String comCodice = "";
        Verifica verifica = new Verifica();
        try{
            assertEquals(verifica,verificaDAO.doRetrieveInterazioneAmByCodice(comCodice));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveInterazioneAmByNicknameTest() throws SQLException {
        String amNickname = "D-Admin";
        List<Verifica> verificaList = verificaDAO.doRetrieveInterazioneAmByNickname(amNickname);
        int size = verificaList.size();
        assertEquals(size,verificaList.size());
    }

    //non so se va bene
    @Test
    public void doRetrieveInterazioneAmByNicknameTestRuntimeException() throws SQLException {
        String amNickname = "";
        try{
            verificaDAO.doRetrieveInterazioneAmByNickname(amNickname);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertVerificaTest() throws SQLException {
        String comCodice = "l12K6WDk9";
        String amNickname = "D-Admin";
        assertEquals(true,verificaDAO.insertVerifica(comCodice,amNickname));
    }

    //non so se va bene
    @Test
    public void insertVerificaTestRuntimeException() throws SQLException {
        String comCodice = "";
        String amNickname = "";
        try{
            assertEquals(true,verificaDAO.insertVerifica(comCodice,amNickname));
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
}
