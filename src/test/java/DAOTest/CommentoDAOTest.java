package DAOTest;

import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.Recensione.Recensione;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CommentoDAOTest {
    private CommentoDAO commentoDAO;

    @Before
    public void beforeAll(){
        commentoDAO = new CommentoDAO();
    }

    @Test
    public void doRetrieveByCodiceTest() throws SQLException {
        Commento commento = new Commento();
        String codice = "192GZvGC";
        assertNotNull(commentoDAO.doRetrieveByCodice(codice));
    }

    @Test
    public void doRetrieveByCodiceTestRuntimeException(){
        Commento commento = new Commento();
        String codice = "";
        try {
            commentoDAO.doRetrieveByCodice(codice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertCommentoTest() throws SQLException {
        Commento commento = new Commento();
        commento.setComCodice("yuvxkvkx");
        commento.setCodice("192GZvGC");
        commento.setTesto("wowww");
        commento.setLike(0);
        commento.setDislike(0);
        assertEquals(true,commentoDAO.insertCommento(commento));
    }

    @Test
    public void insertCommentoTestRuntimeException() throws SQLException {
        Commento commento = new Commento();
        commento.setComCodice("");
        try {
            commentoDAO.insertCommento(commento);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[0]);
        }
    }

    @Test
    public void updateCommentoTest() throws SQLException {
        Commento commento = new Commento();
        commento.setComCodice("fUAgawJ4");
        commento.setCodice("W98Ckx8A");
        commento.setTesto("grande");
        commento.setLike(10);
        commento.setDislike(5);
        String comCodice = "fUAgawJ4";
        assertEquals(true,commentoDAO.updateCommento(commento,comCodice));
    }

    @Test
    public void updateCommentoTestRuntimeException() throws SQLException {
        Commento commento = new Commento();
        String comCodice = "";
        try {
            commentoDAO.updateCommento(commento,comCodice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteCommentoTest() throws SQLException {
        String comCodice = "6JcfBWD8";
        assertEquals(true,commentoDAO.deleteCommento(comCodice));
    }

    @Test
    public void deleteCommentoTestRuntimeException() throws SQLException {
        String comCodice = "";
        try {
            commentoDAO.deleteCommento(comCodice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void countAllTest() throws SQLException {
        int count = commentoDAO.countAll();
        int size = count;
        assertEquals(size, count);
    }

    @Test
    public void doRetrieveAllCodiciCommentiTest() throws SQLException {
        List<String> stringList = commentoDAO.doRetrieveAllCodiciCommenti();
        int size = stringList.size();
        assertEquals(size, stringList.size());
    }

    @Test
    public void doRetrieveAllCommentiByCodiceTest() throws SQLException {
        String codice = "nFxjvZ94";
        List<Commento> commentoList = commentoDAO.doRetrieveAllCommentiByCodice(codice);
        int size = commentoList.size();
        assertEquals(size, commentoList.size());
    }

    @Test
    public void doRetrieveAllCommentiByCodiceTestRuntimeException() throws SQLException {
        String codice = "";
        try {
            commentoDAO.doRetrieveAllCommentiByCodice(codice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateInterazioneTest() throws SQLException {
        String comCodice = "l9KASDDk9";
        String interazione = "0";
        assertEquals(true,commentoDAO.updateInterazione(comCodice,interazione));
    }

    @Test
    public void updateInterazioneTestRuntimeException() throws SQLException {
        String comCodice = "";
        String interazione = "";
        try {
            commentoDAO.updateInterazione(comCodice,interazione);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void updateTestoTest() throws SQLException {
        String testo = "rimangio le mie affermazioni";
        String comCodice = "l9K6Ak9";
        assertEquals(true,commentoDAO.updateTesto(testo,comCodice));
    }

    @Test
    public void updateTestoTestRuntimeException() throws SQLException {
        String testo = "";
        String comCodice = "";
        try {
            commentoDAO.updateTesto(testo,comCodice);
        } catch (RuntimeException | SQLException e) {
            assertEquals("E' necessario inserire tutti i campi", e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetrieveAllCommentinotVerfiedTest() throws SQLException {
        List<Commento> commentoList = commentoDAO.doRetrieveAllCommentinotVerfied();
        int size = commentoList.size();
        assertEquals(size, commentoList.size());
    }

    @Test
    public void doRetrieveAllTest() throws SQLException {
        List<Commento> commentoList = commentoDAO.doRetrieveAll();
        int size = commentoList.size();
        assertEquals(size, commentoList.size());
    }

    @Test
    public void doRetrieveCodiceByMaxCommenti() throws SQLException {
        String s = "";
        assertNotNull(commentoDAO.doRetrieveCodiceByMaxCommenti());
    }
}
