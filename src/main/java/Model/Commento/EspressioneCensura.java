package Model.Commento;

public class EspressioneCensura implements EspressioneInterface{

    private EspressioneInterface espr1 = null;

    public EspressioneCensura(EspressioneInterface expr1) {
        this.espr1 = expr1;
    }

    @Override
    public String interpreta(String context) {
        return espr1.interpreta(context);
    }

}
