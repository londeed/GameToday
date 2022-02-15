package ServletTest;

import Controller.AdminServlet;
import Controller.GeneralServlet;
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

public class GeneralServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private GeneralServlet gS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        gS = new GeneralServlet();
    }

    @Test
    public void DoGetTest() throws ServletException, IOException {
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        gS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostIfFeaturesAboutUsNullTest() throws ServletException, IOException {
        String home = "home";
        String features = null;
        String aboutUs = null;
        when(request.getParameter("home")).thenReturn(home);
        when(request.getParameter("features")).thenReturn(features);
        when(request.getParameter("aboutus")).thenReturn(aboutUs);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        gS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostIfHomeAboutUsNullTest() throws ServletException, IOException {
        String home = null;
        String features = "features";
        String aboutUs = null;
        when(request.getParameter("home")).thenReturn(home);
        when(request.getParameter("features")).thenReturn(features);
        when(request.getParameter("aboutus")).thenReturn(aboutUs);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        gS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostIfHomeFeaturesNullTest() throws ServletException, IOException {
        String home = null;
        String features = null;
        String aboutUs = "aboutUs";
        when(request.getParameter("home")).thenReturn(home);
        when(request.getParameter("features")).thenReturn(features);
        when(request.getParameter("aboutus")).thenReturn(aboutUs);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        gS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }


}
