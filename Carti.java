public class Carti {

    protected String cod_ISBN;
    protected String nume;
    protected String editura;
    protected String pret;
    protected String autor;

    public Carti(String nume, String editura, String pret, String autor) {
        //this.cod_ISBN = cod_ISBN;
        this.nume = nume;
        this.editura = editura;
        this.pret = pret;
        this.autor = autor;
        //autor.carti.add(this);
    }

    //public void tiparire_carte() {
        //System.out.println();
        //setNume(nume);
        //System.out.println("Cartea: " + getNume());
        //setCodISBN(cod_ISBN);
        //System.out.println("cod ISBN: " + getCodISBN());
        //setEditura(editura);
        //System.out.println("editura: " + getEditura());
        //setPret(pret);
        //System.out.println("pret: " + getPret() + " RON");
        //setAutor(autor);
        //getAutor();
        //toString();
    //}

    //@Override
    //public void tiparire_autori() {}

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCodISBN() {
        return cod_ISBN;
    }

    public void setCodISBN(String cod_ISBN) {
        this.cod_ISBN = cod_ISBN;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Cartea " + nume +
                " scrisa de " + autor +
                ", cu codul ISBN " + cod_ISBN +
                ", publicata de editura " + editura +
                ", la pretul de " + pret + "\n";
    }

}
