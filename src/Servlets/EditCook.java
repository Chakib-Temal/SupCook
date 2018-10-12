package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.Cook;
import mysql.UpdateCook;
import mysql.ViewCookById;
import session.PrepareSessionUser;
import validationParameters.ValidatorAddingCook;

/**
 * Servlet implementation class EditCook
 */
@WebServlet( "/EditCook" )
public class EditCook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCook() {
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
            ViewCookById cookId = new ViewCookById();
            try {
                cookId.getCookById( request );
            } catch ( ClassNotFoundException | SQLException e ) {
                e.printStackTrace();
            }
            request.setAttribute( "id", request.getParameter( "id" ) );
            request.getRequestDispatcher( "/WEB-INF/EditCook.jsp" ).forward( request, response );
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
        PrepareSessionUser sessionUser = new PrepareSessionUser();
        if ( !sessionUser.isAvailable( request ) ) {
            response.sendRedirect( "/SupCook/Login" );

        } else {
            ValidatorAddingCook validatorcook = new ValidatorAddingCook();
            boolean canAdding = validatorcook.validateCook( request );
            if ( canAdding ) {
                Cook cook = Cook.getCook( request );
                String id = request.getParameter( "id" );

                Runnable r = new UpdateCook( cook, id );
                new Thread( r ).start();
                response.sendRedirect( "/SupCook/Profil" );
            } else {
                this.doGet( request, response );
            }
        }
    }

}
