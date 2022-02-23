package ServletTest;

import Controller.UtenteProfileServlet;
import Controller.VideogiocoServlet;
import Model.Amministratore.Amministratore;
import Model.Utente.Utente;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

public class VideogiocoServletTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;
    private VideogiocoServlet vS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        vS = new VideogiocoServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getPathInfo()).thenReturn(null);

        try{
            vS.doGet(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetValutazioneTest() throws ServletException, IOException {
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
        String json_str = "{\"valutazione\":\"4\",\"titolo\":\"Bloodborne\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getPathInfo()).thenReturn("/valutazione");
        when(request.getParameter("val")).thenReturn(json);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getSession()).thenReturn(session);
        vS.doGet(request,response);
    }

    @Test
    public void DoPostTest() throws ServletException, IOException {
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
        when(request.getParameter("videogioco")).thenReturn(null);
        when(request.getParameter("dettaglioVideogioco")).thenReturn("God of War IV");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        vS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostNotNullTest() throws ServletException, IOException {
        when(request.getParameter("videogioco")).thenReturn("God of War IV");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        vS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
}
