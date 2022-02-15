package ServletTest;

import Controller.RecensioneServlet;
import Controller.UtenteProfileServlet;
import Model.Autore.Autore;
import Model.Utente.Utente;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RecensioneServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private RecensioneServlet rS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        rS = new RecensioneServlet();
    }


    @Test
    public void DoPostPathNull(){
        when(request.getParameter("gestioneRecensioni")).thenReturn(null);

        try{
            rS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertFalse(e.getMessage().contains("Unexpected value: null"));
        }
    }

    @Test
    public void DoGetTest() throws ServletException, IOException {
        String recensione = "nFxjvZ94";
        when(request.getParameter("recensione")).thenReturn(recensione);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetRecNullTest() throws ServletException, IOException {
        String recensione = null;
        String titolo = "Bloodborne";
        when(request.getParameter("recensione")).thenReturn(recensione);
        when(request.getParameter("dettaglioRecensione")).thenReturn(titolo);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
@Ignore
    @Test
    public void DoGetRecNullIfNullTest() throws ServletException, IOException {
        String recensione = null;
        String titolo = null;
        when(request.getParameter("recensione")).thenReturn(recensione);
        when(request.getParameter("dettaglioRecensione")).thenReturn(titolo);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostVisualizzaRecensioniTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneRecensioni")).thenReturn("visualizzaRecensioni");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostModificaTest() throws ServletException, IOException {
        when(request.getParameter("gestioneRecensioni")).thenReturn("modifica");
        when(request.getParameter("codiceModifica")).thenReturn("192GZvGC");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostSalvaModificheTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneRecensioni")).thenReturn("salvaModifiche");
        when(request.getParameter("testoModificato")).thenReturn("yuvuberkuerueruurb");
        when(request.getParameter("codiceModifica")).thenReturn("192GZvGC");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostSelezionaRecensioniTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneRecensioni")).thenReturn("selezionaRecensioni");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostEliminaTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneRecensioni")).thenReturn("elimina");
        when(request.getParameter("codiceElimina")).thenReturn("u7G8QfPA");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostSelezionaTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneRecensioni")).thenReturn("seleziona");
        when(request.getParameter("titolo")).thenReturn("Heavy Rain");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostScriviTest() throws ServletException, IOException {
        when(request.getParameter("gestioneRecensioni")).thenReturn("scrivi");
        when(request.getParameter("titoloRec")).thenReturn("Detroit Became Human");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
@Ignore
    @Test
    public void DoPostInserisciRecTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("autore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneRecensioni")).thenReturn("inserisciRec");
        when(request.getParameter("codiceRec")).thenReturn("O4pNHEEY");
        when(request.getParameter("testoInserito")).thenReturn("Hok va bene");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
