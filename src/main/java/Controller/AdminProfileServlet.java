package Controller;

import Model.Amministratore.Amministratore;
import Model.Amministratore.AmministratoreDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminProfileServlet", value = "/adminProfile/*")
public class AdminProfileServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputRicerca = request.getParameter("gestioneAmministratore");
            switch (inputRicerca) {
                case "gestioneProfilo":
                    String id = request.getSession(false).getId();
                    Amministratore amministratore = new Amministratore();
                    amministratore = (Amministratore) request.getSession().getAttribute("amministratore");
                    AmministratoreDAO amministratoreDAO = new AmministratoreDAO();
                    Amministratore amministratore1 = new Amministratore();
                    amministratore1 = amministratoreDAO.doRetrieveAmministratoreByEmail(amministratore.getEmail());
                    request.setAttribute("amministratore", amministratore);
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/admin/gestioneProfilo.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "modificaProfilo":
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/admin/modificaProfilo.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "eliminaProfilo":
                    String id1 = request.getSession(false).getId();
                    Amministratore amministratore2 = new Amministratore();
                    amministratore = (Amministratore) request.getSession().getAttribute("amministratore");
                    AmministratoreDAO amministratoreDAO1 = new AmministratoreDAO();
                    Amministratore amministratore3 = new Amministratore();
                    amministratore3 = amministratoreDAO1.doRetrieveAmministratoreByEmail(amministratore.getEmail());
                    amministratoreDAO1.deleteAmministratore(amministratore3.getAmNickname());
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/admin/resultElimina.jsp");
                    dispatcher3.forward(request, response);
                    break;
                case "logout":
                    HttpSession session = request.getSession(false);
                    Amministratore amministratore4 = (Amministratore) session.getAttribute("amministratore");
                    session.removeAttribute("amministratore");
                    RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/views/admin/secret.jsp");
                    dispatcher4.forward(request, response);

                    /*HttpSession session = request.getSession(false);
                    authenticate(session);
                    UtenteSession utenteSession = (UtenteSession) session.getAttribute("accountSession");
                    String redirect = utenteSession.isAdmin() ? "/WEB-INF/views/crm/secret.jsp" : "/WEB-INF/views/customer/user.jsp";
                    session.removeAttribute("accountSession");
                    session.removeAttribute("preferiti");
                    session.removeAttribute("carrello");
                    //session.invalidate();
                    PreferitiSession preferitiGuests = new PreferitiSession(0,0);
                    request.getSession(true).setAttribute("preferiti", preferitiGuests);
                    CarrelloSession carrelloGuests = new CarrelloSession(0,0);
                    request.getSession(true).setAttribute("carrello", carrelloGuests);
                    request.getRequestDispatcher(redirect).forward(request, response);
                    */
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        String path = getPath(request);
        switch (path) {
            case "/modifica":
                String id = request.getSession(false).getId();
                Amministratore amministratoreSessione = new Amministratore();
                amministratoreSessione = (Amministratore) request.getSession().getAttribute("amministratore");
                AmministratoreDAO amministratoreDAO = new AmministratoreDAO();
                Amministratore amministratoreTmp = new Amministratore();
                amministratoreTmp = amministratoreDAO.doRetrieveAmministratoreByEmail(amministratoreSessione.getEmail());

                Amministratore amministratore=new Amministratore();
                amministratore.setAmNickname(request.getParameter("AmNickname"));
                amministratore.setNome(request.getParameter("AmNome"));
                amministratore.setCognome(request.getParameter("AmCognome"));
                amministratore.setAvatar(Integer.parseInt(request.getParameter("AmAvatar")));
                amministratore.setEmail(request.getParameter("AmEmail"));
                amministratore.setPassword(request.getParameter("AmPW"));
                amministratore.setVideogiochiInseriti(amministratoreTmp.getVideogiochiInseriti());
                amministratoreDAO.updateAmministratore(amministratore, amministratoreTmp.getAmNickname());
                Amministratore amministratore1 = new Amministratore();
                amministratore1 = amministratoreDAO.doRetrieveAmministratoreByEmail(amministratore.getEmail());
                request.setAttribute("amministratore", amministratore1);
                request.getRequestDispatcher("/WEB-INF/views/admin/gestioneProfilo.jsp").forward(request, response);

                break;
            case "/logout":
                break;
            default:
                break;
         }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
