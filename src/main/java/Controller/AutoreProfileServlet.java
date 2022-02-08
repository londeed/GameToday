package Controller;

import Model.Amministratore.Amministratore;
import Model.Amministratore.AmministratoreDAO;
import Model.Autore.Autore;
import Model.Autore.AutoreDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AutoreProfileServlet", value = "/autoreProfile/*")
public class AutoreProfileServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputRicerca = request.getParameter("gestioneAutore");
            switch (inputRicerca) {
                case "gestioneProfiloAutore":
                    String id = request.getSession(false).getId();
                    Autore autore = new Autore();
                    autore = (Autore) request.getSession().getAttribute("userAu");
                    AutoreDAO autoreDAO = new AutoreDAO();
                    request.setAttribute("autore", autore);
                    System.out.println("okokok");
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/autore/gestioneProfilo.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "modificaProfilo":
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/autore/modifica.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "eliminaProfilo":
                    HttpSession session2 = request.getSession(false);
                    Autore autore1 = new Autore();
                    autore1 = (Autore) request.getSession().getAttribute("userAu");
                    AutoreDAO autoreDAO1 = new AutoreDAO();
                    autoreDAO1.deleteAutore(autore1.getAuNickname());
                    session2.removeAttribute("userAu");
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/redirect.jsp");
                    dispatcher3.forward(request, response);
                    break;
                case "logoutAutore":
                    HttpSession session = request.getSession(false);
                    Autore autore2 = (Autore) session.getAttribute("userAu");
                    session.removeAttribute("userAu");
                    RequestDispatcher dispatcher4 = request.getRequestDispatcher("/WEB-INF/redirect.jsp");
                    dispatcher4.forward(request, response);
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
                    Autore autoreSessione = new Autore();
                    autoreSessione = (Autore) request.getSession().getAttribute("userAu");
                    AutoreDAO autoreDAO = new AutoreDAO();

                    Autore autore = new Autore();
                    autore.setAuNickname(request.getParameter("AuNickname"));
                    autore.setNome(request.getParameter("AuNome"));
                    autore.setCognome(request.getParameter("AuCognome"));
                    autore.setAvatar(Integer.parseInt(request.getParameter("AuAvatar")));
                    autore.setEmail(request.getParameter("AuEmail"));
                    autore.setPassword(request.getParameter("AuPW"));
                    autore.setRecEffettuate(autoreSessione.getRecEffettuate());
                    autore.setRecCommissionate(autoreSessione.getRecCommissionate());
                    autore.setScadenza(autoreSessione.getScadenza());
                    autore.setLike(autoreSessione.getLike());
                    autore.setDislike(autoreSessione.getDislike());
                    autoreDAO.updateAutore(autore, autoreSessione.getAuNickname());
                    Autore autore1 = new Autore();
                    autore1 = autoreDAO.doRetrieveAutoreByEmail(autore.getEmail());
                    request.setAttribute("autore", autore1);
                    request.getRequestDispatcher("/WEB-INF/views/autore/gestioneProfilo.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
