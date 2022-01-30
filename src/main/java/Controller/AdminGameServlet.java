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

@WebServlet(name = "AdminGameServlet", value = "/adminGame/*")
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
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/admin/modificaVideogioco.jsp");
                    dispatcher3.forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException e) {
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
                    break;
                case "/modifica":
                    Videogioco videogioco2=new Videogioco();
                    VideogiocoDAO videogiocoDAO2=new VideogiocoDAO();
                    videogioco2.setTitolo(request.getParameter("Titolo"));
                    videogioco2.setPegi(Integer.parseInt(request.getParameter("Pegi")));
                    videogioco2.setTotaleVoti(Integer.parseInt(request.getParameter("TotaleVoti")));
                    videogioco2.setCasaProduttrice(request.getParameter("CasaProduttrice"));
                    videogioco2.setMediaValutazioni(Double.parseDouble(request.getParameter("MediaValutazioni")));
                    videogioco2.setPiattaforma(request.getParameter("Piattaforma"));
                    videogioco2.setDataPubblicazione(Date.valueOf(request.getParameter("DataPubblicazione")));
                    videogioco2.setTipologia(request.getParameter("Tipologia"));
                    videogiocoDAO2.updateVideogioco(videogioco2, videogioco2.getTitolo());
                    request.getRequestDispatcher("/WEB-INF/views/admin/resultInsert.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }
}
