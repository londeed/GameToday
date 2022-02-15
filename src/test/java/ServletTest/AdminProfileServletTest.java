package ServletTest;

import Controller.AdminOpServlet;
import Controller.AdminProfileServlet;
import Model.Amministratore.Amministratore;
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

public class AdminProfileServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private AdminProfileServlet aPS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        aPS = new AdminProfileServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getParameter("gestioneAmministratore")).thenReturn(null);

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
    public void DoGetGestioneProfiloTest() throws ServletException, IOException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("V-Admin");
        amministratore.setNome("Valentina");
        amministratore.setCognome("Annunziata");
        amministratore.setAvatar(5);
        amministratore.setEmail("Vadmin1@gmail.com");
        amministratore.setPassword("VAAdmin1!");
        amministratore.setVideogiochiInseriti(4);
        when(request.getParameter("gestioneAmministratore")).thenReturn("gestioneProfilo");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetModificaProfiloTest() throws ServletException, IOException {
        when(request.getParameter("gestioneAmministratore")).thenReturn("modificaProfilo");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetEliminaProfiloTest() throws ServletException, IOException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("F-Admin");
        amministratore.setNome("Fabio");
        amministratore.setCognome("Caruso");
        amministratore.setAvatar(2);
        amministratore.setEmail("Fadmin1@gmail.com");
        amministratore.setPassword("FCAdmin2!");
        amministratore.setVideogiochiInseriti(16);

        //request.getSession().setAttribute("amministratore",amministratore);
        when(request.getParameter("gestioneAmministratore")).thenReturn("eliminaProfilo");
        when(request.getSession(false)).thenReturn(session);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetLogoutTest() throws ServletException, IOException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("V-Admin");
        amministratore.setNome("Valentina");
        amministratore.setCognome("Annunziata");
        amministratore.setAvatar(5);
        amministratore.setEmail("Vadmin1@gmail.com");
        amministratore.setPassword("VAAdmin1!");
        amministratore.setVideogiochiInseriti(4);
       // request.getSession().setAttribute("amministratore",amministratore);
        when(request.getParameter("gestioneAmministratore")).thenReturn("logout");
        when(request.getSession(false)).thenReturn(session);
        //when(session.getAttribute("amministratore")).thenReturn(amministratore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostModificaTest() throws ServletException, IOException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("V-Admin");
        amministratore.setNome("Valentina");
        amministratore.setCognome("Annunziata");
        amministratore.setAvatar(5);
        String avatar = "5";
        amministratore.setEmail("Vadmin1@gmail.com");
        amministratore.setPassword("VAAdmin1!");
        amministratore.setVideogiochiInseriti(4);
        //request.getSession().setAttribute("amministratore",amministratore);
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);
        when(request.getParameter("AmNickname")).thenReturn(amministratore.getAmNickname());
        when(request.getParameter("AmNome")).thenReturn(amministratore.getNome());
        when(request.getParameter("AmCognome")).thenReturn(amministratore.getCognome());
        when(request.getParameter("AmAvatar")).thenReturn(avatar);
        when(request.getParameter("AmEmail")).thenReturn(amministratore.getEmail());
        when(request.getParameter("AmPW")).thenReturn(amministratore.getPassword());
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aPS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
