package Infrastructure;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static final String URL="jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    public  static final String USER = "RM559810";
    public static final String PASSWORD = "061202";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
