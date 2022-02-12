package Model.Autore;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoreFactory {

    public static final AutoreDAO AUTORE_DAO=new AutoreDAO();

    public static List<Autore> AUTORE_LIST=new ArrayList<>();

    static {
        try {
            AUTORE_LIST = AUTORE_DAO.doRetrieveAutoreAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static AutoreAbstract getEmail(String email){
        for(int i=0; i<AUTORE_LIST.size(); i++){
            if(AUTORE_LIST.get(i).getEmail().equals(email)){
                return new Autore();
            }
        }
        return new AutoreNull();
    }
}
