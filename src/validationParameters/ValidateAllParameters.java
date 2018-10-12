package validationParameters;

import javax.servlet.http.HttpServletRequest;

public class ValidateAllParameters {

    public boolean validatorallNameTexte( String nameParameter, String valueParameter, HttpServletRequest request ) {
        String param = "error" + nameParameter.substring( 0, 1 ).toUpperCase() + nameParameter.substring( 1 );
        request.setAttribute( nameParameter, valueParameter );
        if ( valueParameter.length() >= 3 && valueParameter.length() <= 9 ) {
            return true;
        } else {
            request.setAttribute( param, nameParameter + " incorect" );
            return false;
        }
    }

    public boolean validatorPassword( String valueParameter, HttpServletRequest request ) {

        if ( valueParameter
                .matches( "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{5,}" ) ) {
            return true;
        } else {
            request.setAttribute( "errorPassword", "Password incorect" );
            return false;
        }

    }

    public boolean validatorEmail( String valueParameter, HttpServletRequest request ) {
        request.setAttribute( "email", valueParameter );
        if ( valueParameter
                .matches(
                        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" ) ) {
            return true;
        } else {
            request.setAttribute( "errorEmail", "email incorect" );
            return false;
        }
    }

    public boolean validatorPostalCode( String valueParameter, HttpServletRequest request ) {
        request.setAttribute( "postalCode", valueParameter );
        if ( valueParameter.matches( "\\d+" ) && valueParameter.length() == 5 ) {
            return true;
        } else {
            request.setAttribute( "errorPostalCode", "PostalCode incorect" );
            return false;
        }
    }

    public boolean validatorDescriptionCook( String valueParameter, HttpServletRequest request ) {

        request.setAttribute( "description", valueParameter );
        if ( valueParameter.length() >= 3 && valueParameter.length() <= 40 ) {
            return true;
        } else {
            request.setAttribute( "errorDescription", "Description incorrect" );
            return false;
        }
    }

    public boolean validatorTimeNumber( String nameParameter, String valueParameter, HttpServletRequest request ) {
        String param = "error" + nameParameter.substring( 0, 1 ).toUpperCase() + nameParameter.substring( 1 );
        request.setAttribute( nameParameter, valueParameter );
        if ( valueParameter.matches( "\\d+" ) ) {
            return true;
        } else {
            request.setAttribute( param, nameParameter + " incorect" );
            return false;
        }
    }

}
