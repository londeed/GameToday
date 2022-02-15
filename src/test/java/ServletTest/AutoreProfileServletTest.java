package ServletTest;

import Controller.AdminProfileServlet;
import Controller.AutoreProfileServlet;
import Model.Autore.Autore;
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

public class AutoreProfileServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private AutoreProfileServlet aPS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        aPS = new AutoreProfileServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getParameter("gestioneAutore")).thenReturn(null);

        try{
            aPS.doGet(request,response);
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
            aPS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetGestioneProfiloAutoreTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2022-02-28);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("CoPlaNet");
        autore.setPassword("Coplan&3t1999");
        autore.setEmail("autore2@gmail.com");
        autore.setLike(0);
        autore.setDislike(0);
        autore.setScadenza(date);
        autore.setRecCommissionate("");
        autore.setRecEffettuate(0);
        autore.setAvatar(0);
        when(request.getParameter("gestioneAutore")).thenReturn("gestioneProfiloAutore");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetModificaProfiloTest() throws ServletException, IOException {
        when(request.getParameter("gestioneAutore")).thenReturn("modificaProfilo");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetEliminaProfiloTest() throws ServletException, IOException {
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
        autore.setRecCommissionate("");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getParameter("gestioneAutore")).thenReturn("eliminaProfilo");
        when(request.getSession(false)).thenReturn(session);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetLogoutAutoreTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2022-02-28);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("CoPlaNet");
        autore.setPassword("Coplan&3t1999");
        autore.setEmail("autore2@gmail.com");
        autore.setLike(0);
        autore.setDislike(0);
        autore.setScadenza(date);
        autore.setRecCommissionate("");
        autore.setRecEffettuate(0);
        autore.setAvatar(0);
        when(request.getParameter("gestioneAutore")).thenReturn("logoutAutore");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostModificaTest() throws ServletException, IOException {
        String avatar = "0";
        java.sql.Date date = new java.sql.Date(2022-02-28);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("CoPlaNet");
        autore.setPassword("Coplan&3t1999");
        autore.setEmail("autore2@gmail.com");
        autore.setLike(0);
        autore.setDislike(0);
        autore.setScadenza(date);
        autore.setRecCommissionate("");
        autore.setRecEffettuate(0);
        autore.setAvatar(0);
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getParameter("AuNickname")).thenReturn(autore.getAuNickname());
        //when(amministratoreAbstract.isNull()).
        when(request.getParameter("AuNome")).thenReturn(autore.getNome());
        when(request.getParameter("AuCognome")).thenReturn(autore.getCognome());
        when(request.getParameter("AuAvatar")).thenReturn(avatar);
        when(request.getParameter("AuEmail")).thenReturn(autore.getEmail());
        when(request.getParameter("AuPW")).thenReturn(autore.getPassword());
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
