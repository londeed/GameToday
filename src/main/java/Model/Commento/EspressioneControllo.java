package Model.Commento;

public class EspressioneControllo {

    public String getCommento(String commento){
        String newText;
        EspressioneInterface isNoWord=getTestoCommento(commento);
        newText=isNoWord.interpreta("merda");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("cazzo");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("fessa");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("pene");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("vagina");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("zoccola");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("puttana");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("cretino");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("mongoloide");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("scemo");
        isNoWord=getTestoCommento(newText);
        newText=isNoWord.interpreta("coglione");
        return newText;
    }

    public static EspressioneInterface getTestoCommento(String text){
        EspressioneInterface word = new EspressioneTerminale(text);
        return new EspressioneCensura(word);
    }

}
