package Model.Connessione;

import java.util.List;

public class Alert {

    private final List<String> messages;
    private final String type;

    public Alert(List<String> messages,String type) {
        this.messages = messages;
        this.type = type;
    }


    public List<String> getMessage(){
        return  messages;
    }

    public String getType(){
        return type;
    }

}