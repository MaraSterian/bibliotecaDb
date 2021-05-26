import java.util.List;
import java.util.Scanner;

public class IntrareBiblioteca {

    public void Service() {
        System.out.println("Bine ati venit la biblioteca\n" +
                "Pentru a adauga o carte introduceti 1 de la tastatura\n" +
                "Pentru a adauga un autor introduceti 2\n" +
                "Pentru a adauga o sectiune introduceti 3\n" +
                "Pentru a adauga un cititor introduceti 4");

        Scanner x = new Scanner(System.in);
        String test = x.nextLine();

        switch (test) {
            case "1":
                insertCarte();
                break;
            case "2":
                insertAutor();
                break;
            case "3":
                insertSectiune();
                break;
            case "4":
                insertCititor();
                break;
            default:
                System.out.println("Numar incorect");
        }

    }


    CartiDB cartiDB = new CartiDB();

    public Carti getCarteByCod(String cod_ISBN) {
        Carti carte = cartiDB.getCarteByCod(cod_ISBN);

        System.out.println(carte);
        return carte;
    }

    public List<Carti> getAllCarti() {
        List<Carti> allCarti = cartiDB.getAllCarti();
        System.out.println(allCarti);
        return allCarti;
    }

    public Carti deleteCarte(String cod_ISBN) {
        Carti carte = cartiDB.deleteCarte(cod_ISBN);
        System.out.println("Cartea " + carte.nume + "cu codul ISBN" + cod_ISBN + " a fost stearsa cu succes");
        return null;
    }

    public Carti insertCarte() {
        Scanner carte = new Scanner(System.in);

        System.out.println("Introduceti numele cartii: ");
        String nume = carte.nextLine();
        System.out.println("Introduceti editura cartii: ");
        String editura = carte.nextLine();
        System.out.println("Introduceti pretul cartii: ");
        String pret = carte.nextLine();
        System.out.println("Introduceti autorul carti: ");
        String autor = carte.nextLine();

        Carti carte1 = new Carti(nume, editura, pret, autor);
        System.out.println(carte1);


        cartiDB.insertCarte(new Carti(nume, editura, pret, autor));

        return null;
    }


    AutoriDB autoriDB = new AutoriDB();

    public Autori getAutorByCod(String cod) {
        Autori autor = autoriDB.getAutorByCod(cod);

        System.out.println(autor);
        return autor;
    }

    public List<Autori> getAllAutori() {
        List<Autori> allAutori = autoriDB.getAllAutori();
        System.out.println(allAutori);
        return allAutori;
    }

    public Autori deleteAutor(String cod) {
        Autori autor = autoriDB.deleteAutor(cod);
        System.out.println("Autorul " + autor.nume + "cu codul " + cod + " a fost sters cu succes");
        return null;
    }

    public Autori insertAutor() {
        Scanner autor = new Scanner(System.in);

        System.out.println("Introduceti numele autorului: ");
        String nume = autor.nextLine();
        System.out.println("Introduceti nationalitatea autorului: ");
        String nationalitate = autor.nextLine();

        Autori autor1 = new Autori(nume, nationalitate);

        System.out.println(autor1);

        autoriDB.insertAutor(new Autori(nume, nationalitate));

        return null;
    }

    SectiuniDB sectiuniDB = new SectiuniDB();

    public Sectiuni getSectiuneByCod(String cod) {
        Sectiuni sectiune = sectiuniDB.getSectiuneByCod(cod);

        System.out.println(sectiune);
        return sectiune;
    }

    public List<Sectiuni> getAllSectiuni() {
        List<Sectiuni> allSectiuni = sectiuniDB.getAllSectiuni();
        System.out.println(allSectiuni);
        return allSectiuni;
    }

    public Sectiuni deleteSectiune(String cod) {
        Sectiuni sectiune = sectiuniDB.deleteSectiune(cod);
        System.out.println("Sectiunea " + sectiune.nume + "cu codul " + cod + " a fost stearsa cu succes");
        return null;
    }

    public Sectiuni insertSectiune() {
        Scanner sectiune = new Scanner(System.in);

        System.out.println("Introduceti numele sectiunii: ");
        String nume = sectiune.nextLine();

        Sectiuni sectiune1 = new Sectiuni(nume);

        System.out.println(sectiune1);

        sectiuniDB.insertSectiune(new Sectiuni(nume));

        return null;
    }

    CititoriDB cititoriDB = new CititoriDB();

    public Cititori getCititorById_permis(String id_permis) {
        Cititori cititor = cititoriDB.getCititorById_permis(id_permis);

        System.out.println(cititor);
        return cititor;
    }

    public List<Cititori> getAllCititori() {
        List<Cititori> allCititori = cititoriDB.getAllCititori();
        System.out.println(allCititori);
        return allCititori;
    }

    public Cititori deleteCititor(String id_permis) {
        Cititori cititor = cititoriDB.deleteCititor(id_permis);
        System.out.println("Cititorul " + cititor.nume + "cu id-ul de permis " + id_permis + " a fost sters cu succes");
        return null;
    }

    public Cititori insertCititor() {
        Scanner cititor = new Scanner(System.in);

        System.out.println("Introduceti numele cititorului: ");
        String nume = cititor.nextLine();

        Cititori cititor1 = new Cititori(nume);

        System.out.println(cititor1);

        cititoriDB.insertCititor(new Cititori(nume));

        return null;
    }
}
