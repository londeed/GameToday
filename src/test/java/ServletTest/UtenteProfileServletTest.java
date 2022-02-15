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
}
