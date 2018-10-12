package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.ConnexionToBase;
import mysql.CountUsersAndCooks;
import mysql.GetCookForHome;

/**
 * Servlet implementation class Home
 */
@WebServlet( "/Home" )
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // CountUsersAndCooks countUsersForHome = new CountUsersAndCooks();
        // countUsersForHome.getNumberOfUsers();
        // System.out.println( request.getParameter( "id" ) );

        ConnexionToBase mysql = new ConnexionToBase();
        try {
            Connection conn = mysql.connexionToMyBase();
            CountUsersAndCooks countUsersAndCooks = new CountUsersAndCooks();
            countUsersAndCooks.getNumberOfUsers( conn, request );
            countUsersAndCooks.getNumberOfCooks( conn, request );
            mysql.deconnexionMysql( conn );
            GetCookForHome lastsCook = new GetCookForHome();
            lastsCook.getLast5Cook( request );
        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }

        request.getRequestDispatcher( "/WEB-INF/Home.jsp" ).forward( request, response );
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
