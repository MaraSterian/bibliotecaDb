import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectiuniDB {
    public void insertSectiune(Sectiuni sectiune) {
        String sql = "INSERT INTO sectiune (nume) VALUES (?)";
        Connection connection = DBConnection.getDataBaseConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sectiune.getNume());


            statement.executeUpdate();
            System.out.println("Sectiune adaugata cu succes");
        } catch (SQLException exception) {
            System.err.println("Nu se poate adauga in tabel");
        }
    }

    public Sectiuni getSectiuneByCod (String cod) {
        String sql = "SELECT * FROM sectiuni";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cod);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Sectiuni sectiune = new Sectiuni(resultSet.getString(2));
                sectiune.setCod(resultSet.getString(1));
                return sectiune;
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut gasi sectiunea");
        }
        return null;
    }

    public List<Sectiuni> getAllSectiuni() {
        String sql = "SELECT * FROM sectiuni";
        Connection connection = DBConnection.getDataBaseConnection();
        List<Sectiuni> allSectiuni = new ArrayList<Sectiuni>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Sectiuni currentSectiune = new Sectiuni(resultSet.getString(2));
                currentSectiune.setCod(resultSet.getString(1));
                allSectiuni.add(currentSectiune);
            }
        } catch (SQLException exception) {
            System.err.println("Nu s-au putut gasi sectiunile");
        }
        return allSectiuni;
    }

    public void updateSectiuneNumeByCod(String numeNou, String cod) {
        String sql = "UPDATE sectiuni SET nume=? WHERE cod=?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, numeNou);
            preparedStatement.setString(2, cod);

            preparedStatement.executeUpdate();

            System.out.println("Succes la update-ul numelui sectiunii cu codul " + cod);
        } catch (SQLException exception) {
            System.err.println("Eroare la update-ul numelui sectiunii cu codul " + cod);
        }
    }

    public Sectiuni deleteSectiune (String cod) {
        String sql = "DELETE FROM carti WHERE cod = ?";
        Connection connection = DBConnection.getDataBaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cod);

            preparedStatement.executeUpdate();

            System.out.println("Sectiune stearsa din tabel");
        } catch (SQLException exception) {
            System.err.println("Nu s-a putut sterge sectiunea din tabel");
        }
        return null;
    }
}
