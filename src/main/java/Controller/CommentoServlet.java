package Controller;

import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "CommentoServlet", value = "/CommentoServlet")
public class CommentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // try{
        JSONObject jObjecto = new JSONObject(request.getParameter("c"));
        Iterator itero = jObjecto.keys(); //gets all the keys
        String s = "";
        if (itero.hasNext()) {
            String key = (String) itero.next(); // get key
            Object o = jObjecto.get(key); // get value
            s = (String) o;
        }
        Commento commento = new Commento();
        CommentoDAO commentoDao = new CommentoDAO();
        // dobbiamo passare anche il codice della recensione,
        // like, dislike e commentoCod bisogna crearli sul momento.
        // aggiungere anche commentoCod e il nickname dell'utente/autore su interazioneAutore e interazioneUtente

  //  }catch (SQLException ex){
    //    log(ex.getMessage());
    //}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
