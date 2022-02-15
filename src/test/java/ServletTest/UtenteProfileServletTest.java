package ServletTest;

import Controller.AdminGameServlet;
import Controller.UtenteProfileServlet;
import Model.Utente.Utente;
import org.junit.Before;
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

public class UtenteProfileServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private UtenteProfileServlet uPS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        uPS = new UtenteProfileServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getParameter("gestioneUtente")).thenReturn(null);

        try{
            uPS.doGet(request,response);
        }catch(RuntimeException e){
            assertFalse(e.getMessage().contains("Unexpected value: null"));
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DoPostPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            uPS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetGestioneProfiloUtenteTest() throws ServletException, IOException {
        Utente utente = new Utente();
        when(request.getParameter("gestioneUtente")).thenReturn("gestioneProfiloUtente");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetModificaProfiloTest() throws ServletException, IOException {
        when(request.getParameter("gestioneUtente")).thenReturn("modificaProfilo");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetregistrazioneTest() throws ServletException, IOException {
        when(request.getParameter("gestioneUtente")).thenReturn("registrazione");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGeteliminaProfiloTest() throws ServletException, IOException {
        Utente utente = new Utente();
        utente.setUtNickname("Hope");
        utente.setNome("Erika");
        utente.setCognome("Schiavone");
        utente.setEmail("EriSki@gmail.com");
        utente.setPassword("Speranz@24");
        utente.setValEffettuate(7);
        utente.setAvatar(17);
        utente.setLike(1);
        utente.setDislike(1);
        when(request.getParameter("gestioneUtente")).thenReturn("eliminaProfilo");
        when(request.getSession(false)).thenReturn(session);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetlogoutUtenteTest() throws ServletException, IOException {
        Utente utente = new Utente();
        utente.setUtNickname("Shadow_1995");
        utente.setNome("Emiliano");
        utente.setCognome("Rossi");
        utente.setEmail("emi1995@gmail.com");
        utente.setPassword("BigShadow1995*");
        utente.setValEffettuate(6);
        utente.setAvatar(18);
        utente.setLike(15);
        utente.setDislike(30);
        when(request.getParameter("gestioneUtente")).thenReturn("logoutUtente");
        when(request.getSession(false)).thenReturn(session);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostmodificaeTest() throws ServletException, IOException {
        Utente utente = new Utente();
        utente.setUtNickname("Shadow_1995");
        utente.setNome("Emiliano");
        utente.setCognome("Rossi");
        utente.setEmail("emi1995@gmail.com");
        utente.setPassword("BigShadow1995*");
        utente.setValEffettuate(6);
        utente.setAvatar(18);
        utente.setLike(15);
        utente.setDislike(30);
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getParameter("UtNickname")).thenReturn(utente.getUtNickname());
        when(request.getParameter("UtNome")).thenReturn(utente.getNome());
        when(request.getParameter("UtCognome")).thenReturn(utente.getCognome());
        when(request.getParameter("UtAvatar")).thenReturn("18");
        when(request.getParameter("UtEmail")).thenReturn(utente.getEmail());
        when(request.getParameter("UtPW")).thenReturn(utente.getPassword());
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostregistrazioneTest() throws ServletException, IOException {
        Utente utente = new Utente();
        utente.setUtNickname("Shad_1995");
        utente.setNome("Emilio");
        utente.setCognome("Roi");
        utente.setEmail("em995@gmail.com");
        utente.setPassword("BigShadodrcg995*");
        utente.setValEffettuate(6);
        utente.setAvatar(18);
        utente.setLike(15);
        utente.setDislike(30);
        when(request.getPathInfo()).thenReturn("/registrazione");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getParameter("UtNickname")).thenReturn(utente.getUtNickname());
        when(request.getParameter("UtNome")).thenReturn(utente.getNome());
        when(request.getParameter("UtCognome")).thenReturn(utente.getCognome());
        when(request.getParameter("UtAvatar")).thenReturn("18");
        when(request.getParameter("UtEmail")).thenReturn(utente.getEmail());
        when(request.getParameter("UtPW")).thenReturn(utente.getPassword());
        when(request.getSession(true)).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uPS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
