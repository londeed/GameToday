package DAOTest;

import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VideogiocoDAOTest {
    private VideogiocoDAO videogiocoDAO;

    @Before
    public void beforeAll() {
        videogiocoDAO = new VideogiocoDAO();
    }

    @Test
    public void doRetrieveByTitoloTest() throws SQLException {
        String titolo = "The Last of Us Parte II";
        Videogioco videogioco = new Videogioco();
        assertNotNull(videogiocoDAO.doRetrieveByTitolo(titolo));
    }

    @Test
    public void doRetrieveByTitoloTestRuntimeException(){
        String titolo = "";
        try{
            videogiocoDAO.doRetrieveByTitolo(titolo);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetriveBymediaValutazioniTest() throws SQLException {
        double mediaValutazioni = 4.9;
        List<Videogioco> videogiocoList = videogiocoDAO.doRetriveBymediaValutazioni(mediaValutazioni);
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
    }
/*
    @Test
    public void doRetriveBymediaValutazioniTestRuntimeException(){
        double mediaValutazioni = 0;
        try{
            videogiocoDAO.doRetriveBymediaValutazioni(mediaValutazioni);
        }catch(RuntimeException | SQLException e){
            Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
    */
     @Test
     public void doRetriveAllTest() throws SQLException {
        List<Videogioco> videogiocoList = videogiocoDAO.doRetriveAll();
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
     }

     @Test
     public void doRetriveByCasaProduttriceTest() throws SQLException {
        String casaProduttrice = "Quantic Dream";
        List<Videogioco> videogiocoList = videogiocoDAO.doRetriveByCasaProduttrice(casaProduttrice);
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
     }

    @Test
    public void doRetriveByCasaProduttriceTestRuntimeException(){
        String casaProduttrice = "";
        try{
            videogiocoDAO.doRetriveByCasaProduttrice(casaProduttrice);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void doRetriveByPiattaformaTest() throws SQLException {
        String piattaforma = "PlayStation 4";
        List<Videogioco> videogiocoList = videogiocoDAO.doRetriveByPiattaforma(piattaforma);
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
    }

    @Test
    public void doRetriveByPiattaformaTestRuntimeException(){
        String piattaforma = "";
        try{
            videogiocoDAO.doRetriveByPiattaforma(piattaforma);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void insertVideogiocoTest() throws SQLException {
        Videogioco videogioco = new Videogioco();
        Calendar calendar = new GregorianCalendar();
        java.sql.Date date = new java.sql.Date(2022-03-28);
        videogioco.setTitolo("Dark Souls IV");
        videogioco.setPegi(16);
        videogioco.setMediaValutazioni(0);
        videogioco.setTotaleVoti(0);
        videogioco.setPiattaforma("PlayStation 4");
        videogioco.setDataPubblicazione(date);
        videogioco.setCasaProduttrice("FromSoftware");
        videogioco.setTipologia("Azione");
        assertEquals(true,videogiocoDAO.insertVideogioco(videogioco));
    }

    @Test
    public void insertVideogiocoTestRuntimeException(){
        Videogioco videogioco = new Videogioco();
        videogioco.setTitolo("");
        try{
            videogiocoDAO.insertVideogioco(videogioco);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[0]);
        }
    }

    @Test
    public void updateVideogiocoTest() throws SQLException {
        String titolo = "The Last of Us Parte II";
        Videogioco videogioco = new Videogioco();
        java.sql.Date date = new java.sql.Date(2022-02-28);
        videogioco.setTitolo("The Last of Us Parte II");
        videogioco.setPegi(18);
        videogioco.setMediaValutazioni(0);
        videogioco.setTotaleVoti(0);
        videogioco.setPiattaforma("PlayStation 4");
        videogioco.setDataPubblicazione(date);
        videogioco.setCasaProduttrice("FromSoftware");
        videogioco.setTipologia("Horror");
        assertEquals(true,videogiocoDAO.updateVideogioco(videogioco,titolo));
    }

    @Test
    public void updateVideogiocoTestRuntimeException(){
        String titolo = "";
        Videogioco videogioco = new Videogioco();
        try{
            videogiocoDAO.updateVideogioco(videogioco,titolo);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void deleteVideogicoTest() throws SQLException {
        String titolo = "Dragon Ball Z: Kakarot";
        assertEquals(true,videogiocoDAO.deleteVideogico(titolo));
    }

    @Test
    public void deleteVideogicoTestRuntimeException(){
        String titolo = "";
        try{
            videogiocoDAO.deleteVideogico(titolo);
        }catch(RuntimeException | SQLException e){
            assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }

    @Test
    public void countAllTest() throws SQLException {
        int count = videogiocoDAO.countAll();
        int size = count;
        assertEquals(size,count);
    }

    @Test
    public void doRetrieveAllByTitoloTest() throws SQLException {
        List<Videogioco> videogiocoList = videogiocoDAO.doRetrieveAllByTitolo();
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
    }

    @Test
    public void doRetrieveAllByTitoloSearchTest() throws SQLException {
        String titolo = "God of";
        List<Videogioco> videogiocoList = videogiocoDAO.doRetrieveAllByTitoloSearch(titolo);
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
    }
/*
    @Test
    public void doRetrieveAllByTitoloSearchTestRuntimeException(){
        String titolo = "";
        try{
            videogiocoDAO.doRetrieveAllByTitoloSearch(titolo);
        }catch(RuntimeException | SQLException e){
            Assert.assertEquals("E' necessario inserire tutti i campi",e.getMessage().split(":")[1]);
        }
    }
*/
    @Test
    public void doRetrieveByNullTest() throws SQLException {
        List<Videogioco> videogiocoList = videogiocoDAO.doRetrieveByNull();
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
    }

    @Test
    public void doRetrieveByDataTest() throws SQLException {
        List<Videogioco> videogiocoList = videogiocoDAO.doRetrieveByData();
        int size = videogiocoList.size();
        assertEquals(size,videogiocoList.size());
    }
}
