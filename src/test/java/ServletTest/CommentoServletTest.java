package ServletTest;

import Controller.CommentoServlet;

import Model.Autore.Autore;
import Model.Utente.Utente;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
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

    @Test
    public void DoGetAggiungiUtenteTest() throws ServletException, IOException {
         String text = "l9K6WDk9";
         String json_str = "{\"numeroCom\":\"utCommento24434535\", \"codice\":\"192GZvGC\" , \"commentoRec\":\"jjjjhnn\", \"user\":\"Shadow_1995\", \"tipologia\":\"utente\"}";
        //String jsonStr = "{\"name\" : \"Abcd\", \"greeting\": \"Hello\", }"; //Sample Json String
        List<String> codice= new ArrayList<>();
        codice.add("utCommento24434535");
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);


        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungi");
        when(request.getParameter("codici")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
        /*cS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);*/
    }

    @Test
    public void DoGetAggiungiAutoreTest() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"numeroCom\":\"utCommento44434535\", \"codice\":\"192GZvGC\" , \"commentoRec\":\"rerer\", \"user\":\"CoPlaNet\", \"tipologia\":\"autore\"}";
        List<String> codice= new ArrayList<>();
        codice.add("utCommento44434535");
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungi");
        when(request.getParameter("codici")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetAggiungiInterazione1Test() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"like\":\"1\", \"dislike\":\"0\" , \"numeroCommento\":\"utCommento44434535\"}";
        List<String> codice= new ArrayList<>();
        codice.add("utCommento44434535");
        codice.add("AAAgawJ4");
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungiInterazione");
        when(request.getParameter("interazione")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getSession()).thenReturn(session);
        //when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        cS.doGet(request,response);

    }

    @Test
    public void DoGetAggiungiInterazione2Test() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"like\":\"0\", \"dislike\":\"1\" , \"numeroCommento\":\"utCommento44434535\"}";
        List<String> codice= new ArrayList<>();
        codice.add("utCommento44434535");
        codice.add("AAAgawJ4");
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungiInterazione");
        when(request.getParameter("interazione")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getSession()).thenReturn(session);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetAggiungiInterazioneEsistente1Test() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"interazione\":\"false\", \"codiceCommento\":\"l9K6WDk9123\" , \"interazioneLike/Dislike\":\"dislike\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungiInterazioneEsistente");
        when(request.getParameter("interazione")).thenReturn(json);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetAggiungiInterazioneEsistente2Test() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"interazione\":\"true\", \"codiceCommento\":\"l9K6WDk9123\" , \"interazioneLike/Dislike\":\"like\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/aggiungiInterazioneEsistente");
        when(request.getParameter("interazione")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(json);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetEliminaAutoreTest() throws ServletException, IOException {
        java.sql.Date date = new java.sql.Date(2024-02-12);
        Autore autore = new Autore();
        autore.setNome("Ezio");
        autore.setCognome("Macchina");
        autore.setAuNickname("CoPlaNet");
        autore.setPassword("Coplan&3t1999");
        autore.setEmail("autore2@gmail.com");
        autore.setLike(4);
        autore.setDislike(1);
        autore.setScadenza(date);
        autore.setRecCommissionate("");
        autore.setRecEffettuate(3);
        autore.setAvatar(14);
        String text = "l9K6WDk9";
        List<String> codice= new ArrayList<>();
        codice.add("utCommento74545");
        codice.add("cG6jI1EP3BG");
        String json_str = "{\"numeroCommento\":\"utCommento74545\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getParameter("code")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(autore);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(null);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetEliminaUtenteTest() throws ServletException, IOException {
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
        String text = "l9K6WDk9";
        List<String> codice= new ArrayList<>();
        codice.add("utCommento5555");
        codice.add("YtMBBO3nfG");
        String json_str = "{\"numeroCommento\":\"utCommento5555\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getParameter("code")).thenReturn(json);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(codice);
        when(request.getSession()).thenReturn(session);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userAu")).thenReturn(null);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("userUt")).thenReturn(utente);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetEliminaCaricatiUtenteTest() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"codiceCommento\":\"cGj71I1EP5BG\",\"nickname\":\"Shadow_1995\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/eliminaCaricati");
        when(request.getParameter("code")).thenReturn(json);
        cS.doGet(request,response);
    }

    @Test
    public void DoGetEliminaCaricatiAutoreTest() throws ServletException, IOException {
        String text = "l9K6WDk9";
        String json_str = "{\"codiceCommento\":\"cGjIasdEPBG\",\"nickname\":\"CoPlaNet\"}";
        Gson gson = new Gson(); // Creates new instance of Gson
        JsonElement element = gson.fromJson (json_str, JsonElement.class); //Converts the json string to JsonElement without POJO
        JsonObject jsonObj = element.getAsJsonObject();
        String json = gson.toJson(jsonObj);
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("codiceCommento")).thenReturn(text);
        when(request.getPathInfo()).thenReturn("/eliminaCaricati");
        when(request.getParameter("code")).thenReturn(json);
        cS.doGet(request,response);
    }


}
