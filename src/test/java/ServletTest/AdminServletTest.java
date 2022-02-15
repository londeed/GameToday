package ServletTest;

import Controller.AdminProfileServlet;
import Controller.AdminServlet;
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

public class AdminServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private AdminServlet aS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        aS = new AdminServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            aS.doGet(request,response);
        }catch(RuntimeException e){
            assertFalse(e.getMessage().contains("Unexpected value: /"));
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DoPostPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            aS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetAdminTest() throws ServletException, IOException {
        when(request.getPathInfo()).thenReturn("/admin");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostLoginTest() throws ServletException, IOException {
        String email = "Vadmin1@gmail.com";
        String password = "VAAdmin1!";
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("V-Admin");
        amministratore.setNome("Valentina");
        amministratore.setCognome("Annunziata");
        amministratore.setAvatar(5);
        amministratore.setEmail("Vadmin1@gmail.com");
        amministratore.setPassword("VAAdmin1!");
        amministratore.setVideogiochiInseriti(4);
        when(request.getPathInfo()).thenReturn("/login");
        when(request.getParameter("email")).thenReturn(email);
        //when(amministratoreAbstract.isNull()).
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("password")).thenReturn(password);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("amministatore")).thenReturn(amministratore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoHomeTest() throws ServletException, IOException {
        Amministratore amministratore = new Amministratore();
        amministratore.setAmNickname("V-Admin");
        amministratore.setNome("Valentina");
        amministratore.setCognome("Annunziata");
        amministratore.setAvatar(5);
        amministratore.setEmail("Vadmin1@gmail.com");
        amministratore.setPassword("VAAdmin1!");
        amministratore.setVideogiochiInseriti(4);
        when(request.getPathInfo()).thenReturn("/home");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("amministratore")).thenReturn(amministratore);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }


}
