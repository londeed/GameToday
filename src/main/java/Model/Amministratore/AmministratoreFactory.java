package Model.Amministratore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static AmministratoreAbstract getAmNickname(String AmNickname){
        for(int i=0; i<AMMINISTRATORE_LIST.size(); i++){
            if(AMMINISTRATORE_LIST.get(i).getAmNickname().equalsIgnoreCase(AmNickname)){
                return new Amministratore(AmNickname);
            }
        }
        return new AmministratoreNull();
    }
}