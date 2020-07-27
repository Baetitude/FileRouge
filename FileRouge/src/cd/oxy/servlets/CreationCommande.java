package cd.oxy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import cd.oxy.beans.Client;
import cd.oxy.beans.Commande;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet( "/CreationCommande" )
public class CreationCommande extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String VUE_FORMS        = "/WEB-INF/creerCommande.jsp";
    private static final String VUE_DATA         = "/WEB-INF/afficherCommande.jsp";

    private static final String ATT_ERREUR       = "erreur";
    private static final String ATT_MESSAGE      = "message";
    private static final String ATT_COMMANDE     = "commande";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /*
         * R�cup�ration des donn�es saisies, envoy�es en tant que param�tres de
         * la requ�te GET g�n�r�e � la validation du formulaire
         */
        String nom = request.getParameter( ATT_NOM );
        String prenom = request.getParameter( ATT_PRENOM );
        String adresse = request.getParameter( ATT_ADRESSE );
        String telephone = request.getParameter( ATT_TELEPHONE );
        String email = request.getParameter( ATT_EMAIL );

        /* R�cup�ration de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format d�fini */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( ATT_DATE );
        String date = dt.toString( formatter );

        double montant;
        try {
            /* R�cup�ration du montant */
            montant = Double.parseDouble( request.getParameter( ATT_MONTANT ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation � -1 si le montant n'est pas un nombre correct */
            montant = -1;
        }
        String modePaiement = request.getParameter( MODEPAIEMENT );
        String statutPaiement = request.getParameter( STATUTPAIEMENT );
        String modeLivraison = request.getParameter( MODELIVRAISON );
        String statutLivraison = request.getParameter( STATUTLIVRAISON );

        String Message;
        boolean erreur;
        /*
         * Initialisation du message � afficher : si un des champs obligatoires
         * du formulaire n'est pas renseign�, alors on affiche un message
         * d'erreur, sinon on affiche un message de succ�s
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ||
                montant == -1 || modePaiement.trim().isEmpty() || modeLivraison.trim().isEmpty() ) {
            Message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a"
                    + " href=\"creerCommande.jsp\">Cliquez ici</a> pour acc�der au formulaire de cr�ation d'une commande.";
            erreur = true;
        } else {
            Message = "Cr�ation Commande Avec Succes";
            erreur = false;
        }

        /*
         * Cr�ation des beans Client et Commande et initialisation avec les
         * donn�es r�cup�r�es
         */
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        Commande commande = new Commande();
        commande.setClient( client );
        commande.setDate( date );
        commande.setMontant( montant );
        commande.setModePaiement( modePaiement );
        commande.setStatutPaiement( statutPaiement );
        commande.setModeLivraison( modeLivraison );
        commande.setStatutLivraison( statutLivraison );

        /* Ajout du bean et du message � l'objet requ�te */
        request.setAttribute( ATT_ERREUR, erreur );
        request.setAttribute( ATT_MESSAGE, Message );
        request.setAttribute( ATT_COMMANDE, commande );

        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost( req, resp );
    }

}
