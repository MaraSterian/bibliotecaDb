import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoriDB {
    public void insertAutor(Autori autor) {
        String sql = "INSERT INTO autori (nume, nationalitate) VALUES (?,?)";
        Connection connection = DBConnection.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, autor.getNume());
            statement.setString(2, autor.getNationalitate());

            statement.executeUpdate();
            System.out.println("Autor adaugat cu succes");
        } catch (SQLException exception) {
            System.err.println("Nu se poate adauga in tabel");
        }
    }


    public Autori getAutorByCod (String cod) {
        String sql = "SELECT * FROM autori";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cod);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Autori autor = new Autori(resultSet.getString(2), resultSet.getString(3));
                autor.setCod(resultSet.getString(1));
                return autor;
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut gasi autorul");
        }
        return null;
    }

    public List<Autori> getAllAutori() {
        String sql = "SELECT * FROM autori";
        Connection connection = DBConnection.getDataBaseConnection();
        List<Autori> allAutori = new ArrayList<Autori>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Autori currentAutor = new Autori(resultSet.getString(2), resultSet.getString(3));
                currentAutor.setCod(resultSet.getString(1));
                allAutori.add(currentAutor);
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-au putut gasi autorii");
        }
        return allAutori;
    }

    public void updateAutorNationalitateByCod(String nationalitateNoua, String cod) {
        String sql = "UPDATE autori SET nationalitate=? WHERE cod=?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nationalitateNoua);
            preparedStatement.setString(2, cod);

            preparedStatement.executeUpdate();

            System.out.println("Succes la update-ul nationalitatii autorului cu codul " + cod);
        } catch (SQLException exception) {
            System.err.println("Eroare la update-ul nationalitatii autorului cu codul " + cod);
        }
    }

    public Autori deleteAutor (String cod) {
        String sql = "DELETE FROM autori WHERE cod = ?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cod);

            preparedStatement.executeUpdate();

            System.out.println("Autor stears din tabel");
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut sterge autorul din tabel");
        }
        return null;
    }
}
