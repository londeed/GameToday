package Model.Commento;

/**
 * classe per l'implementazione del design pattern Template Method
 */

public class EspressioneCensura implements EspressioneInterface{

    private EspressioneInterface espr1 = null;

    public EspressioneCensura(EspressioneInterface expr1) {
        this.espr1 = expr1;
    }

    /**
     * chiama il metodo "interpreta" per confrontare se la stringa contiene parole volgari
     * @param context
     * @return
     */

    @Override
    public String interpreta(String context) {
        return espr1.interpreta(context);
    }

}
