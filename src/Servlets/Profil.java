package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.User;
import mysql.ConnexionToBase;
import mysql.CountUsersAndCooks;
import mysql.UpdateProfilUser;
import session.PrepareSessionUser;
import validationParameters.ValidatorRegister;

/**
 * Servlet implementation class Profil
 */
@WebServlet( "/Profil" )
public class Profil extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
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
        PrepareSessionUser sessionUser = new PrepareSessionUser();
        if ( sessionUser.isAvailable( request ) ) {
            request.getRequestDispatcher( "/WEB-INF/Profil.jsp" ).forward( request, response );
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

        PrepareSessionUser sessionUser = new PrepareSessionUser();
        if ( !sessionUser.isAvailable( request ) ) {
            response.sendRedirect( "/SupCook/Login" );

        } else {
            ValidatorRegister validator = new ValidatorRegister();
            boolean paramaterValidated = validator.validateRegister( request );

            if ( paramaterValidated ) {

                User user = sessionUser.prepareUserForSession( request );
                ConnexionToBase mysql = new ConnexionToBase();
                boolean canUpdate = true;

                try {
                    Connection conn = mysql.connexionToMyBase();
                    CountUsersAndCooks check = new CountUsersAndCooks();
                    canUpdate = check.checkIntheBaseWithUsername( conn, user );
                    mysql.deconnexionMysql( conn );

                } catch ( ClassNotFoundException | SQLException e ) {
                    e.printStackTrace();
                }
                if ( canUpdate ) {

                    User oldUser = sessionUser.getSession( request );
                    sessionUser.setSession( request, user );
                    request.getRequestDispatcher( "/WEB-INF/Profil.jsp" ).forward( request, response );
                    Runnable r = new UpdateProfilUser( user, oldUser );
                    new Thread( r ).start();
                } else {
                    request.setAttribute( "usernameExiste", "username Already Exist" );
                    request.getRequestDispatcher( "/WEB-INF/Profil.jsp" ).forward( request, response );
                }
            } else {
                request.getRequestDispatcher( "/WEB-INF/Profil.jsp" ).forward( request, response );
            }

        }
    }

}
