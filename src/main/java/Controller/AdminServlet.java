package Controller;

import Model.Amministratore.Amministratore;
import Model.Amministratore.AmministratoreDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet", value = "/admin/*")

public class AdminServlet extends Controllo {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/admin":
                    request.getRequestDispatcher("/WEB-INF/views/admin/secret.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/login":
                    Amministratore amministratore = new Amministratore();
                    AmministratoreDAO amministratoreDAO = new AmministratoreDAO();
                    amministratore = amministratoreDAO.loginAmministratore(request.getParameter("email"), request.getParameter("password"));
                    request.setAttribute("amministratore", amministratore);
                    request.getRequestDispatcher("/WEB-INF/views/admin/HomePageAdmin.jsp").forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

}