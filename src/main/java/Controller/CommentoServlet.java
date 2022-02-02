package Controller;

import Model.Commento.Commento;
import Model.Commento.CommentoDAO;
import Model.Connessione.GeneratoreCodici;
import Model.InterazioneAu.InterazioneAu;
import Model.InterazioneAu.InterazioneAuDAO;
import Model.InterazioneUt.InterazioneUt;
import Model.InterazioneUt.InterazioneUtDAO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
            request.getSession().setAttribute("codiceCommento", codComm);
        }
        try {
          String path = getPath(request);
            switch (path) {
               case "/aggiungi":
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
                    commento.setCodice(codici.get(2));
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
                            }
                            if(codici.get(3).equals("utente")){
                                InterazioneUtDAO interazioneUtDAO = new InterazioneUtDAO();
                                interazioneUtDAO.insertByUtente(s,codici.get(1),false,false);
                            }else{
                                InterazioneAuDAO interazioneAuDAO = new InterazioneAuDAO();
                                interazioneAuDAO.insertByAutore(s,codici.get(1),false,false);
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
                    JSONObject jObjecto2 = new JSONObject(request.getParameter("numeroCommento"));
                    Iterator itero2 = jObjecto2.keys(); //gets all the keys
                    ArrayList<String> interazione = new ArrayList<>();
                    System.out.println("non va bene");
                    while (itero2.hasNext()) {
                        String key = (String) itero2.next(); // get key
                        Object o = jObjecto2.get(key); // get value
                        interazione.add((String) o);
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
                    JSONObject jObjecto3 = new JSONObject(request.getParameter("interazione"));
                    Iterator itero3 = jObjecto3.keys(); //gets all the keys
                    ArrayList<String> interazione2 = new ArrayList<>();
                    while (itero3.hasNext()) {
                        String key = (String) itero3.next(); // get key
                        Object o = jObjecto3.get(key); // get value
                        interazione2.add((String) o);
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    if (interazione2.get(1).equals("1")){
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        List<String> al = new ArrayList<>();
                        al = (List<String>) request.getSession().getAttribute("codiceCommento");
                        for(String a : al){
                            System.out.println(a);
                        }
                        int count2 = 1;
                        System.out.println(al.size());
                        while(al.size()>=count2){
                            System.out.println(al.get(1));
                            System.out.println(interazione2.get(2));
                            if(al.get(count2).equals(interazione2.get(0))){
                                commentoDao2.updateInterazione(al.get(count2-1), "1");
                                break;
                            }
                            count2 += 2;
                        }
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
                    }
                    break;
                case "/aggiungiInterazioneEsistente":
                    JSONObject jObjecto4 = new JSONObject(request.getParameter("interazione"));
                    Iterator itero4 = jObjecto4.keys(); //gets all the keys
                    ArrayList<String> interazione3 = new ArrayList<>();
                    while (itero4.hasNext()) {
                        String key = (String) itero4.next(); // get key
                        Object o = jObjecto4.get(key); // get value
                        interazione3.add((String) o);
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    if (interazione3.get(0).equals("false")){
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        commentoDao2.updateInterazione(interazione3.get(2), "1");
                    }else{
                        CommentoDAO commentoDao2 = new CommentoDAO();
                        commentoDao2.updateInterazione(interazione3.get(2), "0");
                    }
                    break;
                /*case "/Rimuovi":
                    JSONObject jObjecto5 = new JSONObject(request.getParameter("interazione"));
                    System.out.println ("so2");
                    Iterator itero5 = jObjecto5.keys(); //gets all the keys
                    ArrayList<String> rimozione = new ArrayList<>();
                    System.out.println ("so3");
                    while (itero5.hasNext()) {
                        System.out.println ("so4");
                        String key = (String) itero5.next(); // get key
                        Object o = jObjecto5.get(key); // get value
                        System.out.println ("so5");
                        rimozione.add((String) o);
                        System.out.println ("so6");
                        System.out.println(key + " : " + o); // print the key and value
                    }
                    CommentoDAO commentoDao3 = new CommentoDAO();
                    commentoDao3.deleteCommento(rimozione.get(0));
                    break;*/
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
