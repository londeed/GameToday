package Controller;

import Model.Amministratore.AmministratoreAbstract;
import Model.Amministratore.AmministratoreFactory;
import Model.Autore.Autore;
import Model.Autore.AutoreAbstract;
import Model.Autore.AutoreDAO;
import Model.Autore.AutoreFactory;
import Model.Utente.Utente;
import Model.Utente.UtenteAbstract;
import Model.Utente.UtenteDAO;
import Model.Utente.UtenteFactory;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "UserServlet", value = "/UserServlet/*")
public class UserServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getPath(request);
            switch (path) {
                case "/login":
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
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/redirect.jsp");
                        dispatcher.forward(request, response);
                    }
                    if(autore != null && autore.getAuNickname()!=null) {
                        request.getSession(true).setAttribute("userAu",autore);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/redirect.jsp");
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
