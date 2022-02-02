package Controller;

import Model.Autore.Autore;
import Model.Autore.AutoreDAO;
import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.InterazioneAu.InterazioneAu;
import Model.InterazioneAu.InterazioneAuDAO;
import Model.InterazioneUt.InterazioneUt;
import Model.InterazioneUt.InterazioneUtDAO;
import Model.Recensione.Recensione;
import Model.Recensione.RecensioneDAO;
import Model.Utente.Utente;
import Model.Utente.UtenteDAO;
import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RecensioneServlet", value = "/RecensioneServlet")
public class RecensioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String recensione = request.getParameter("recensione");
            RecensioneDAO recensioneDAO = new RecensioneDAO();
            List<Recensione> recuperaRecensioni = new ArrayList<>();
            recuperaRecensioni = recensioneDAO.doRetrieveAllByDataPubblicazione();
            int count = 0;
            if (recensione == null) {
                while (count <= recuperaRecensioni.size()) {
                    String s = recuperaRecensioni.get(count).getTitolo();
                    String dettaglioRecensione = request.getParameter("dettaglioRecensione");
                    if (dettaglioRecensione != null) {
                        Recensione recensione1 = new Recensione();
                        recensione1 = recensioneDAO.doRetrieveByTitolo(dettaglioRecensione);
                        List<Commento> commentoList = new ArrayList<>();
                        CommentoDAO commentoDAO = new CommentoDAO();
                        commentoList = commentoDAO.doRetrieveAllCommentiByCodice(recensione1.getCodice());
                        List<String> nicknameUt = new ArrayList<>();
                        List<Utente> utenteList = new ArrayList<>();
                        List<Autore> autoreList = new ArrayList<>();
                        List<String> nicknameAu = new ArrayList<>();
                        InterazioneAuDAO interazioneAuDAO = new InterazioneAuDAO();
                        InterazioneUtDAO interazioneUtDAO = new InterazioneUtDAO();
                        AutoreDAO autoreDAO = new AutoreDAO();
                        UtenteDAO utenteDAO = new UtenteDAO();
                        List<InterazioneUt> interazioneUt = new ArrayList<>();
                        List<InterazioneAu> interazioneAu = new ArrayList<>();
                        for(Commento commento: commentoList){
                            nicknameAu.add(interazioneAuDAO.doRetrieveByCreazioneCommento(commento.getComCodice()));
                            interazioneAu.add(interazioneAuDAO.doRetrieveInterazioneCreazioneCommento(commento.getComCodice()));
                        }
                        for(String nick : nicknameAu){
                            if(nick.equals("")){
                                continue;
                            }
                            autoreList.add(autoreDAO.doRetrieveAutoreByNickname(nick));
                        }
                        for(Commento commento: commentoList){
                            nicknameUt.add(interazioneUtDAO.doRetrieveByCreazioneCommento(commento.getComCodice()));
                            interazioneUt.add(interazioneUtDAO.doRetrieveInterazioneCreazioneCommento(commento.getComCodice()));
                        }
                        for(String nick : nicknameUt){
                            if(nick.equals("")){
                                continue;
                            }
                            utenteList.add(utenteDAO.doRetrieveUtenteByNickname(nick));
                        }
                        request.setAttribute("dettaglioRecensione", recensione1);
                        request.setAttribute("commenti", commentoList);
                        request.setAttribute("utenteList", utenteList);
                        request.setAttribute("autoreList", autoreList);
                        request.setAttribute("interazioneUtente", interazioneUt);
                        request.setAttribute("interazioneAutore", interazioneAu);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recensione/recensione.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                    count++;
                }
            } else {
                List<Recensione> recensioneList = new ArrayList<>();
                recensioneList = recensioneDAO.doRetrieveAllByDataPubblicazione();
                request.setAttribute("recensione", recensioneList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoRecensioni.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
