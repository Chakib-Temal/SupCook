package validatePhoto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class ValidatorPicture {
    public final static String CHEMIN = "/Users/macbookpro/Documents/eclipse-work/workspace/SupCook/WebContent/";
    public static boolean      reponse;

    public static String validatorPictureCook( HttpServletRequest request ) throws IOException, ServletException {
        Part part = request.getPart( "photo" );
        String nameOfPicture = getNomFichier( part );

        if ( !nameOfPicture.matches( "(.*/)*.+\\.(png|jpg|bmp|jpeg|PNG|JPG|BMP|JPEG)$" ) ) {
            request.setAttribute( "errorPhoto", "File is not a picture" );
            reponse = false;
            return "";
        } else {
            java.sql.Timestamp date = new java.sql.Timestamp( new java.util.Date().getTime() );
            nameOfPicture = String.valueOf( date.hashCode() );
            ecrireFichier( part, nameOfPicture );
            reponse = true;
            return nameOfPicture;
        }
    }

    private static String getNomFichier( Part part ) {
        /*
         * Boucle sur chacun des paramètres de l'en-tête "content-disposition".
         */
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            /* Recherche de l'éventuelle présence du paramètre "filename". */
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                /*
                 * Si "filename" est présent, alors renvoi de sa valeur,
                 * c'est-à-dire du nom de fichier.
                 */
                // enlever les ""
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        /* Et pour terminer, si rien n'a été trouvé... */
        return null;
    }

    private static void ecrireFichier( Part part, String nomFichier ) throws IOException {
        /* Prépare les flux. */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux. */
            entree = new BufferedInputStream( part.getInputStream(), 10240 );
            sortie = new BufferedOutputStream(
                    new FileOutputStream(
                            new File( CHEMIN + nomFichier ) ),
                    10240 );
            /* ... */
            byte[] tampon = new byte[10240];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }
}
