package Controller;

import Model.Recensione.Recensione;
import Model.Recensione.RecensioneDAO;
import Model.Utente.Utente;
import Model.Utente.UtenteDAO;
import Model.Valutazione.Valutazione;
import Model.Valutazione.ValutazioneDAO;
import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "VideogiocoServlet", value = "/VideogiocoServlet/*")
public class VideogiocoServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/valutazione":
                    JSONObject jObjecto = new JSONObject(request.getParameter("val"));
                    Iterator itero = jObjecto.keys(); //gets all the keys
                    List<String> valutazione = new ArrayList<>();
                    while (itero.hasNext()) {
                        String key = (String) itero.next(); // get key
                        Object o = jObjecto.get(key); // get value
                        valutazione.add((String) o);
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    ValutazioneDAO valutazioneDAO1 = new ValutazioneDAO();
                    VideogiocoDAO videogiocoDAO2 = new VideogiocoDAO();
                    UtenteDAO utenteDAO = new UtenteDAO();
                    Utente utente = (Utente) request.getSession(false).getAttribute("userUt");
                    valutazioneDAO1.insertByUtente(valutazione.get(0), utente.getUtNickname());
                    utente.setValEffettuate((utente.getValEffettuate() + 1));
                    request.getSession().setAttribute("userUt", utente);
                    utenteDAO.updateUtente(utente, utente.getUtNickname());
                    Videogioco videogioco1 = videogiocoDAO2.doRetrieveByTitolo(valutazione.get(0));
                    int totalevoti = videogioco1.getTotaleVoti();
                    double media = videogioco1.getMediaValutazioni();
                    double faseMedia1 = totalevoti * media;
                    double faseMedia2 = faseMedia1 + Integer.parseInt(valutazione.get(1));
                    totalevoti += 1;
                    double faseMediaFinale = faseMedia2 / totalevoti;
                    videogioco1.setTotaleVoti(totalevoti);
                    videogioco1.setMediaValutazioni(faseMediaFinale);
                    videogiocoDAO2.updateVideogioco(videogioco1, videogioco1.getTitolo());
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String videogioco = request.getParameter("videogioco");
            List<Videogioco> videogiocoList = new ArrayList<>();
            List<Videogioco> recuperaVideogiochi = new ArrayList<>();
            VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
            recuperaVideogiochi = videogiocoDAO.doRetriveAll();
            int count = 0;
            if (videogioco == null) {
                while (count <= recuperaVideogiochi.size()) {
                    String s = recuperaVideogiochi.get(count).getTitolo();
                    String dettaglioVideogioco= request.getParameter("dettaglioVideogioco");
                    if (dettaglioVideogioco != null) {
                        Recensione recensione = new Recensione();
                        RecensioneDAO recensioneDAO = new RecensioneDAO();
                        Videogioco videogioco1 = new Videogioco();
                        videogioco1 = videogiocoDAO.doRetrieveByTitolo(dettaglioVideogioco);
                        Utente utente1 = (Utente) request.getSession(false).getAttribute("userUt");
                        if(!Objects.isNull(utente1)) {
                            Valutazione valutazione = new Valutazione();
                            Valutazione valutazione2 = new Valutazione();
                            ValutazioneDAO valutazioneDAO = new ValutazioneDAO();
                            valutazione = valutazioneDAO.doRetrieveValutazione(videogioco1.getTitolo(), utente1.getUtNickname());
                            if (!Objects.isNull(valutazione)) {
                                request.setAttribute("valutazione", valutazione);
                            } else {
                                valutazione2.setTitolo("");
                                valutazione2.setUtNickname("");
                                request.setAttribute("valutazione", valutazione2);
                            }
                        }
                        else{
                            Valutazione valutazione = new Valutazione();
                            valutazione.setTitolo("");
                            valutazione.setUtNickname("");
                            request.setAttribute("valutazione", valutazione);
                        }
                        recensione = recensioneDAO.doRetrieveByTitolo(videogioco1.getTitolo());
                        request.setAttribute("recensioneDettaglioVideogioco", recensione);
                        request.setAttribute("dettaglioVideogioco", videogioco1);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/videogioco/videogioco.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                    count++;

                }
            } else {
                List<Videogioco> videogiocoList1 = new ArrayList<>();
                videogiocoList1 = videogiocoDAO.doRetrieveAllByTitolo();
                request.setAttribute("videogioco", videogiocoList1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoVideogioco.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
