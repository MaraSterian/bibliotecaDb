import java.util.ArrayList;
import java.util.List;
public class Autori {

    protected String cod;
    protected String nume;
    protected String nationalitate;
    protected List<Carti> carti = new ArrayList<>();

    public Autori(String nume, String nationalitate) {
        //this.cod = cod;
        this.nume = nume;
        this.nationalitate = nationalitate;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNationalitate() {
        return nationalitate;
    }

    public void setNationalitate(String nationalitate) {
        this.nationalitate = nationalitate;
    }

    public List<Carti> getCarti() {
        return carti;
    }

    //@Override
    //public void tiparire_carte() {}

    //public void tiparire_autori() {
        //System.out.println();
        //setNume(nume);
        //System.out.println("Autorul: " + getNume());
        //setNationalitate(nationalitate);
        //System.out.println("nationalitate: " + getNationalitate());
        //toString();
    //}

    @Override
    public String toString() {
        return "Autorul " +
                nume +
                " de nationalitate " + nationalitate +
                " cu codul de identificare " + cod;
    }

}
