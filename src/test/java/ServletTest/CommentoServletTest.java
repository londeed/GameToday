package ServletTest;

import Controller.CommentoServlet;
import Controller.UtenteProfileServlet;
import Model.Utente.Utente;

import org.json.JSONObject;
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

public class CommentoServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private CommentoServlet cS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        cS = new CommentoServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            cS.doGet(request,response);
        }catch(RuntimeException e){
            assertFalse(e.getMessage().contains("Unexpected value: null"));
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
@Ignore
    @Test
    public void DoGetAggiungiTest() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"numeroCom\":\"utCommento24434535\", \"codice\":192GZvGC , \"commentoRec\":\"jjjjhnn\", \"user\":\"Shadow_1995\", \"tipologia\":\"utente\"}";
        JSONObject json = new JSONObject(json_str);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungi");
        when(request.getParameter("codici")).thenReturn("json");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn("codice");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
@Ignore
    @Test
    public void DoGetAggiungiNullTest() throws ServletException, IOException {
        String codice = null;
        String json_str = "{\"numeroCom\":\"utCommento24434535\", \"codice\":192GZvGC , \"commentoRec\":\"jjjjhnn\", \"user\":\"IGN_Italia\", \"tipologia\":\"autore\"}";
        JSONObject json = new JSONObject(json_str);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getPathInfo()).thenReturn("/aggiungi");
        when(request.getParameter("codici")).thenReturn("text");
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn("text");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
@Ignore
    @Test
    public void DoGetAggiungiInterazioneTest() throws ServletException, IOException {
        String codice = null;
        String json_str = "{\"numeroCom\":\"utCommento24434535\", \"codice\":192GZvGC , \"commentoRec\":\"jjjjhnn\", \"user\":\"utente\", \"tipologia\":\"ddgg\"}";
        JSONObject json = new JSONObject(json_str);
        String text = "otjgtgotgo,Shadow_1995,utCommento24434535,192GZvGC,autore";
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getPathInfo()).thenReturn("/aggiungi");
        when(request.getParameter("interazione")).thenReturn(text);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }


}
