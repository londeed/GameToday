package Controller;

import Model.Autore.Autore;
import Model.Autore.AutoreDAO;
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

@WebServlet(name = "AdminOpServlet", value = "/adminGame/*")
public class AdminGameServlet extends Controllo {
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
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/admin/eliminaVideogioco.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "modifica":
                    List<Autore> autoreList=new ArrayList<>();
                    AutoreDAO autoreDAO=new AutoreDAO();
                    autoreList=autoreDAO.doRetrieveAutoreAll();
                    request.setAttribute("autori", autoreList);
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/admin/visualizzaAutore.jsp");
                    dispatcher3.forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
/*catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/


    }

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
                    videogioco.setTotaleVoti(Integer.parseInt(request.getParameter("TotaleVoti")));
                    videogioco.setCasaProduttrice(request.getParameter("CasaProduttrice"));
                    videogioco.setMediaValutazioni(Double.parseDouble(request.getParameter("MediaValutazioni")));
                    videogioco.setPiattaforma(request.getParameter("Piattaforma"));
                    videogioco.setDataPubblicazione(Date.valueOf(request.getParameter("DataPubblicazione")));
                    videogioco.setTipologia(request.getParameter("Tipologia"));
                    videogiocoDAO.insertVideogioco(videogioco);
                    request.getRequestDispatcher("/WEB-INF/views/admin/resultInsert.jsp").forward(request, response);
                    break;
                case "/elimina":
                    VideogiocoDAO videogiocoDAO1=new VideogiocoDAO();
                    videogiocoDAO1.deleteVideogico(request.getParameter("Titolo"));
                    request.getRequestDispatcher("/WEB-INF/views/admin/resultElimina.jsp").forward(request, response);
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }
}
