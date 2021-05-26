import java.util.List;

public class Biblioteca {
    private String nume;
    private List<Sectiuni> sectiuni;
    private List<Carti> carti;

    public Biblioteca(String nume, List<Sectiuni> sectiuni, List<Carti> carti) {
        this.nume = nume;
        this.sectiuni = sectiuni;
        this.carti = carti;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Sectiuni> getSectiuni() {
        return sectiuni;
    }

    public void setSectiuni(List<Sectiuni> sectiuni) {
        this.sectiuni = sectiuni;
    }

    public List<Carti> getCarti() {
        return carti;
    }

    public void setCarti(List<Carti> carti) {
        this.carti = carti;
    }
}
