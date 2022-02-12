package Model.Verifica;

import Model.Commento.Commento;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in VerificaDAO
 */

public interface VerificaInterface
{
     /**
      * metodo che interroga il database per eliminare un elemento verifica con il CommentoCod corrispondente alla
      * stringa passata come parametro
      * @param comCodice
      * @return boolean
      * @throws SQLException
      */

     Boolean delete(String comCodice) throws SQLException;

     /**
      * metodo che interroga il database per aggiornare un elemento commento con CommentoCod corrispondente alla stringa
      * passata come parametro tramite un oggetto commento passato come parametro
      * @param commento
      * @param comCodice
      * @return boolean
      * @throws SQLException
      */

     Boolean update (Commento commento, String comCodice) throws SQLException;

     /**
      * metodo che interroga il database per restituire un elemento verifica con CommentoCod corrispondente alla stringa
      * passata come parametro
      * @param comCodice
      * @return Verifica
      * @throws SQLException
      */

     Verifica doRetrieveInterazioneAmByCodice(String comCodice) throws SQLException;

     /**
      * metodo che interroga il database per restituire una lista di verifica con AmNickname corrispondente alla
      * stringa passata come parametro
      * @param amNickname
      * @return List<Verifica>
      * @throws SQLException
      */

     List<Verifica> doRetrieveInterazioneAmByNickname(String amNickname) throws SQLException;

     /**
      * metodo che interroga il database per inserire un elemento verifica tramite amNickname dell'amministratore
      * e comCodice del commento passati come parametro
      * @param comCodice
      * @param amNickname
      * @return boolean
      * @throws SQLException
      */

     Boolean insertVerifica(String comCodice, String amNickname) throws SQLException;

}
