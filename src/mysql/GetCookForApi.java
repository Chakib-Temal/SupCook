package mysql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetCookForApi {

    public void getCookWithNameOrDescription( HttpServletRequest request, HttpServletResponse response )
            throws IOException, ClassNotFoundException, SQLException, JSONException {

        ConnexionToBase mysql = new ConnexionToBase();
        Connection conn = mysql.connexionToMyBase();

        String query = String.format(
                "SELECT * from Cooks where (name LIKE '%s%%' or description like '%s%%')",
                request.getParameter( "name" ), request.getParameter( "description" ) );

        PreparedStatement preparedStmt = conn.prepareStatement( query );

        ResultSet rs = preparedStmt.executeQuery();
        JSONArray json = new JSONArray();
        ResultSetMetaData rsmd = rs.getMetaData();

        while ( rs.next() ) {
            int numColumns = rsmd.getColumnCount();
            JSONObject obj = new JSONObject();
            for ( int i = 1; i <= numColumns; i++ ) {
                String column_name = rsmd.getColumnName( i );
                obj.put( column_name, rs.getObject( column_name ) );
            }
            json.put( obj );
        }

        mysql.deconnexionMysql( conn );

        response.setContentType( "application/json" );
        PrintWriter out = response.getWriter();
        out.print( json );
        out.flush();
    }
}
