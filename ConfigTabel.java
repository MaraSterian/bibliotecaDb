import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfigTabel {
    public static void setUpDb() {
        String createTableSqlCarti = "CREATE TABLE IF NOT EXISTS carti (cod_ISBN int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(30), editura varchar(15), pret varchar(10), autor varchar(30))";
        Connection dataBaseConnectionCarti = DBConnection.getDataBaseConnection();
        try {
            Statement statement = dataBaseConnectionCarti.createStatement(); // Statement
            statement.execute(createTableSqlCarti);
            System.out.println("Successfully created table");
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }

        String createTableSqlAutori = "CREATE TABLE IF NOT EXISTS autori (cod int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(30), nationalitate varchar(30))";
        Connection dataBaseConnectionAutori = DBConnection.getDataBaseConnection();
        try {
            Statement statement = dataBaseConnectionAutori.createStatement(); // Statement
            statement.execute(createTableSqlAutori);
            System.out.println("Successfully created table");
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }

        String createTableSqlSectiuni = "CREATE TABLE IF NOT EXISTS sectiuni (cod int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(30))";
        Connection dataBaseConnectionSectiuni = DBConnection.getDataBaseConnection();
        try {
            Statement statement = dataBaseConnectionSectiuni.createStatement(); // Statement
            statement.execute(createTableSqlSectiuni);
            System.out.println("Successfully created table");
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }

        String createTableSqlCititori = "CREATE TABLE IF NOT EXISTS carti (id_permis int PRIMARY KEY AUTO_INCREMENT, " +
                "nume varchar(30))";
        Connection dataBaseConnectionCititori = DBConnection.getDataBaseConnection();
        try {
            Statement statement = dataBaseConnectionCititori.createStatement(); // Statement
            statement.execute(createTableSqlCititori);
            System.out.println("Successfully created table");
        } catch (SQLException exception) {
            System.err.println("Could not create table");
        }
    }

    private ConfigTabel() {
    }
}
