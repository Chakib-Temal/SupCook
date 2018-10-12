package validationParameters;

import javax.servlet.http.HttpServletRequest;

public class ValidatorLogin {

    public boolean validateLogin( HttpServletRequest request ) {
        boolean resultUsername = true;
        boolean resultPassword = true;

        ValidateAllParameters validatorLog = new ValidateAllParameters();
        resultUsername = validatorLog.validatorallNameTexte( "userName", request.getParameter( "userName" ), request );
        resultPassword = validatorLog.validatorPassword( request.getParameter( "password" ), request );
        if ( resultPassword && resultUsername ) {
            return true;
        } else {
            return false;
        }

    }
}
