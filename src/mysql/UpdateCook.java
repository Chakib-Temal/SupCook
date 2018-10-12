package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import forms.Cook;

public class UpdateCook implements Runnable {

    private Cook   newCook;
    private String id;

    public UpdateCook( Cook newCook, String id ) {
        this.id = id;
        this.newCook = newCook;
    }

    @Override
    public void run() {
        try {
            // create a mysql database connection
            ConnexionToBase mysql = new ConnexionToBase();
            Connection conn = mysql.connexionToMyBase();

            // the mysql insert statement
            String query = String.format(
                    "UPDATE Cooks SET name='%s', category='%s',description='%s',timeOfPreparation='%s',timeOfCooking='%s',difficulteLevel='%s' WHERE id='%s' ",
                    newCook.getName(),
                    newCook.getCategory(),
                    newCook.getDescription(),
                    newCook.getTimeP(),
                    newCook.getTimeF(),
                    newCook.getLevel(),
                    this.id );

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
