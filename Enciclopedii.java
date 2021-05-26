public class Enciclopedii extends Carti {
    private String tip;

    public Enciclopedii(String nume, String editura, String pret, String autor, String tip) {
        super(nume, editura, pret, autor);
        this.tip = tip;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
