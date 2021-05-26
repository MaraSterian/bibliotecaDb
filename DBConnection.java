
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {

        private static Connection connection;
        private static String URL = "jdbc:mysql://localhost:3306/biblioteca";
        private static String PASSWORD = "123456";
        private static String USER = "root";

        private DBConnection(){
        }

        public static Connection getDataBaseConnection(){

            try{
                if(connection == null || connection.isClosed()){
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    System.out.println("Successfully connected to DB");
                }
            } catch(SQLException exception){
                throw new SQLNewException("Cannot connect to DB", exception);
            }
            return connection;
        }

        public static void closeDataBaseConnection(){
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
            catch(SQLException exception){
                throw new SQLNewException("Cannot close connection to DB", exception);
            }
        }

    }

