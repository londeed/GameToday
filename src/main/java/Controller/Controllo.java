package Controller;

import Model.Connessione.InvalidRequestException;
import Model.Connessione.RequestValidator;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public abstract class Controllo extends HttpServlet {

    protected String getPath(HttpServletRequest request){
        return request.getPathInfo() != null ? request.getPathInfo() : "/";
    }

    protected  String view(String viewPath){
        String basePath = getServletContext().getInitParameter("basePath");
        String engine = getServletContext().getInitParameter("engine");
        return  basePath + viewPath + engine;
    }

    protected String back(HttpServletRequest request){
        return request.getServletPath() + request.getPathInfo();
    }

    protected void validate(RequestValidator validator) throws InvalidRequestException {
        if(validator.hasErrors()){
            throw  new InvalidRequestException("Validation Error",validator.getErrors(), HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    protected String getUploadPath(){

        return  System.getenv("CATALINA_HOME")+File.separator + "uploads" + File.separator;
    }

    protected int parsePage(HttpServletRequest request){
        return  Integer.parseInt(request.getParameter("page"));
    }



}
