package Controller;

import Model.Autore.Autore;
import Model.Autore.AutoreDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "AdminOpServlet", value = "/adminOp/*")
public class AdminOpServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputRicerca = request.getParameter("gestioneAutori");
            switch (inputRicerca) {
                case "inserisciAutore":
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/admin/inserisciAutore.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "eliminaAutore":
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/admin/eliminaAutore.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "visualizzaAutore":
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/admin/visualizzaAutore.jsp");
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
                    Autore autore = new Autore();
                    autore.setAuNickname(request.getParameter("AuNickname"));
                    autore.setNome(request.getParameter("AuNome"));
                    autore.setCognome(request.getParameter("AuCognome"));
                    autore.setAvatar(Integer.parseInt(request.getParameter("AuAvatar")));
                    autore.setRecEffettuate(Integer.parseInt(request.getParameter("REffettuate")));
                    autore.setRecCommissionate(request.getParameter("RCommissionate"));
                    autore.setEmail(request.getParameter("AuEmail"));
                    autore.setScadenza(Date.valueOf(request.getParameter("Scadenza")));
                    autore.setPassword(request.getParameter("AuPW"));
                    autore.setLike(Integer.parseInt(request.getParameter("AuLike")));
                    autore.setDislike(Integer.parseInt(request.getParameter("AuDislike")));

                    AutoreDAO autoreDAO = new AutoreDAO();
                    autoreDAO.createAutore(autore);

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
