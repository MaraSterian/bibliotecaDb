public class Dictionare extends Carti {
    private String limba1 = "romana";
    private String limba2;

    public Dictionare(String nume, String editura, String pret, String autor, String limba_de_traducere) {
        super(nume, editura, pret, autor);
        this.limba2 = limba2;
    }

    public String getLimba1() {
        return limba1;
    }

    public String getLimba2() {
        return limba2;
    }

    public void setLimba2(String limba2) {
        this.limba2 = limba2;
    }


}
