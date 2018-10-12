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
import mysql.SelectUserAfterLogin;
import session.PrepareSessionUser;
import validationParameters.ValidatorLogin;

/**
 * Servlet implementation class Login
 */
@WebServlet( "/Login" )
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
            response.sendRedirect( "/SupCook/Profil" );
        } else {
            request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request, response );
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrepareSessionUser sessionUser = new PrepareSessionUser();
        if ( sessionUser.isAvailable( request ) ) {
            response.sendRedirect( "/SupCook/Profil" );
        } else {
            ValidatorLogin validator = new ValidatorLogin();
            boolean resultValidation = validator.validateLogin( request );

            if ( resultValidation ) {
                User user = sessionUser.prepareUserForSession( request );
                ConnexionToBase mysql = new ConnexionToBase();
                boolean userExist = true;
                try {
                    Connection conn = mysql.connexionToMyBase();
                    CountUsersAndCooks check = new CountUsersAndCooks();
                    userExist = check.checkIntheBaseWithUsernameAndPassword( conn, user );
                    mysql.deconnexionMysql( conn );
                } catch ( ClassNotFoundException | SQLException e ) {
                    e.printStackTrace();
                }
                if ( !userExist ) {
                    SelectUserAfterLogin userSelect = new SelectUserAfterLogin();
                    userSelect.getUserinDB( user );
                    sessionUser.setSession( request, user );
                    response.sendRedirect( "/SupCook/Profil" );
                } else {
                    request.setAttribute( "ErrorUser", "User or Password don't exists" );
                    request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request, response );
                }

            } else {
                request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request, response );
            }
        }

    }

}
