package ServletTest;

import Controller.AutoreProfileServlet;
import Controller.UserServlet;
import Model.Autore.Autore;
import Model.Utente.Utente;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
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

public class UserServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private UserServlet uS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        uS = new UserServlet();
    }


    @Test
    public void DoGetPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            uS.doGet(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoPostPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            uS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetUserLoginTest() throws ServletException, IOException {
        String titolo = "Sekiro: Shadows Die Twice";
        when(request.getPathInfo()).thenReturn("/toLogin");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostLoginObjNullTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/login");
        when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("email")).thenReturn(null);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostLoginUtObj1NullTest() throws ServletException, IOException {
        String email = "emi1995@gmail.com";
        String password ="BigShadow1995*";
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
        when(request.getPathInfo()).thenReturn("/login");
        when(request.getParameter("email")).thenReturn(email);
        //when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getSession(true)).thenReturn(session);


        /*when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);*/
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostLoginAuObj1NullTest() throws ServletException, IOException {
        String email = "autore1@yahoo.it";
        String password ="IGNn_141DA*3";
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("utore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getPathInfo()).thenReturn("/login");
        when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getSession(true)).thenReturn(session);

        /*when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);*/
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostLoginAuNullTest() throws ServletException, IOException {
        String email = "autore1@yahoo.it";
        String password ="IGNn_141DA*3";
        java.sql.Date date = new java.sql.Date(2023-05-12);
        Autore autore = new Autore();
        autore.setNome("Fabio");
        autore.setCognome("Marcolini");
        autore.setAuNickname("IGN_Italia");
        autore.setPassword("IGNn_141DA*3");
        autore.setEmail("utore1@yahoo.it");
        autore.setLike(2);
        autore.setDislike(3);
        autore.setScadenza(date);
        autore.setRecCommissionate("Far Cry 6");
        autore.setRecEffettuate(2);
        autore.setAvatar(20);
        when(request.getPathInfo()).thenReturn("/login");
        when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("password")).thenReturn(null);


        /*when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);*/
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostLoginUtNullTest() throws ServletException, IOException {
        String email = "emi1995@gmail.com";
        String password ="BigShadow1995*";
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
        when(request.getPathInfo()).thenReturn("/login");
        when(request.getParameter("email")).thenReturn(email);
        //when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("email")).thenReturn(null);
        when(request.getParameter("password")).thenReturn(null);


        /*when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);*/
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        uS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
