package ServletTest;

import Controller.AutoreProfileServlet;
import Controller.CatalogoServlet;
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

public class CatalogoServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private CatalogoServlet cS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        cS = new CatalogoServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getParameter("gestioneAutore")).thenReturn(null);

        try{
            cS.doGet(request,response);
        }catch(RuntimeException e){
            assertFalse(e.getMessage().contains("Unexpected value: null"));
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DoGetPCTest() throws ServletException, IOException {
        when(request.getParameter("piattaforma")).thenReturn("PC");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetPlaystationTest() throws ServletException, IOException {
        when(request.getParameter("piattaforma")).thenReturn("Playstation");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetXboxOneTest() throws ServletException, IOException {
        when(request.getParameter("piattaforma")).thenReturn("Xbox One");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetDefaultTest() throws ServletException, IOException {
        when(request.getParameter("piattaforma")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
