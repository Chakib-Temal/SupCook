package session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import forms.User;

public class PrepareSessionUser {

    public User prepareUserForSession( HttpServletRequest request ) {
        User user = new User();
        user.setUserName( request.getParameter( "userName" ) );
        user.setFirstName( request.getParameter( "firstName" ) );
        user.setLastName( request.getParameter( "lastName" ) );
        user.setEmail( request.getParameter( "email" ) );
        user.setPassword( request.getParameter( "password" ) );
        user.setPostalCode( request.getParameter( "postalCode" ) );
        return user;
    }

    public void setSession( HttpServletRequest request, User user ) {
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
    }

    public boolean isAvailable( HttpServletRequest request ) {
        HttpSession session = request.getSession();

        if ( session.getAttribute( "user" ) == null ) {
            return false;
        } else {
            return true;
        }
    }

    public User getSession( HttpServletRequest request ) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute( "user" );
        return user;
    }

}
