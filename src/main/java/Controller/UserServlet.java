package Controller;

import Model.Autore.Autore;
import Model.Autore.AutoreAbstract;
import Model.Autore.AutoreDAO;
import Model.Autore.AutoreFactory;
import Model.Utente.Utente;
import Model.Utente.UtenteAbstract;
import Model.Utente.UtenteDAO;
import Model.Utente.UtenteFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Servlet per le operazioni base fornite all'amministratore
 */

@WebServlet(name = "UserServlet", value = "/UserServlet/*")
public class UserServlet extends Controllo {

    /**
     * metodo doGet della Servlet UserServlet
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
                case "/toLogin":
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/partials/login.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo doPost della Servlet UserServlet
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
                    UtenteAbstract utenteAbstract= UtenteFactory.getEmail(request.getParameter("email"));
                    if(utenteAbstract.isNull()){
                        AutoreAbstract autoreAbstract= AutoreFactory.getEmail(request.getParameter("email"));
                        if(autoreAbstract.isNull()){
                            request.getRequestDispatcher("/WEB-INF/views/errore/errorLogin.jsp").forward(request, response);
                            break;
                        }
                    }
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    UtenteDAO utenteDAO = new UtenteDAO();
                    AutoreDAO autoreDAO = new AutoreDAO();
                    Utente utente = utenteDAO.loginUtente(email,password);
                    Autore autore = autoreDAO.loginAutore(email,password);
                    if(utente != null && utente.getUtNickname()!=null) {
                        request.getSession(true).setAttribute("userUt",utente);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/partials/redirect.jsp");
                        dispatcher.forward(request, response);
                    }
                    if(autore != null && autore.getAuNickname()!=null) {
                        request.getSession(true).setAttribute("userAu",autore);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/partials/redirect.jsp");
                        dispatcher.forward(request, response);
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/errore/errorLogin.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
