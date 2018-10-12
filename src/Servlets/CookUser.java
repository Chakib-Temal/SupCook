package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.GetArticlsUser;
import session.PrepareSessionUser;

/**
 * Servlet implementation class CookUser
 */
@WebServlet( "/CookUser" )
public class CookUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookUser() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        PrepareSessionUser sessionUser = new PrepareSessionUser();
        if ( sessionUser.isAvailable( request ) ) {
            GetArticlsUser articles = new GetArticlsUser();
            try {
                articles.getCook( request );
            } catch ( ClassNotFoundException | SQLException e ) {
                e.printStackTrace();
            }
            request.getRequestDispatcher( "/WEB-INF/CookUser.jsp" ).forward( request, response );
        } else {
            response.sendRedirect( "/SupCook/Login" );
        }
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
