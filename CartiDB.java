import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartiDB {
    public void insertCarte(Carti carte) {
        String sql = "INSERT INTO carti (nume, editura, pret, autor) VALUES (?,?,?,?)";
        Connection connection = DBConnection.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carte.getNume());
            statement.setString(2, carte.getEditura());
            statement.setString(3, carte.getPret());
            statement.setString(4, carte.getAutor());

            statement.executeUpdate();
            System.out.println("Carte adaugata cu succes");
        } catch (SQLException exception) {
            System.err.println("Nu se poate adauga in tabel");
        }
    }


    public Carti getCarteByCod (String cod_ISBN) {
        String sql = "SELECT * FROM carti WHERE cod_ISBN=?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cod_ISBN);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Carti carte = new Carti(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                carte.setCodISBN(resultSet.getString(1));
                return carte;
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut gasi cartea");
        }
        return null;
    }

    public List<Carti> getAllCarti() {
        String sql = "SELECT * FROM carti";
        Connection connection = DBConnection.getDataBaseConnection();
        List<Carti> allCarti = new ArrayList<Carti>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Carti currentCarte = new Carti(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                currentCarte.setCodISBN(resultSet.getString(1));
                allCarti.add(currentCarte);
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-au putut gasi cartile");
        }
        return allCarti;
    }

    public void updateCarteEdituraByCod(String edituraNoua, String cod_ISBN) {
        String sql = "UPDATE carti SET editura=? WHERE cod_ISBN=?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, edituraNoua);
            preparedStatement.setString(2, cod_ISBN);

            preparedStatement.executeUpdate();

            System.out.println("Succes la update-ul editurii cartii cu codul ISBN " + cod_ISBN);
        } catch (SQLException exception) {
            System.err.println("Eroare la update-ul editurii cartii cu codul ISBN " + cod_ISBN);
        }
    }

    public Carti deleteCarte (String cod_ISBN) {
        String sql = "DELETE FROM carti WHERE cod_ISBN = ?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cod_ISBN);

            preparedStatement.executeUpdate();

            System.out.println("Carte stearsa din tabel");
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut sterge cartea din tabel");
        }
        return null;
    }
}
