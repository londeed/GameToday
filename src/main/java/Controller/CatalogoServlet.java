package Controller;

import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CatalogoServlet", value = "/Catalogo")
public class CatalogoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputRicerca = request.getParameter("piattaforma");
            switch (inputRicerca) {
                case "PC":
                    List<Videogioco> videogiocoList = new ArrayList<Videogioco>();
                    VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
                    videogiocoList = videogiocoDAO.doRetriveByPiattaforma(inputRicerca);
                    request.setAttribute("lista", videogiocoList);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogo.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "Playstation 4":
                    List<Videogioco> videogiocoList1 = new ArrayList<Videogioco>();
                    VideogiocoDAO videogiocoDAO1 = new VideogiocoDAO();
                    videogiocoList1 = videogiocoDAO1.doRetriveByPiattaforma(inputRicerca);
                    request.setAttribute("lista", videogiocoList1);
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogo.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "Xbox One":
                    List<Videogioco> videogiocoList2 = new ArrayList<Videogioco>();
                    VideogiocoDAO videogiocoDAO2 = new VideogiocoDAO();
                    videogiocoList2 = videogiocoDAO2.doRetriveByPiattaforma(inputRicerca);
                    request.setAttribute("lista", videogiocoList2);
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogo.jsp");
                    dispatcher2.forward(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/index.jsp");
                    dispatcher3.forward(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

