package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import forms.Cook;

public class ViewCookById {

    public void getCookById( HttpServletRequest request ) throws ClassNotFoundException, SQLException {
        Cook cook = new Cook();
        ConnexionToBase mysql = new ConnexionToBase();
        Connection conn = mysql.connexionToMyBase();

        String query = String.format( "select * from Cooks where id='%s'", request.getParameterValues( "id" ) );

        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        while ( rs.next() ) {
            cook.setName( rs.getString( "name" ) );
            cook.setCategory( rs.getString( "category" ) );
            cook.setDescription( rs.getString( "description" ) );
            cook.setTimeP( rs.getString( "timeOfPreparation" ) );
            cook.setTimeF( rs.getString( "timeOfCooking" ) );
            cook.setLevel( rs.getString( "difficulteLevel" ) );
            cook.setNamePublisher( rs.getString( "userPublisher" ) );
            cook.setDatePublication( rs.getString( "dateOfPublication" ) );
            cook.setNamePhoto( rs.getString( "namePhoto" ) );

        }

        mysql.deconnexionMysql( conn );
        request.setAttribute( "cook", cook );

    }

}
