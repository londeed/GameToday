package Controller;

import Model.Amministratore.Amministratore;
import Model.Amministratore.AmministratoreAbstract;
import Model.Amministratore.AmministratoreDAO;
import Model.Amministratore.AmministratoreFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet per le operazioni base fornite all'amministratore
 */

@WebServlet(name = "AdminServlet", value = "/admin/*")

public class AdminServlet extends Controllo {


    /**
     * metodo doGet della Servlet AdminServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

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

    /**
     * metodo doPost della Servlet AdminServlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/login":
                    /**
                     * Utilizzo design pattern 'NULL OBJECT'
                     */
                    AmministratoreAbstract amministratoreAbstract= AmministratoreFactory.getEmail(request.getParameter("email"));
                    if(amministratoreAbstract.isNull()){
                        request.getRequestDispatcher("/WEB-INF/views/errore/errorLoginAdmin.jsp").forward(request, response);
                        break;
                    }
                    Amministratore amministratore = new Amministratore();
                    AmministratoreDAO amministratoreDAO = new AmministratoreDAO();
                    amministratore = amministratoreDAO.loginAmministratore(request.getParameter("email"), request.getParameter("password"));
                    amministratore.setEmail(request.getParameter("email"));
                    HttpSession session = request.getSession(true);
                    Amministratore amministratore1 = (Amministratore) session.getAttribute("amministatore");
                    session.setAttribute("amministratore", amministratore);
                    //session.setAttribute("amministratoreSession", amministratore);
                    //request.getSession(true).setAttribute("amministratoreSession", amministratore);
                    request.setAttribute("amministratore", amministratore);
                    request.getRequestDispatcher("/WEB-INF/views/admin/HomePageAdmin.jsp").forward(request, response);
                    break;
                case "/home":
                    String id = request.getSession(false).getId();
                    Amministratore amministratoreSessione = new Amministratore();
                    amministratoreSessione = (Amministratore) request.getSession().getAttribute("amministratore");
                    AmministratoreDAO amministratoreSessioneDAO = new AmministratoreDAO();
                    Amministratore amministratoreTmp = new Amministratore();
                    amministratoreTmp = amministratoreSessioneDAO.doRetrieveAmministratoreByEmail(amministratoreSessione.getEmail());
                    request.setAttribute("amministratore", amministratoreTmp);
                    request.getRequestDispatcher("/WEB-INF/views/admin/HomePageAdmin.jsp").forward(request, response);
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

}