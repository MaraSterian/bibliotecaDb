import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CititoriDB {
    public void insertCititor(Cititori cititor) {
        String sql = "INSERT INTO cititori (nume) VALUES (?)";
        Connection connection = DBConnection.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cititor.getNume());


            statement.executeUpdate();
            System.out.println("Cititor adaugat cu succes");
        } catch (SQLException exception) {
            System.err.println("Nu se poate adauga in tabel");
        }
    }


    public Cititori getCititorById_permis (String id_permis) {
        String sql = "SELECT * FROM cititori";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_permis);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Cititori cititor = new Cititori(resultSet.getString(2));
                cititor.setId_permis(resultSet.getString(1));
                return cititor;
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut gasi cititorul");
        }
        return null;
    }

    public List<Cititori> getAllCititori() {
        String sql = "SELECT * FROM cititori";
        Connection connection = DBConnection.getDataBaseConnection();
        List<Cititori> allCititori = new ArrayList<Cititori>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Cititori currentCititori = new Cititori(resultSet.getString(2));
                currentCititori.setId_permis(resultSet.getString(1));
                allCititori.add(currentCititori);
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-au putut gasi cititorii");
        }
        return allCititori;
    }

    public void updateCititorNumeById_permis(String numeNou, String id_permis) {
        String sql = "UPDATE cititori SET nume=? WHERE id_permis=?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, numeNou);
            preparedStatement.setString(2, id_permis);

            preparedStatement.executeUpdate();

            System.out.println("Succes la update-ul numelui cititorului cu id-ul de permis " + id_permis);
        } catch (SQLException exception) {
            System.err.println("Eroare la update-ul numelui cititorului cu id-ul de permis " + id_permis);
        }
    }

    public Cititori deleteCititor (String id_permis) {
        String sql = "DELETE FROM carti WHERE id_permis = ?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id_permis);

            preparedStatement.executeUpdate();

            System.out.println("Cititor stears din tabel");
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut sterge cititorul din tabel");
        }
        return null;
    }
}
