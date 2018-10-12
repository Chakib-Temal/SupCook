package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import forms.User;

public class UpdateProfilUser implements Runnable {
    private User newUser;
    private User oldUser;

    public UpdateProfilUser( User newUser, User oldUser ) {
        this.newUser = newUser;
        this.oldUser = oldUser;
    }

    @Override
    public void run() {
        try {
            // create a mysql database connection
            ConnexionToBase mysql = new ConnexionToBase();
            Connection conn = mysql.connexionToMyBase();

            // the mysql insert statement
            String query = String.format(
                    "UPDATE Users SET username='%s', firstname='%s',lastname='%s',email='%s',postalCode='%s',password='%s' WHERE username='%s' ",
                    newUser.getUserName(),
                    newUser.getFirstName(),
                    newUser.getLastName(),
                    newUser.getEmail(),
                    newUser.getPostalCode(),
                    newUser.getPassword(),
                    oldUser.getUserName() );

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
