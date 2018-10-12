package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import forms.User;

public class RegisterInDB implements Runnable {
    private User user;

    public RegisterInDB( User user ) {
        this.user = user;

    }

    @Override
    public void run() {
        try {
            // create a mysql database connection
            ConnexionToBase mysql = new ConnexionToBase();
            Connection conn = mysql.connexionToMyBase();

            // the mysql insert statement
            String query = " insert into Users (userName, firstName, lastName,email, postalCode, password, dateOfInscription )"
                    + " values (?,?,?,?,?,?,?)";
            java.sql.Timestamp date = new java.sql.Timestamp( new java.util.Date().getTime() );

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement( query );
            preparedStmt.setString( 1, user.getUserName() );
            preparedStmt.setString( 2, user.getFirstName() );
            preparedStmt.setString( 3, user.getLastName() );
            preparedStmt.setString( 4, user.getEmail() );
            preparedStmt.setString( 5, user.getPostalCode() );
            preparedStmt.setString( 6, user.getPassword() );
            preparedStmt.setTimestamp( 7, date );

            // execute the preparedstatement
            preparedStmt.executeUpdate();
            mysql.deconnexionMysql( conn );

        } catch ( Exception e ) {
            System.err.println( "Got an exception!" );
            System.err.println( e.getMessage() );
        }
    }

}
