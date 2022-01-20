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

@WebServlet(name = "VideogiocoServlet", value = "/VideogiocoServlet")
public class VideogiocoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {/*
            String videogioco = request.getParameter("videogioco");
            List<Videogioco> videogiocoList = new ArrayList<>();
            VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
            videogiocoList = videogiocoDAO.doRetrieveAllByTitolo();
            request.setAttribute("videogioco", videogiocoList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoVideogioco.jsp");
            dispatcher.forward(request, response);*/


            String videogioco = request.getParameter("videogioco");
            List<Videogioco> videogiocoList = new ArrayList<>();
            List<Videogioco> recuperaVideogiochi = new ArrayList<>();
            VideogiocoDAO videogiocoDAO = new VideogiocoDAO();
            recuperaVideogiochi = videogiocoDAO.doRetriveAll();
            int count = 0;
            if (videogioco == null) {
                while (count <= recuperaVideogiochi.size()) {
                    String s = recuperaVideogiochi.get(count).getTitolo();
                    String dettaglioVideogioco= request.getParameter("dettaglioVideogioco");
                    if (dettaglioVideogioco != null) {
                        Videogioco videogioco1 = new Videogioco();
                        videogioco1 = videogiocoDAO.doRetrieveByTitolo(dettaglioVideogioco);
                        request.setAttribute("dettaglioVideogioco", videogioco1);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/videogioco/videogioco.jsp");
                        dispatcher.forward(request, response);
                        break;
                    }
                    count++;

                }
            } else {
                List<Videogioco> videogiocoList1 = new ArrayList<>();
                videogiocoList1 = videogiocoDAO.doRetrieveAllByTitolo();
                request.setAttribute("videogioco", videogiocoList1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/catalogo/catalogoVideogioco.jsp");
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
