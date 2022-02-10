package Controller;

import Model.Autore.Autore;
import Model.Autore.AutoreDAO;
import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    List<Autore> autoreList1 = new ArrayList<>();
                    AutoreDAO autoreDAO1 = new AutoreDAO();
                    autoreList1 = autoreDAO1.doRetrieveAutoreAll();
                    List<String> nickname = new ArrayList<>();
                    for (int i=0; i<autoreList1.size(); i++) {
                        nickname.add(autoreList1.get(i).getAuNickname());
                    }
                    request.setAttribute("nickname", nickname);
                    RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/views/admin/eliminaAutore.jsp");
                    dispatcher2.forward(request, response);
                    break;
                case "visualizzaAutore":
                    List<Autore> autoreList=new ArrayList<>();
                    AutoreDAO autoreDAO=new AutoreDAO();
                    autoreList=autoreDAO.doRetrieveAutoreAll();
                    request.setAttribute("autori", autoreList);
                    RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/views/admin/visualizzaAutore.jsp");
                    dispatcher3.forward(request, response);
                    break;
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
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
                    autore.setRecEffettuate(0);
                    autore.setRecCommissionate("");
                    autore.setEmail(request.getParameter("AuEmail"));
                    autore.setScadenza(null);
                    autore.setPassword(request.getParameter("AuPW"));
                    autore.setLike(0);
                    autore.setDislike(0);
                    AutoreDAO autoreDAO = new AutoreDAO();
                    autoreDAO.createAutore(autore);
                    request.getRequestDispatcher("/WEB-INF/views/admin/result.jsp").forward(request, response);
                    break;
                case "/elimina":
                    AutoreDAO autoreDAO1=new AutoreDAO();
                    autoreDAO1.deleteAutore(request.getParameter("AuNickname"));
                    request.getRequestDispatcher("/WEB-INF/views/admin/result.jsp").forward(request, response);
                default:
                    break;
            }

        } catch (ServletException | SQLException e) {
            e.printStackTrace();
        }
    }
}
