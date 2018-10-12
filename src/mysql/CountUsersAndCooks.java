package mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import forms.User;

public class CountUsersAndCooks {

    int numberRows = 0;

    public void getNumberOfUsers( java.sql.Connection conn, HttpServletRequest request ) throws SQLException {
        String query = "select count(*) from Users";
        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        while ( rs.next() ) {
            numberRows = rs.getInt( 1 );
        }
        request.setAttribute( "numberOfUsers", numberRows );
    }

    public void getNumberOfCooks( java.sql.Connection conn, HttpServletRequest request ) throws SQLException {
        String query = "select count(*) from Cooks";
        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        while ( rs.next() ) {
            numberRows = rs.getInt( 1 );
        }
        request.setAttribute( "numberOfCooks", numberRows );
    }

    public boolean checkIntheBaseWithUsername( java.sql.Connection conn, User user ) throws SQLException {
        String query = String.format( "select count(*) from Users Where username = '%s'", user.getUserName() );

        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        while ( rs.next() ) {
            numberRows = rs.getInt( 1 );
        }

        if ( numberRows == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkIntheBaseWithUsernameAndPassword( java.sql.Connection conn, User user ) throws SQLException {
        String query = String.format( "select count(*) from Users Where username = '%s' AND password='%s'",
                user.getUserName(), user.getPassword() );

        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        while ( rs.next() ) {
            numberRows = rs.getInt( 1 );
        }

        if ( numberRows == 0 ) {
            return true;
        } else {
            return false;
        }
    }
}
