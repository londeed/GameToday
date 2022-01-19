package Controller;

import Model.Recensione.Recensione;
import Model.Recensione.RecensioneDAO;
import Model.Videogioco.Videogioco;
import Model.Videogioco.VideogiocoDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RecensioneServlet", value = "/RecensioneServlet")
public class RecensioneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String recensione = request.getParameter("recensione");
            RecensioneDAO recensioneDAO = new RecensioneDAO();
            List<Recensione> recuperaRecensioni = new ArrayList<>();
            recuperaRecensioni = recensioneDAO.doRetrieveAllByDataPubblicazione();
            int count = 0;
            if (recensione == null) {
                while (count <= recuperaRecensioni.size()) {
                    String s = recuperaRecensioni.get(count).getTitolo();
                    String dettaglioRecensione = request.getParameter(s);
                    System.out.println(dettaglioRecensione);
                    if (dettaglioRecensione != null) {
                        Recensione recensione1 = new Recensione();
                        recensione1 = recensioneDAO.doRetrieveByCodice(dettaglioRecensione);
                        request.setAttribute("dettaglioRecensione", recensione1);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recensione/recensione.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                    count++;
                }
            } else {
                List<Recensione> recensioneList = new ArrayList<>();
                recensioneList = recensioneDAO.doRetrieveAllByDataPubblicazione();
                request.setAttribute("recensione", recensioneList);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoRecensioni.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
