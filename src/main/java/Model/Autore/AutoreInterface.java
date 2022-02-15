package Model.Autore;

import java.sql.SQLException;
import java.util.List;

/**
 * interfaccia che implementa i metodi presenti in AutoreDAO
 */

public interface AutoreInterface
{

    /**
     * questo metodo restituisce tutti gli autori
     * @return Lista di auotri
     * @throws SQLException
     */

    List<Autore> doRetrieveAutoreAll() throws SQLException;

    /**
     * questo metodo crea un autore nel database
     * @param autore
     * @return boolean
     * @throws SQLException
     */

    Boolean createAutore(Autore autore) throws SQLException;

    /**
     * questo metodo aggiorna l'autore nel database
     * @param autore
     * @param auNickname
     * @return boolean
     * @throws SQLException
     */


    Boolean updateAutore(Autore autore, String auNickname) throws SQLException;

    /**
     * questo metodo elimina un autore presente nel database
     * @param auNickname
     * @return boolean
     * @throws SQLException
     */

    Boolean deleteAutore(String auNickname) throws SQLException;

    /**
     * questo metodo permette all'autore di effettuare il login
     * @param email
     * @param password
     * @return autore
     * @throws SQLException
     */

    Autore loginAutore(String email, String password) throws SQLException;

    /**
     * questo metodo restituisce il numero di autori presenti nel database
     * @return N° di autori presenti nel database
     * @throws SQLException
     */

    int countAll() throws SQLException;

    /**
     * questo metodo restituisce un autore tramite l'email
     * @param email
     * @return Autore
     * @throws SQLException
     */

    Autore doRetrieveAutoreByEmail(String email) throws SQLException;

    /**
     * questo metodo restituisce un autore tramite il nickname
     * @param auNickname
     * @return autore
     * @throws SQLException
     */

    Autore doRetrieveAutoreByNickname(String auNickname) throws SQLException;

    /**
     * questo metodo aggiorna le recensioni prese in carico dall'autore
     * @param auNickname
     * @param titolo
     * @return boolean
     * @throws SQLException
     */

    Boolean updateAutoreRecCommissionate(String auNickname, String titolo)throws SQLException;

    /**
     * questo metodo aggiorna le recensioni prese in carico dall'autore
     * @param auNickname
     * @return boolean
     * @throws SQLException
     */

    Boolean updateAutoreRecCommissionateBis(String auNickname)throws SQLException;
}
