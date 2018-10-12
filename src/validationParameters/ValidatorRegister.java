package validationParameters;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

public class ValidatorRegister {

    public boolean validateRegister( HttpServletRequest request ) {
        Map<String, String> mbs = new HashMap<String, String>();
        Enumeration<String> parameterNames = request.getParameterNames();

        while ( parameterNames.hasMoreElements() ) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter( paramName );
            mbs.put( paramName, paramValue );
        }
        ValidateAllParameters validatorTexte = new ValidateAllParameters();

        int indexParameter = 0;
        boolean[] result = new boolean[6];
        for ( int i = 0; i < result.length; i++ ) {
            result[i] = true;
        }

        for ( Entry<String, String> entry : mbs.entrySet() ) {

            if ( entry.getKey().equals( "password" ) ) {
                result[indexParameter] = validatorTexte.validatorPassword( entry.getValue(), request );
            } else if ( entry.getKey().equals( "postalCode" ) ) {
                result[indexParameter] = validatorTexte.validatorPostalCode( entry.getValue(), request );

            } else if ( entry.getKey().equals( "email" ) ) {
                result[indexParameter] = validatorTexte.validatorEmail( entry.getValue(), request );
            } else {
                result[indexParameter] = validatorTexte.validatorallNameTexte( entry.getKey(), entry.getValue(),
                        request );
            }
            indexParameter++;
        }
        for ( int i = 0; i < result.length; i++ ) {
            if ( result[i] == false ) {
                return false;
            }
        }
        return true;

    }
}
