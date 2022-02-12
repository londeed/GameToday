package Model.Commento;

public class EspressioneTerminale implements EspressioneInterface {
    private String testo;

    public EspressioneTerminale(String testo) {
        this.testo = testo;
    }

    @Override
    public String interpreta(String contesto) {

        if(testo.contains(contesto)) {
            testo=testo.replace(contesto, "*****");
            return testo;
        }
        return testo;
    }

}
