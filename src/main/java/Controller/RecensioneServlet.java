package Controller;

import Model.Autore.Autore;
import Model.Autore.AutoreDAO;
import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.Connessione.GeneratoreCodici;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@WebServlet(name = "RecensioneServlet", value = "/RecensioneServlet")
@MultipartConfig
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
        try {
            String inputRicerca = request.getParameter("gestioneRecensioni");
            switch (inputRicerca) {
                case "visualizzaRecensioni":
                    Autore autore = (Autore) request.getSession(false).getAttribute("userAu");
                    List<Recensione> recensioneList=new ArrayList<>();
                    RecensioneDAO recensioneDAO=new RecensioneDAO();
                    recensioneList=recensioneDAO.doRetrieveByAutore(autore.getAuNickname());
                    request.setAttribute("listaRecensioni", recensioneList);
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/autore/visualizzaRecensioni.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "modifica":
                    String s=request.getParameter("codiceModifica");
                    Recensione recensione=new Recensione();
                    RecensioneDAO recensioneDAO3=new RecensioneDAO();
                    recensione=recensioneDAO3.doRetrieveByCodice(s);
                    request.setAttribute("recensione", recensione);
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/autore/modificaRecensione.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "salvaModifiche":
                    String text=request.getParameter("testoModificato");
                    String codiceModifca=request.getParameter("codiceModifica");
                    RecensioneDAO recensioneDAO4=new RecensioneDAO();
                    recensioneDAO4.updateRecensioneText(text, codiceModifca);
                    Autore autore4 = (Autore) request.getSession(false).getAttribute("userAu");
                    List<Recensione> recensioneList4=new ArrayList<>();
                    RecensioneDAO recensioneDAO5=new RecensioneDAO();
                    recensioneList=recensioneDAO5.doRetrieveByAutore(autore4.getAuNickname());
                    request.setAttribute("listaRecensioni", recensioneList);
                    RequestDispatcher dispatcher5 = request.getRequestDispatcher("/WEB-INF/views/autore/visualizzaRecensioni.jsp");
                    dispatcher5.forward(request, response);
                    break;
                case "selezionaRecensioni":
                    Autore autore12=(Autore) request.getSession(false).getAttribute("userAu");
                    List<Videogioco> videogiocoList=new ArrayList<>();
                    VideogiocoDAO videogiocoDAO=new VideogiocoDAO();
                    videogiocoList=videogiocoDAO.doRetrieveByNull();
                    request.setAttribute("lista", videogiocoList);
                    AutoreDAO autoreDAO7=new AutoreDAO();
                    Autore autoreRec1=autoreDAO7.doRetrieveAutoreByNickname(autore12.getAuNickname());
                    request.setAttribute("RecCommissionata", autoreRec1);
                    RequestDispatcher dispatcher6 = request.getRequestDispatcher("/WEB-INF/views/autore/selezionaRecensioni.jsp");
                    dispatcher6.forward(request, response);
                    break;
                case "elimina":
                    String s1=request.getParameter("codiceElimina");
                    RecensioneDAO recensioneDAO1=new RecensioneDAO();
                    recensioneDAO1.deleterecensione(s1);
                    Autore autore2 = (Autore) request.getSession(false).getAttribute("userAu");
                    List<Recensione> recensioneList2=new ArrayList<>();
                    RecensioneDAO recensioneDAO2=new RecensioneDAO();
                    recensioneList=recensioneDAO2.doRetrieveByAutore(autore2.getAuNickname());
                    request.setAttribute("listaRecensioni", recensioneList);
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/autore/visualizzaRecensioni.jsp");
                    dispatcher3.forward(request, response);
                    break;
                case "seleziona":
                    String select=request.getParameter("titolo");
                    Autore autore1=(Autore) request.getSession(false).getAttribute("userAu");
                    AutoreDAO autoreDAO=new AutoreDAO();
                    autoreDAO.updateAutoreRecCommissionate(autore1.getAuNickname(), select);
                    RecensioneDAO recensioneDAO6=new RecensioneDAO();
                    Recensione recensione1=new Recensione();
                    recensione1.setTitolo(select);
                    recensione1.setAuNickname(autore1.getAuNickname());
                    recensione1.setAuNome(autore1.getNome());
                    GeneratoreCodici gc = new GeneratoreCodici();
                    String ran = gc.GeneraCodice(5,true,true,"");
                    recensione1.setData(null);
                    recensione1.setCodice(ran);
                    recensione1.setTesto("");
                    Autore autoreRec=autoreDAO.doRetrieveAutoreByNickname(autore1.getAuNickname());
                    autore1.setRecCommissionate(select);
                    recensioneDAO6.insertRecensione(recensione1);
                    request.getSession().setAttribute("userAu", autore1);
                    request.setAttribute("RecCommissionata", autoreRec);
                    RequestDispatcher dispatcher7 = request.getRequestDispatcher("/WEB-INF/views/autore/selezionaRecensioni.jsp");
                    dispatcher7.forward(request, response);
                    break;
                case "scrivi":
                    String titolo=request.getParameter("titoloRec");
                    request.setAttribute("titolo", titolo);
                    RequestDispatcher dispatcher8 = request.getRequestDispatcher("/WEB-INF/views/autore/recensioniSelezionate.jsp");
                    dispatcher8.forward(request, response);
                    break;

                case "inserisciRec":
                    String titoloRec=request.getParameter("codiceRec");
                    String textRec=request.getParameter("testoInserito");

                    String operazione="Recensione";
                    String appPath = request.getServletContext().getRealPath("");
                    Singleton singleton=Singleton.getInstance(operazione, appPath, titoloRec, request);
                    /*
                    String SAVE_DIR ="img";
                    String appPath = request.getServletContext().getRealPath("");
                    Path pathX= FileSystems.getDefault().getPath("/");
                    String savePath = appPath + SAVE_DIR + pathX;
                    File fileSaveDir = new File(savePath + titoloRec);
                    if (!fileSaveDir.exists()) {	//Se la cartella non esiste la si crea
                        fileSaveDir.mkdir();
                    }
                    System.out.println(request.getParts());
                    int i=2;
                    for (Part part : request.getParts()) {		//Si prende l'immagine dalla richiesta
                        String fileName = request.getParameter("codiceRec") + "-"+i+".jpg";	//Si prende il path dell'immagine
                        String car=request.getParameter("codiceRec");
                        System.out.println(request.getParameter("codiceRec"));
                        if (fileName != null && !fileName.equals("")) {
                            part.write(savePath + car + File.separator + fileName);	//si inserisce la foto nella cartella temporanea
                            System.out.println(savePath + car +File.separator+ fileName);
                        }
                        i++;
                    }*/
                    Autore autore3 = (Autore) request.getSession(false).getAttribute("userAu");
                    Recensione recensione2=new Recensione();
                    RecensioneDAO recensioneDAO7=new RecensioneDAO();
                    recensioneDAO7.updateRecensioneTextbis(textRec, titoloRec);
                    AutoreDAO autoreDAO1=new AutoreDAO();
                    autore3.setRecCommissionate("");
                    autore3.setRecEffettuate(autore3.getRecEffettuate()+1);
                    request.getSession().setAttribute("userAu", autore3);
                    GregorianCalendar dataAttuale=new GregorianCalendar();
                    autoreDAO1.updateAutoreRecCommissionateBis(autore3.getAuNickname());
                    request.setAttribute("autore", autore3);
                    RequestDispatcher dispatcher9 = request.getRequestDispatcher("/WEB-INF/views/autore/gestioneProfilo.jsp");
                    dispatcher9.forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }
}
