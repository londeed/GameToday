package Model.Connessione;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface ErrorHandler {

    /*default void authenticate (HttpSession session) throws InvalidRequestException {
        if(session == null || session.getAttribute("accountSession") == null){
            throw new InvalidRequestException("Errore autenticazione", List.of("Non sei autenticato"),
                    HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

   default void authorize(HttpSession session) throws InvalidRequestException{
        authenticate(session);
        UtenteSession us = (UtenteSession) session.getAttribute("accountSession");
        if(!us.isAdmin()){
            throw new InvalidRequestException("Errore autorizzazione", List.of("Azione non consenstita"),
                    HttpServletResponse.SC_FORBIDDEN);
        }
    }
    default void internalError() throws InvalidRequestException{
        List<String> errors = List.of("Un erore imprevisto è accaduto", "Riprova più tardi");
        throw new InvalidRequestException("Errore interno", errors, HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    default void notFound() throws InvalidRequestException{
        throw new InvalidRequestException("Errore interno", List("Risorsa non trovata"),
                HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    default  void notAllowed() throws InvalidRequestException{
        throw new InvalidRequestException("Operazione non consentita", List.of("Operazione non permessa"),
                HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }
    default void UserError() throws InvalidRequestException{
        throw new InvalidRequestException("Errore 404 Pagina non trovata",List.of("Scelta errata"),
                HttpServletResponse.SC_NOT_FOUND);
    }*/
}
