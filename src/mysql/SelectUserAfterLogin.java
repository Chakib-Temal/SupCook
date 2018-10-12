package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import forms.User;

public class SelectUserAfterLogin {

    public User getUserinDB( User user ) {
        try {
            // create a mysql database connection
            ConnexionToBase mysql = new ConnexionToBase();
            Connection conn = mysql.connexionToMyBase();

            // the mysql insert statement
            String query = String.format(
                    "select firstname, lastname,email, postalcode from Users Where (username = '%s' and password = '%s' )",
                    user.getUserName(), user.getPassword() );

            PreparedStatement preparedStmt = conn.prepareStatement( query );

            ResultSet rs = preparedStmt.executeQuery();

            while ( rs.next() ) {
                user.setFirstName( rs.getString( "firstName" ) );
                user.setLastName( rs.getString( "lastName" ) );
                user.setEmail( rs.getString( "email" ) );
                user.setPostalCode( rs.getString( "postalCode" ) );
            }
            mysql.deconnexionMysql( conn );

        } catch ( Exception e ) {
            System.err.println( "Got an exception!" );
            System.err.println( e.getMessage() );
        }
        return user;
    }

}
