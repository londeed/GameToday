package Model.Commento;

/**
 * classe che implementa EspressioneInterface
 * utilizzata per l'implementazione del design pattern Template Method
 */

public class EspressioneTerminale implements EspressioneInterface {
    private String testo;

    /**
     * metodo utilizzato per settare la stringa
     * @param testo
     */

    public EspressioneTerminale(String testo) {
        this.testo = testo;
    }

    /**
     * metodo utlizzato per confrontare la stringa
     * @param contesto
     * @return stringa || stringa modificata
     */

    @Override
    public String interpreta(String contesto) {

        if(testo.contains(contesto)) {
            testo=testo.replace(contesto, "*****");
            return testo;
        }
        return testo;
    }

}
