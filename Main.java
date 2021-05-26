public class Main {
    public static void main(String[] args) {

        ConfigTabel.setUpDb();

        CartiDB cartiDB = new CartiDB();
        //cartiDB.insertCarte(new Carti("Enigma Otiliei", "Corint", "50", "George Calinescu"));
        //System.out.println(cartiDB.getCarteByCod("2"));
        //System.out.println(cartiDB.getAllCarti());
        //cartiDB.updateCarteEdituraByCod("Arthur", "2");
        //cartiDB.deleteCarte("2");

        AutoriDB autoriDB = new AutoriDB();
        //autoriDB.insertAutor(new Autori("Marin Preda", "roman"));
        //System.out.println(autoriDB.getAutorByCod("1"));
        //System.out.println(autoriDB.getAllAutori());
        //autoriDB.updateAutorNationalitateByCod("romanas", "1");
        //autoriDB.deleteAutor("1");

        SectiuniDB sectiuniDB = new SectiuniDB();
        //sectiuniDB.insertSectiune(new Sectiuni("Literatura"));
        //System.out.println(sectiuniDB.getSectiuneByCod("1"));
        //System.out.println(sectiuniDB.getAllSectiuni());
        //sectiuniDB.updateSectiuneNumeByCod("Educatie", "1");
        //sectiuniDB.deleteSectiune("1");

        CititoriDB cititoriDB = new CititoriDB();
        //cititoriDB.insertCititor(new Cititori("Alex Costel"));
        //System.out.println(cititoriDB.getCititorById_permis("1"));
        //System.out.println(cititoriDB.getAllCititori());
        //cititoriDB.updateCititorNumeById_permis("Alex Costelus", "1");
        //cititoriDB.deleteCititor("1");

        IntrareBiblioteca i1 = new IntrareBiblioteca();


        i1.Service();

        //i1.deleteCarte("1");
        //i1.deleteAutor("1");
        //i1.deleteSectiune("1");
        //i1.deleteCititor("1");

        //i1.getAllCarti();
        //i1.getAllAutori();
        //i1.getAllSectiuni();
        //i1.getAllCititori();

        //i1.getCarteByCod("1");
        //i1.getAutorByCod("1");
        //i1.getSectiuneByCod("1");
        //i1.getCititorById_permis("1");

        //i1.insertCarte();
        //i1.insertAutor();
        //i1.insertSectiune();
        //i1.insertCititor();

        //System.out.println(cartiDB.getAllCarti());

        DBConnection.closeDataBaseConnection();



    }
}
