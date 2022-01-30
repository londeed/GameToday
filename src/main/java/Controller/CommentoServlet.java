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
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "CommentoServlet", value = "/CommentoServlet/*")
public class CommentoServlet extends Controllo {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codiceRec = "";
        List<String> codComm = new ArrayList<>();
        if(request.getSession(false).getAttribute("codiceCommento")==null){
            System.out.println("pppopopopo");
            request.getSession().setAttribute("codiceCommento", codComm);
            System.out.println("oppp");
        }
        System.out.println("errr");
        try {
          String path = getPath(request);
            switch (path) {
               case "/aggiungi":
                   System.out.println("trtrt");
                    JSONObject jObjecto = new JSONObject(request.getParameter("codici"));
                    Iterator itero = jObjecto.keys(); //gets all the keys
                    ArrayList<String> codici = new ArrayList<>();
                    while (itero.hasNext()) {
                        String key = (String) itero.next(); // get key
                        Object o = jObjecto.get(key); // get value
                        codici.add((String) o);
                        System.out.println(key + " : " + o); // print the key and value
                    }
                   System.out.println("kkukuukuk");
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
                            List <String> arrayList = (List<String>) request.getSession().getAttribute("codiceCommento");
                            arrayList.add(commento.getComCodice());
                            for(int i = 0;arrayList.size()<=i;i++){
                                System.out.println(arrayList.get(i));
                                System.out.println("rekekeke");
                            }
                            request.getSession().setAttribute("codiceCommento", arrayList);
                            flag = true;
                        }else {
                            s = gc.GeneraCodice(5,true,true,"#");
                            count = 0;
                        }
                    }
                    commentoDao.insertCommento(commento);
                    codiceRec = commento.getComCodice();
                    break;
                case "/salvaNumCommenti":
                    System.out.println ("1");
                    JSONObject jObjecto2 = new JSONObject(request.getParameter("numeroCommento"));
                    System.out.println ("2");
                    Iterator itero2 = jObjecto2.keys(); //gets all the keys
                    ArrayList<String> interazione = new ArrayList<>();
                    System.out.println ("3");
                    while (itero2.hasNext()) {
                        System.out.println ("4");
                        String key = (String) itero2.next(); // get key
                        Object o = jObjecto2.get(key); // get value
                        System.out.println ("5");
                        interazione.add((String) o);
                        System.out.println ("6");
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    List<String> salvataggio = new ArrayList<>();
                    salvataggio = (List<String>) request.getSession().getAttribute("codiceCommento");
                    System.out.println(interazione.get(0));
                    salvataggio.add(interazione.get(0));
                    for(String prova : salvataggio){
                        System.out.println(prova);
                    }
                    request.getSession().setAttribute("codiceCommento", salvataggio);
                    break;


                case "/aggiungiInterazione":
                    System.out.println ("i topi non avevano ma che cazzo ne so1");
                    JSONObject jObjecto3 = new JSONObject(request.getParameter("interazione"));
                    System.out.println ("i topi non avevano ma che cazzo ne so2");
                    Iterator itero3 = jObjecto3.keys(); //gets all the keys
                    ArrayList<String> interazione2 = new ArrayList<>();
                    System.out.println ("i topi non avevano ma che cazzo ne so3");
                    while (itero3.hasNext()) {
                        System.out.println ("i topi non avevano ma che cazzo ne so4");
                        String key = (String) itero3.next(); // get key
                        Object o = jObjecto3.get(key); // get value
                        System.out.println ("i topi non avevano ma che cazzo ne so5");
                        interazione2.add((String) o);
                        System.out.println ("i topi non avevano ma che cazzo ne so6");
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    System.out.println("YOYOYO");
                    if (interazione2.get(1).equals("1")){
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        List<String> al = new ArrayList<>();
                        System.out.println("etjjeej");
                        al = (List<String>) request.getSession().getAttribute("codiceCommento");
                        for(String a : al){
                            System.out.println(a);
                        }
                        System.out.println("heheh");
                        int count2 = 1;
                        System.out.println(al.size());
                        while(al.size()>=count2){
                            System.out.println(al.get(1));
                            System.out.println(interazione2.get(2));
                            if(al.get(count2).equals(interazione2.get(0))){
                                commentoDao2.updateInterazione(al.get(count2-1), "1");
                                System.out.println("flwwf");
                                break;
                            }
                            count2 += 2;
                        }
                        System.out.println("AAAAA");
                    }else{
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        List<String> al = new ArrayList<>();
                        al = (List<String>) request.getSession().getAttribute("codiceCommento");
                        int count2 = 1;
                        while(al.size()>=count2){
                            if(al.get(count2).equals(interazione2.get(0))){
                                commentoDao2.updateInterazione(al.get(count2-1), "0");
                                break;
                            }
                            count2 += 2;
                        }
                        System.out.println("BIBBIENA");
                    }
                    break;
                case "/aggiungiInterazioneEsistente":
                    System.out.println ("so1");
                    JSONObject jObjecto4 = new JSONObject(request.getParameter("interazione"));
                    System.out.println ("so2");
                    Iterator itero4 = jObjecto4.keys(); //gets all the keys
                    ArrayList<String> interazione3 = new ArrayList<>();
                    System.out.println ("so3");
                    while (itero4.hasNext()) {
                        System.out.println ("so4");
                        String key = (String) itero4.next(); // get key
                        Object o = jObjecto4.get(key); // get value
                        System.out.println ("so5");
                        interazione3.add((String) o);
                        System.out.println ("so6");
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    System.out.println("YOlo");
                    if (interazione3.get(0).equals("false")){
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        System.out.println("etjjeej");
                        commentoDao2.updateInterazione(interazione3.get(2), "1");
                        System.out.println("flwwf");
                        System.out.println("AAAAA");
                    }else{
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        commentoDao2.updateInterazione(interazione3.get(2), "0");
                        System.out.println("BIBBIENA");
                    }
                    break;
            }
        } catch (SQLException ex){
            log(ex.getMessage());
        }
    }
            // aggiungere anche commentoCod e il nickname dell'utente/autore su interazioneAutore e interazioneUtente



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
