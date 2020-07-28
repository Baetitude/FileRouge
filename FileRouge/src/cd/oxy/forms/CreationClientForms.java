package cd.oxy.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cd.oxy.beans.Client;

public class CreationClientForms {

    private static final String ATT_NOM       = "nomClient";
    private static final String ATT_PRENOM    = "prenomClient";
    private static final String ATT_ADRESSE   = "adresseClient";
    private static final String ATT_TELEPHONE = "telephoneClient";
    private static final String ATT_EMAIL     = "emailClient";

    private String              resultat;
    private Map<String, String> erreurs       = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Client nouveauClient( HttpServletRequest request ) {
        /*
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = getValeurChamp( request, ATT_NOM );
        String prenom = getValeurChamp( request, ATT_PRENOM );
        String adresse = getValeurChamp( request, ATT_ADRESSE );
        String telephone = getValeurChamp( request, ATT_TELEPHONE );
        String email = getValeurChamp( request, ATT_EMAIL );

        Client client = new Client();

        try {
            validationNom( nom );
        } catch ( Exception e ) {
            setErreur( ATT_NOM, e.getMessage() );
        }
        client.setNom( nom );

        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( ATT_PRENOM, e.getMessage() );
        }
        client.setPrenom( prenom );

        try {
            validationAdresse( adresse );
        } catch ( Exception e ) {
            setErreur( ATT_ADRESSE, e.getMessage() );
        }
        client.setAdresse( adresse );

        try {
            validationTelephone( telephone );
        } catch ( Exception e ) {
            setErreur( ATT_TELEPHONE, e.getMessage() );
        }
        client.setTelephone( telephone );

        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( ATT_EMAIL, e.getMessage() );
        }
        client.setEmail( email );

        if ( erreurs.isEmpty() ) {
            resultat = "Création du Client reussie avec Succes .";
        } else {
            resultat = "Echecs de la création du Client .";
        }

        return client;
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private String getValeurChamp( HttpServletRequest request, String attNom ) {
        String valeur = request.getParameter( attNom );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }

    }

    private void validationNom( String nom ) throws Exception {
        if ( nom != null ) {
            if ( nom.length() < 2 ) {
                throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Veuillez saisir le nom d'utilisateur svp." );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null && prenom.length() < 3 ) {
            throw new Exception( "Le prenom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    private void validationAdresse( String adresse ) throws Exception {
        if ( adresse != null ) {
            if ( adresse.length() < 10 ) {
                throw new Exception( "L'adresse doit contenir au moins 10 caractères." );
            }
        } else {
            throw new Exception( "Veuillez saisir l'addresse svp" );
        }
    }

    private void validationTelephone( String telephone ) throws Exception {
        if ( telephone != null ) {
            if ( telephone.length() < 4 ) {
                throw new Exception( "Le numero de telephone doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Veuillez saisir un num tel" );
        }
    }

    private void validationEmail( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void setErreur( String attEmail, String message ) {
        erreurs.put( attEmail, message );
    }
}
