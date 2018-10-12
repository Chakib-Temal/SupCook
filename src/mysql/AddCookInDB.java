package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import forms.Cook;
import forms.User;

public class AddCookInDB implements Runnable {
    private Cook cook;
    private User user;

    public AddCookInDB( Cook cook, User user ) {
        this.cook = cook;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            // create a mysql database connection
            ConnexionToBase mysql = new ConnexionToBase();
            Connection conn = mysql.connexionToMyBase();

            // the mysql insert statement
            String query = " insert into Cooks (name, category, description, namePhoto, timeOfPreparation, timeOfCooking, difficulteLevel, dateOfPublication, userPublisher )"
                    + " values (?,?,?,?,?,?,?,?,?)";
            java.sql.Timestamp date = new java.sql.Timestamp( new java.util.Date().getTime() );

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement( query );
            preparedStmt.setString( 1, cook.getName() );
            preparedStmt.setString( 2, cook.getCategory() );
            preparedStmt.setString( 3, cook.getDescription() );
            preparedStmt.setString( 4, cook.getNamePhoto() );
            preparedStmt.setString( 5, cook.getTimeP() );
            preparedStmt.setString( 6, cook.getTimeF() );
            preparedStmt.setString( 7, cook.getLevel() );
            preparedStmt.setTimestamp( 8, date );
            preparedStmt.setString( 9, user.getUserName() );

            // execute the preparedstatement
            preparedStmt.executeUpdate();
            mysql.deconnexionMysql( conn );

        } catch ( Exception e ) {
            System.err.println( "Got an exception!" );
            System.err.println( e.getMessage() );
        }

    }

}
