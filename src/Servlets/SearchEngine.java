package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SearchEngine.SearchInBase;

/**
 * Servlet implementation class SearchEngine
 */
@WebServlet( "/SearchEngine" )
public class SearchEngine extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEngine() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        SearchInBase search = new SearchInBase();
        try {
            search.searchEngine( request );
        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
        request.getRequestDispatcher( "/WEB-INF/SearchEngine.jsp" ).forward( request, response );
        // SELECT name, category FROM Cooks WHERE name LIKE 'k%';
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet( request, response );
    }

}
