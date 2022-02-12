package Controller;

import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet per la ricerca dei titoli videoludici presenti nel database
 */

@WebServlet(name = "ResearchServlet", value = "/ResearchServlet")
public class ResearchServlet extends HttpServlet {

    /**
     * metodo doGet della Servlet ResearchServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String s =request.getParameter("result");
            s+="%";
            List<Videogioco> videogiocoList = new ArrayList<>();
            VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
            videogiocoList = videogiocoDAO.doRetrieveAllByTitoloSearch(s);
            request.setAttribute("videogioco", videogiocoList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoVideogioco.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }


    /**
     * Servlet sprovvista di metodo doPost poichè non si è reso necessario il passaggio di dati sensibili
     */
}