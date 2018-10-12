package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import forms.Cook;

public class GetCookForHome {

    public void getLast5Cook( HttpServletRequest request ) throws ClassNotFoundException, SQLException {

        List<Cook> listCook = new ArrayList<Cook>();

        ConnexionToBase mysql = new ConnexionToBase();
        Connection conn = mysql.connexionToMyBase();

        String query = "select id, name, category, dateOfPublication from Cooks order by id desc limit 5";

        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        while ( rs.next() ) {
            Cook cook = new Cook();
            cook.setId( rs.getInt( "id" ) );
            cook.setName( rs.getString( "name" ) );
            cook.setCategory( rs.getString( "category" ) );
            cook.setDatePublication( rs.getString( "dateOfPublication" ) );
            listCook.add( cook );
        }
        mysql.deconnexionMysql( conn );
        request.setAttribute( "listCook", listCook );

    }
}
