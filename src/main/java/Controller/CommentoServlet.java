package Controller;

import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.Connessione.GeneratoreCodici;
import Model.Recensione.Recensione;
import Model.Recensione.RecensioneDAO;
import com.google.gson.Gson;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CommentoServlet", value = "/CommentoServlet")
public class CommentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
         //   String path = getPath(request);
           // switch (path) {
             //   case "/aggiungi":
        JSONObject jObjecto = new JSONObject(request.getParameter("codici"));
        Iterator itero = jObjecto.keys(); //gets all the keys
        ArrayList<String> codici = new ArrayList<>();
        while (itero.hasNext()) {
            String key = (String) itero.next(); // get key
            Object o = jObjecto.get(key); // get value
            codici.add((String) o);
            System.out.println(key + " : " + o); // print the key and value
        }
        Commento commento = new Commento();
        CommentoDAO commentoDao = new CommentoDAO();
        commento.setLike(0);
        commento.setDislike(0);
        commento.setCodice(codici.get(1));
        commento.setTesto(codici.get(0));
        GeneratoreCodici gc = new GeneratoreCodici();
        String s = gc.GeneraCodice(5,true,true,"#");
        System.out.println("codice commento:"+s);

        List<String> codCommenti = new ArrayList<>();
        codCommenti = commentoDao.doRetrieveAllCodiciCommenti();
        int count = 0;
        Boolean flag = false;
        while (!flag) {
            for (String cod:codCommenti) {
                if(!s.equals(cod)) {
                    count ++;
                }
            }
            if (codCommenti.size() <= count) {
                commento.setComCodice(s);
                flag = true;
            } else {
                s = gc.GeneraCodice(5,true,true,"#");
                count = 0;
            }
        }
        commentoDao.insertCommento(commento);
            /*Recensione recensione1 = new Recensione();
            RecensioneDAO recensioneDAO = new RecensioneDAO();
            recensione1 = recensioneDAO.doRetrieveByCodice(codici.get(1));
            List<Commento> commentoList = new ArrayList<>();
            CommentoDAO commentoDAO = new CommentoDAO();
            commentoList = commentoDAO.doRetrieveAllCommentiByCodice(recensione1.getCodice());
            request.setAttribute("dettaglioRecensione", recensione1);
            request.setAttribute("commenti", commentoList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/recensione/recensione.jsp");
            dispatcher.forward(request, response);*/
            String l = ""+commento.getLike();
            String d = ""+commento.getDislike();
            List<String> list = new ArrayList<>();
            list.add(commento.getTesto());
            list.add(l);
            list.add(d);
            /*String prova = "{\"testo\":\""+list.get(0)+"\",\"like\":\""+list.get(1)+"\",\"dislike\":\""+list.get(2)+"\"}";
            JSONObject g = new JSONObject(prova);*/
            String json = new Gson().toJson(list);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
                         //   break;
        } catch (SQLException ex){
            log(ex.getMessage());
        }


            }
            // aggiungere anche commentoCod e il nickname dell'utente/autore su interazioneAutore e interazioneUtente



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
