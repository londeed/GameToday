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

@WebServlet(name = "VideogiocoServlet", value = "/VideogiocoServlet")
public class VideogiocoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String videogioco = request.getParameter("videogioco");
            List<Videogioco> videogiocoList = new ArrayList<>();
            VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
            videogiocoList = videogiocoDAO.doRetrieveAllByTitolo();
            request.setAttribute("videogioco", videogiocoList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoVideogioco.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
