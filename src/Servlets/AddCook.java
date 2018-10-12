
package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.Cook;
import forms.User;
import mysql.AddCookInDB;
import session.PrepareSessionUser;
import validationParameters.ValidatorAddingCook;

/**
 * Servlet implementation class AddCook
 */
@WebServlet( "/AddCook" )
public class AddCook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCook() {
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
            request.getRequestDispatcher( "/WEB-INF/AddCook.jsp" ).forward( request, response );
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
            ValidatorAddingCook validatorcook = new ValidatorAddingCook();
            boolean canAdding = validatorcook.validateCook( request );

            if ( canAdding ) {
                Cook cook = Cook.getCook( request );
                PrepareSessionUser userSession = new PrepareSessionUser();
                User user = userSession.getSession( request );

                Runnable r = new AddCookInDB( cook, user );
                new Thread( r ).start();

                response.sendRedirect( "/SupCook/Profil" );
            } else {
                request.getRequestDispatcher( "/WEB-INF/AddCook.jsp" ).forward( request, response );
            }

        }
    }

}
