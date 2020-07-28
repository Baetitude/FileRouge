package cd.oxy.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import cd.oxy.beans.Client;
import cd.oxy.beans.Commande;

public class CreationCommandeForms {
    // private static final String ATT_DATE = "dateCommande";
    private static final String ATT_MONTANT     = "montantCommande";
    private static final String MODEPAIEMENT    = "modePaiementCommande";
    private static final String STATUTPAIEMENT  = "statutPaiementCommande";
    private static final String MODELIVRAISON   = "modeLivraisonCommande";
    private static final String STATUTLIVRAISON = "statutLivraisonCommande";

    private static final String DATE_FORMAT     = "dd/MM/yyyy HH:mm:ss";

    private String              resultat;
    private Map<String, String> erreurs         = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Commande nouveauCommande( HttpServletRequest request ) {
        /*
         * L'objet m�tier pour valider la cr�ation d'un client existe d�j�, il
         * est donc d�conseill� de dupliquer ici son contenu ! � la place, il
         * suffit de passer la requ�te courante � l'objet m�tier existant et de
         * r�cup�rer l'objet Client cr��.
         */
        CreationClientForms formcl = new CreationClientForms();
        Client client = formcl.nouveauClient( request );

        /*
         * Et tr�s important, il ne faut pas oublier de r�cup�rer le contenu de
         * la map d'erreurs cr��e par l'objet m�tier CreationClientForm dans la
         * map d'erreurs courante, actuellement vide.
         */
        erreurs = formcl.getErreurs();

        /*
         * Ensuite, il suffit de proc�der normalement avec le reste des champs
         * sp�cifiques � une commande.
         */

        /*
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire
         */

        /* R�cup�ration de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format d�fini */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( DATE_FORMAT );
        String date = dt.toString( formatter );

        String montant = getValeurChamp( request, ATT_MONTANT );
        String modePaiement = getValeurChamp( request, MODEPAIEMENT );
        String statutPaiement = getValeurChamp( request, STATUTPAIEMENT );
        String modeLivraison = getValeurChamp( request, MODELIVRAISON );
        String statutLivraison = getValeurChamp( request, STATUTLIVRAISON );

        Commande commande = new Commande();

        commande.setClient( client );
        commande.setDate( date );

        double valeurMontant = -1;
        try {
            valeurMontant = validationMontant( montant );
        } catch ( Exception e ) {
            setErreur( ATT_MONTANT, e.getMessage() );
        }
        commande.setMontant( valeurMontant );

        try {
            validationModePaiement( modePaiement );
        } catch ( Exception e ) {
            setErreur( MODEPAIEMENT, e.getMessage() );
        }
        commande.setModePaiement( modePaiement );

        try {
            validationStatutPaiement( statutPaiement );
        } catch ( Exception e ) {
            setErreur( STATUTPAIEMENT, e.getMessage() );
        }
        commande.setStatutPaiement( statutPaiement );

        try {
            validationModeLivraison( modeLivraison );
        } catch ( Exception e ) {
            setErreur( MODELIVRAISON, e.getMessage() );
        }
        commande.setModeLivraison( modeLivraison );

        try {
            validationStatutLivraison( statutLivraison );
        } catch ( Exception e ) {
            setErreur( STATUTLIVRAISON, e.getMessage() );
        }
        commande.setStatutLivraison( statutLivraison );

        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s de la cr�ation de la commande.";
        } else {
            resultat = "�chec de la cr�ation de la commande.";
        }

        return commande;
    }

    private void validationStatutLivraison( String statutLivraison ) throws Exception {
        if ( statutLivraison != null && statutLivraison.length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins 2 caract�res." );
        }
    }

    private void validationModeLivraison( String modeLivraison ) throws Exception {
        if ( modeLivraison != null ) {
            if ( modeLivraison.length() < 2 ) {
                throw new Exception( "Le mode de livraison doit contenir au moins 2 caract�res." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de livraison." );
        }
    }

    private void validationStatutPaiement( String statutPaiement ) throws Exception {
        if ( statutPaiement != null && statutPaiement.length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins 2 caract�res." );
        }
    }

    private void validationModePaiement( String modePaiement ) throws Exception {
        if ( modePaiement != null ) {
            if ( modePaiement.length() < 2 ) {
                throw new Exception( "Le mode de paiement doit contenir au moins 2 caract�res." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de paiement." );
        }
    }

    private double validationMontant( String montant ) throws Exception {
        double temp;
        if ( montant != null ) {
            try {
                temp = Double.parseDouble( montant );
                if ( temp < 0 ) {
                    throw new Exception( "Le montant doit �tre un nombre positif." );
                }
            } catch ( NullPointerException e ) {
                temp = -1;
                throw new Exception( "Le montant doit �tre un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un montant." );
        }
        return temp;
    }

    /*
     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
