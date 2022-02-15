package ServletTest;

import Controller.AdminGameServlet;
import Controller.AdminOpServlet;
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

public class AdminOpServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private AdminOpServlet aOS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        aOS = new AdminOpServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getParameter("gestioneAutori")).thenReturn(null);

        try{
            aOS.doGet(request,response);
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
            aOS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetInserisciAutoreTest() throws ServletException, IOException {
        when(request.getParameter("gestioneAutori")).thenReturn("inserisciAutore");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aOS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetEliminaAutoreTest() throws ServletException, IOException {
        when(request.getParameter("gestioneAutori")).thenReturn("eliminaAutore");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aOS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetVisualizzaAutoreTest() throws ServletException, IOException {
        when(request.getParameter("gestioneAutori")).thenReturn("visualizzaAutore");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aOS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostCreateTest() throws ServletException, IOException {
        String auNickname = "Gamer_45";
        String auNome = "Roberto";
        String auCognome = "Magno";
        String auAvatar = "7";
        String auEmail = "RobMagn@gmail.com";
        String auPw = "RMagn*77";
        when(request.getPathInfo()).thenReturn("/create");
        when(request.getParameter("AuNickname")).thenReturn(auNickname);
        when(request.getParameter("AuNome")).thenReturn(auNome);
        when(request.getParameter("AuCognome")).thenReturn(auCognome);
        when(request.getParameter("AuAvatar")).thenReturn(auAvatar);
        when(request.getParameter("AuEmail")).thenReturn(auEmail);
        when(request.getParameter("AuPW")).thenReturn(auPw);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aOS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostEliminaTest() throws ServletException, IOException {
        String auNickname = "Gamer_45";
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getParameter("AuNickname")).thenReturn(auNickname);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aOS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
