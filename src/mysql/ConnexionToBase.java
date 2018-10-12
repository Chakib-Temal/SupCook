package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionToBase {

    String url = "jdbc:mysql://localhost:3306/SupCook";

    public Connection connexionToMyBase() throws ClassNotFoundException, SQLException {
        Class.forName( "com.mysql.jdbc.Driver" );
        Connection connexion = DriverManager.getConnection( url, "root", "alger" );
        return connexion;
    }

    public void deconnexionMysql( Connection conn ) throws SQLException {
        conn.close();
    }
}
