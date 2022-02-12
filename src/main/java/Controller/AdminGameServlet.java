package Controller;

import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.Recensione.Recensione;
import Model.Recensione.RecensioneDAO;
import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet per la gestione dei videogiochi da parte dell'amministratore
 */

@WebServlet(name = "AdminGameServlet", value = "/adminGame/*")
@MultipartConfig
public class AdminGameServlet extends Controllo {

    /**
     * metodo doGet della Servlet AdminGameServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputRicerca = request.getParameter("gestioneVideogiochi");
            switch (inputRicerca) {
                case "inserisci":
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/admin/inserisciVideogioco.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "elimina":
                    List<Videogioco> videogiocoList1 = new ArrayList<>();
                    VideogiocoDAO videogiocoDAO1 = new VideogiocoDAO();
                    videogiocoList1 = videogiocoDAO1.doRetriveAll();
                    List<String> titoli1 = new ArrayList<>();
                    for (int i=0; i<videogiocoList1.size(); i++) {
                        titoli1.add(videogiocoList1.get(i).getTitolo());
                    }
                    request.setAttribute("titoli", titoli1);
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/admin/eliminaVideogioco.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "modifica":
                    List<Videogioco> videogiocoList = new ArrayList<>();
                    VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
                    videogiocoList = videogiocoDAO.doRetriveAll();
                    List<String> titoli = new ArrayList<>();
                    for (int i=0; i<videogiocoList.size(); i++) {
                        titoli.add(videogiocoList.get(i).getTitolo());
                    }
                    request.setAttribute("titoli", titoli);
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/admin/modificaVideogioco.jsp");
                    dispatcher3.forward(request, response);
                    break;
                case "controlloRecensione":
                    List<Recensione> recensioneList=new ArrayList<>();
                    RecensioneDAO recensioneDAO=new RecensioneDAO();
                    recensioneList=recensioneDAO.doRetrieveAllByDataisNull();
                    request.setAttribute("lista", recensioneList);
                    RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/admin/controlloRecensione.jsp");
                    dispatcher4.forward(request, response);
                    break;
                case "controlloCommento":
                    List<Commento> commentoList=new ArrayList<>();
                    CommentoDAO commentoDAO=new CommentoDAO();
                    commentoList=commentoDAO.doRetrieveAll();
                    request.setAttribute("lista", commentoList);
                    RequestDispatcher dispatcher5 = request.getRequestDispatcher("/WEB-INF/views/admin/controlloCommento.jsp");
                    dispatcher5.forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo doPost della Servlet AdminGameServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/create":
                    Videogioco videogioco=new Videogioco();
                    VideogiocoDAO videogiocoDAO=new VideogiocoDAO();
                    videogioco.setTitolo(request.getParameter("Titolo"));
                    videogioco.setPegi(Integer.parseInt(request.getParameter("Pegi")));
                    videogioco.setTotaleVoti(0);
                    videogioco.setCasaProduttrice(request.getParameter("CasaProduttrice"));
                    videogioco.setMediaValutazioni(0);
                    videogioco.setPiattaforma(request.getParameter("Piattaforma"));
                    videogioco.setDataPubblicazione(Date.valueOf(request.getParameter("DataPubblicazione")));
                    videogioco.setTipologia(request.getParameter("Tipologia"));
                    videogiocoDAO.insertVideogioco(videogioco);

                    String operazione="Videogioco";
                    String appPath = request.getServletContext().getRealPath("");
                    /**
                     * Utilizzo design pattern 'SINGLETON'
                     */
                    Singleton singleton=Singleton.getInstance(operazione, appPath, request.getParameter("Titolo"), request);
                    request.getRequestDispatcher("/WEB-INF/views/admin/result.jsp").forward(request, response);
                    break;
                case "/elimina":
                    VideogiocoDAO videogiocoDAO1=new VideogiocoDAO();
                    videogiocoDAO1.deleteVideogico(request.getParameter("Titolo"));
                    request.getRequestDispatcher("/WEB-INF/views/admin/result.jsp").forward(request, response);
                    break;
                case "/modifica":
                    String s = request.getParameter("Titolo");
                    Videogioco videogioco2=new Videogioco();
                    VideogiocoDAO videogiocoDAO2=new VideogiocoDAO();
                    Videogioco videogiocoTmp = new Videogioco();
                    videogiocoTmp = videogiocoDAO2.doRetrieveByTitolo(s);
                    videogioco2.setTitolo(request.getParameter("Titolo"));
                    videogioco2.setPegi(Integer.parseInt(request.getParameter("Pegi")));
                    videogioco2.setTotaleVoti(videogiocoTmp.getTotaleVoti());
                    videogioco2.setCasaProduttrice(request.getParameter("CasaProduttrice"));
                    videogioco2.setMediaValutazioni(videogiocoTmp.getMediaValutazioni());
                    videogioco2.setPiattaforma(request.getParameter("Piattaforma"));
                    videogioco2.setDataPubblicazione(videogiocoTmp.getDataPubblicazione());
                    videogioco2.setTipologia(request.getParameter("Tipologia"));
                    videogiocoDAO2.updateVideogioco(videogioco2, s);
                    request.getRequestDispatcher("/WEB-INF/views/admin/result.jsp").forward(request, response);
                    break;
                case "/approvaRec":
                    String titolo=request.getParameter("codiceApprova");
                    RecensioneDAO recensioneDAO7=new RecensioneDAO();
                    recensioneDAO7.updateRecensioneApprovata(titolo);
                    List<Recensione> recensioneList=new ArrayList<>();
                    RecensioneDAO recensioneDAO=new RecensioneDAO();
                    recensioneList=recensioneDAO.doRetrieveAllByDataisNull();
                    request.setAttribute("lista", recensioneList);
                    RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/admin/controlloRecensione.jsp");
                    dispatcher4.forward(request, response);
                    break;
                case"/eliminaRec":
                    String titoloElimina=request.getParameter("codiceElimina");
                    RecensioneDAO recensioneDAO2=new RecensioneDAO();
                    recensioneDAO2.deleterecensione(titoloElimina);
                    List<Recensione> recensioneList2=new ArrayList<>();
                    recensioneList2=recensioneDAO2.doRetrieveAllByDataisNull();
                    request.setAttribute("lista", recensioneList2);
                    RequestDispatcher dispatcher5 = request.getRequestDispatcher("/WEB-INF/views/admin/controlloRecensione.jsp");
                    dispatcher5.forward(request, response);
                    break;
                case"/eliminaCom":
                    String codComm=request.getParameter("codiceElimina");
                    CommentoDAO commentoDAO=new CommentoDAO();
                    commentoDAO.deleteCommento(codComm);
                    List<Commento> commentoList=new ArrayList<>();
                    commentoList=commentoDAO.doRetrieveAll();
                    request.setAttribute("lista", commentoList);
                    RequestDispatcher dispatcher6 = request.getRequestDispatcher("/WEB-INF/views/admin/controlloCommento.jsp");
                    dispatcher6.forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {

            if (s.trim().startsWith("filename")) {

                return s.substring(s.indexOf("=") + 2, s.length()-1);

            }
        }
        return "";
    }

}
