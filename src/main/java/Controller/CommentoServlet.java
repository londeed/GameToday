package Controller;

import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.Connessione.GeneratoreCodici;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "CommentoServlet", value = "/CommentoServlet")
public class CommentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //try {
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
        GeneratoreCodici gc = new GeneratoreCodici();
        String s = gc.GeneraCodice(5,true,true,"#");
        System.out.println("codice commento:"+s);
                         //   break;

            }
            // like, dislike e commentoCod bisogna crearli sul momento.
            // aggiungere anche commentoCod e il nickname dell'utente/autore su interazioneAutore e interazioneUtente



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
