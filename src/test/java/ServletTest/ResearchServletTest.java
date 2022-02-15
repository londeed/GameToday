package ServletTest;

import Controller.GeneralServlet;
import Controller.ResearchServlet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ResearchServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private ResearchServlet rS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        rS = new ResearchServlet();
    }

    @Test
    public void DoGetTest() throws ServletException, IOException {
        String result = "Dragon Ball";
        when(request.getParameter("result")).thenReturn(result);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        rS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
