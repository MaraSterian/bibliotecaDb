import java.util.*;

public class Sectiuni {
    protected String cod;
    protected String nume;

    public Sectiuni(String nume) {
        //this.cod = cod;
        //Scanner in = new Scanner(System.in);
        //System.out.println("Introduceti numele sectiunii: ");
        //this.nume = in.nextLine();
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    List<Carti> listaCarti = new ArrayList<>();

    @Override
    public String toString() {
        return "Sectiunea de " +
                " nume: " + nume +
                " cu codul " + cod;
    }
    //public void schimbaSectiune(String nume) {
        //setNume(nume);
    //}


}
