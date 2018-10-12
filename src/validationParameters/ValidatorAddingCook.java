package validationParameters;

import javax.servlet.http.HttpServletRequest;

public class ValidatorAddingCook {
    private boolean nameCook        = true;
    private boolean descriptionCook = true;
    private boolean preparationTime = true;
    private boolean foodTime        = true;

    public boolean validateCook( HttpServletRequest request ) {

        ValidateAllParameters validatorCook = new ValidateAllParameters();
        this.nameCook = validatorCook.validatorallNameTexte( "nameCook", request.getParameter( "nameCook" ), request );
        this.descriptionCook = validatorCook.validatorDescriptionCook( request.getParameter( "description" ), request );
        this.preparationTime = validatorCook.validatorTimeNumber( "timeP", request.getParameter( "timeP" ), request );
        this.foodTime = validatorCook.validatorTimeNumber( "timeC", request.getParameter( "timeC" ), request );

        if ( nameCook && descriptionCook && preparationTime && foodTime ) {
            return true;
        } else {
            return false;
        }

    }
}
