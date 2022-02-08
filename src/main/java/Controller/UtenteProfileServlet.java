package Controller;

import Model.Utente.Utente;
import Model.Utente.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UtenteProfileServlet", value = "/utenteProfile/*")
public class UtenteProfileServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String inputRicerca = request.getParameter("gestioneUtente");
            switch (inputRicerca) {
                case "gestioneProfiloUtente":
                    String id = request.getSession(false).getId();
                    Utente utente = new Utente();
                    utente = (Utente) request.getSession().getAttribute("userUt");
                    UtenteDAO utenteDAO = new UtenteDAO();
                    request.setAttribute("utente", utente);
                    RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/views/utente/gestioneProfilo.jsp");
                    dispatcher1.forward(request, response);
                    break;
                case "modificaProfilo":
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/utente/modifica.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "registrazione" :
                    System.out.println("quiquqiqu");
                    RequestDispatcher dispatcher5 = request.getRequestDispatcher("/WEB-INF/views/partials/registrazione.jsp");
                    dispatcher5.forward(request, response);
                    break;
                case "eliminaProfilo":
                    HttpSession session2 = request.getSession(false);
                    Utente utente1 = new Utente();
                    utente1 = (Utente) request.getSession().getAttribute("userUt");
                    UtenteDAO utenteDAO1 = new UtenteDAO();
                    utenteDAO1.deleteUtente(utente1.getUtNickname());
                    session2.removeAttribute("userUt");
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/redirect.jsp");
                    dispatcher3.forward(request, response);
                    break;
                case "logoutUtente":
                    HttpSession session = request.getSession(false);
                    Utente utente2 = (Utente) session.getAttribute("userUt");
                    session.removeAttribute("userUt");
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
                    Utente utenteSessione = new Utente();
                    utenteSessione = (Utente) request.getSession().getAttribute("userUt");
                    UtenteDAO utenteDAO = new UtenteDAO();
                    Utente utente = new Utente();
                    utente.setUtNickname(request.getParameter("UtNickname"));
                    utente.setNome(request.getParameter("UtNome"));
                    utente.setCognome(request.getParameter("UtCognome"));
                    utente.setAvatar(Integer.parseInt(request.getParameter("UtAvatar")));
                    utente.setEmail(request.getParameter("UtEmail"));
                    utente.setPassword(request.getParameter("UtPW"));
                    utente.setValEffettuate(utenteSessione.getValEffettuate());
                    utente.setLike(utenteSessione.getLike());
                    utente.setDislike(utenteSessione.getDislike());
                    utenteDAO.updateUtente(utente, utenteSessione.getUtNickname());
                    Utente utente1 = new Utente();
                    utente1 = utenteDAO.doRetrieveUtenteByEmail(utente.getEmail());
                    request.setAttribute("utente", utente1);
                    request.getRequestDispatcher("/WEB-INF/views/utente/gestioneProfilo.jsp").forward(request, response);
                    break;
                case "/registrazione" :
                    Utente utenteRegistrazione = new Utente();
                    utenteRegistrazione.setUtNickname(request.getParameter("UtNickname"));
                    utenteRegistrazione.setNome(request.getParameter("UtNome"));
                    utenteRegistrazione.setCognome(request.getParameter("UtCognome"));
                    utenteRegistrazione.setAvatar(Integer.parseInt(request.getParameter("UtAvatar")));
                    utenteRegistrazione.setEmail(request.getParameter("UtEmail"));
                    utenteRegistrazione.setPassword(request.getParameter("UtPW"));
                    utenteRegistrazione.setValEffettuate(0);
                    utenteRegistrazione.setLike(0);
                    utenteRegistrazione.setDislike(0);
                    UtenteDAO utenteDAO1 = new UtenteDAO();
                    utenteDAO1.createUtente(utenteRegistrazione);
                    request.getSession(true).setAttribute("userUt",utenteRegistrazione);
                    request.getRequestDispatcher("/WEB-INF/redirect.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
