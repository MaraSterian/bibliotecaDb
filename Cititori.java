public class Cititori implements Comparable {
    protected String id_permis;
    protected String nume;


    public Cititori(String nume) {
        //this.id_permis = id_permis;
        this.nume = nume;

    }

    public Cititori() {}

    public String getId_permis() {
        return id_permis;
    }

    public void setId_permis(String id_permis) {
        this.id_permis = id_permis;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }



    @Override
    public String toString() {
        return "Cititor " +
                " cu id_permis: " + id_permis +
                "nume: " + nume;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
