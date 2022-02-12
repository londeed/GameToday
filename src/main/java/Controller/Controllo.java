package Controller;

import Model.Connessione.InvalidRequestException;
import Model.Connessione.RequestValidator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Classe utilizzata per gestire i path delle richieste per i metodi doGet e doPost
 */

public abstract class Controllo extends HttpServlet {

    /**
     * Questo metodo prende la richiesta e indirizza nei vari case
     * @param request
     * @return PathInfo
     */

    protected String getPath(HttpServletRequest request){
        return request.getPathInfo() != null ? request.getPathInfo() : "/";
    }

    /**
     * Questo metodo crea dinamicamente i path dei response
     * @param viewPath
     * @return Path dinamici
     */

    protected  String view(String viewPath){
        String basePath = getServletContext().getInitParameter("basePath");
        String engine = getServletContext().getInitParameter("engine");
        return  basePath + viewPath + engine;
    }

    /**
     * Questo metodo permette il ritorno alle pagine precedenti
     * @param request
     * @return Path pagina precedente
     */

    protected String back(HttpServletRequest request){
        return request.getServletPath() + request.getPathInfo();
    }

    /**
     * Questo metodo serve per la gestione degli errori
     * @param validator
     * @throws InvalidRequestException
     */

    protected void validate(RequestValidator validator) throws InvalidRequestException {
        if(validator.hasErrors()){
            throw  new InvalidRequestException("Validation Error",validator.getErrors(), HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    /**
     * Questo metodo fornisce la path con la radice del Server Tomcat
     * @return Path utilizzabile con Server Tomcat
     */

    protected String getUploadPath(){

        return  System.getenv("CATALINA_HOME")+File.separator + "uploads" + File.separator;
    }

    /**
     * Questo metodo fornisce per iterare su più pagine
     * @param request
     * @return Numero di pagine
     */

    protected int parsePage(HttpServletRequest request){
        return  Integer.parseInt(request.getParameter("page"));
    }



}
