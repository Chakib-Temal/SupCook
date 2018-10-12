package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DeleteCook {

    public void deleteCookById( HttpServletRequest request ) {
        try {
            ConnexionToBase mysql = new ConnexionToBase();
            Connection conn = mysql.connexionToMyBase();

            // the mysql insert statement
            String query = String.format( "DELETE FROM Cooks WHERE id='%s'", request.getParameterValues( "id" ) );

            PreparedStatement preparedStmt = conn.prepareStatement( query );

            // execute the preparedstatement
            preparedStmt.executeUpdate();
            mysql.deconnexionMysql( conn );

        } catch ( Exception e ) {
            System.err.println( "Got an exception!" );
            System.err.println( e.getMessage() );
        }
    }
}
