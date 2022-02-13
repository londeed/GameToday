package Model.Amministratore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe factory utilizzata per implementare il design pattern NullObject
 */

public class AmministratoreFactory {

    public static final AmministratoreDAO AMMINISTRATORE_DAO=new AmministratoreDAO();

    public static List<Amministratore> AMMINISTRATORE_LIST=new ArrayList<>();

    static {
        try {
            AMMINISTRATORE_LIST = AMMINISTRATORE_DAO.doRetrieveAllAmministratore();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * metodo utilizzato per verificare se l'amministratore che tenta di effettuare il login è presente nel database
     * @param email
     * @return amministratore
     */

    public static AmministratoreAbstract getEmail(String email){
        for(int i=0; i<AMMINISTRATORE_LIST.size(); i++){
            if(AMMINISTRATORE_LIST.get(i).getEmail().equals(email)){
                return new Amministratore();
            }
        }
        return new AmministratoreNull();
    }
}