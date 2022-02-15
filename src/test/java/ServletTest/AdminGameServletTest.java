package ServletTest;

import Controller.AdminGameServlet;
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
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

public class AdminGameServletTest {
private HttpServletRequest request;
private HttpServletResponse response;
private HttpSession session;
private RequestDispatcher requestDispatcher;
private AdminGameServlet aGS;

    @Before
    public void before(){
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
        requestDispatcher = Mockito.mock(RequestDispatcher.class);
        aGS = new AdminGameServlet();
    }

    @Test
    public void DoGetPathNull(){
        when(request.getParameter("gestioneVideogiochi")).thenReturn(null);

        try{
            aGS.doGet(request,response);
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
            aGS.doPost(request,response);
        }catch(RuntimeException | ServletException | IOException e){
            assertTrue(e.getMessage().contains("Unexpected value: /"));
        }
    }

    @Test
    public void DoGetInserisciTest() throws ServletException, IOException {
        when(request.getParameter("gestioneVideogiochi")).thenReturn("inserisci");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetEliminaTest() throws ServletException, IOException {
        when(request.getParameter("gestioneVideogiochi")).thenReturn("elimina");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetModificaTest() throws ServletException, IOException {
        when(request.getParameter("gestioneVideogiochi")).thenReturn("modifica");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetControlloRecensioneTest() throws ServletException, IOException {
        when(request.getParameter("gestioneVideogiochi")).thenReturn("controlloRecensione");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoGetControlloCommentoTest() throws ServletException, IOException {
        when(request.getParameter("gestioneVideogiochi")).thenReturn("controlloCommento");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doGet(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }
    @Ignore
    @Test
    public void DoPostCreateTest() throws ServletException, IOException {
        String titolo = "giocone";
        String pegi = "18";
        String casaProduttrice = "azure";
        String piattaforma = "PlayStation 4";
        String dataPublicazione = "2022-03-23";
        String tipologia = "avventura";
        String a = "C:";
        String b = "Program Files";
        String c = "Apache Software Foundation";
        String d = "Tomcat 9.0";
        String e = "webapps";
        String f = "GameToday_war";
        Path pathX = FileSystems.getDefault().getPath("/");
        String savePath = a + pathX + b + pathX + c + pathX + d + pathX + e + pathX + f + pathX;
        when(request.getPathInfo()).thenReturn("/create");
        when(request.getParameter("Titolo")).thenReturn(titolo);
        when(request.getParameter("Pegi")).thenReturn(pegi);
        when(request.getParameter("CasaProduttrice")).thenReturn(casaProduttrice);
        when(request.getParameter("Piattaforma")).thenReturn(piattaforma);
        when(request.getParameter("DataPubblicazione")).thenReturn(dataPublicazione);
        when(request.getParameter("Tipologia")).thenReturn(tipologia);
        when(request.getServletContext().getRealPath("")).thenReturn("");
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostEliminaTest() throws ServletException, IOException {
        String titolo = "Sekiro: Shadows Die Twice";
        when(request.getPathInfo()).thenReturn("/elimina");
        when(request.getParameter("Titolo")).thenReturn(titolo);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostModificaTest() throws ServletException, IOException {
        String titolo = "Dragon Ball Z: Kakarot";
        String pegi = "18";
        String casaProduttrice = "azure";
        String piattaforma = "PlayStation 4";
        String dataPublicazione = "2022-03-23";
        String tipologia = "avventura";
        when(request.getPathInfo()).thenReturn("/modifica");
        when(request.getParameter("Titolo")).thenReturn(titolo);
        when(request.getParameter("Titolo")).thenReturn(titolo);
        when(request.getParameter("Pegi")).thenReturn(pegi);
        when(request.getParameter("CasaProduttrice")).thenReturn(casaProduttrice);
        when(request.getParameter("Piattaforma")).thenReturn(piattaforma);
        when(request.getParameter("Tipologia")).thenReturn(tipologia);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostApprovaRecTest() throws ServletException, IOException {
        String codiceapprova = "Horizon Zero Dawn";
        when(request.getPathInfo()).thenReturn("/approvaRec");
        when(request.getParameter("codiceApprova")).thenReturn(codiceapprova);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostEliminaRecTest() throws ServletException, IOException {
        String codice = "O4pNHEEY";
        when(request.getPathInfo()).thenReturn("/eliminaRec");
        when(request.getParameter("codiceElimina")).thenReturn(codice);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doPost(request,response);
        verify(requestDispatcher,atLeastOnce()).forward(request,response);
    }

    @Test
    public void DoPostEliminaComTest() throws ServletException, IOException {
        String codicecom = "YtMBBO3nfG";
        when(request.getPathInfo()).thenReturn("/eliminaCom");
        when(request.getParameter("codiceElimina")).thenReturn(codicecom);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
        aGS.doPost(request, response);
    }
}
