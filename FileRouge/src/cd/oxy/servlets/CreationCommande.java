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
         * Récupération des données saisies, envoyées en tant que paramètres de
         * la requête GET générée à la validation du formulaire
         */
        String nom = request.getParameter( ATT_NOM );
        String prenom = request.getParameter( ATT_PRENOM );
        String adresse = request.getParameter( ATT_ADRESSE );
        String telephone = request.getParameter( ATT_TELEPHONE );
        String email = request.getParameter( ATT_EMAIL );

        /* Récupération de la date courante */
        DateTime dt = new DateTime();
        /* Conversion de la date en String selon le format défini */
        DateTimeFormatter formatter = DateTimeFormat.forPattern( ATT_DATE );
        String date = dt.toString( formatter );

        double montant;
        try {
            /* Récupération du montant */
            montant = Double.parseDouble( request.getParameter( ATT_MONTANT ) );
        } catch ( NumberFormatException e ) {
            /* Initialisation à -1 si le montant n'est pas un nombre correct */
            montant = -1;
        }
        String modePaiement = request.getParameter( MODEPAIEMENT );
        String statutPaiement = request.getParameter( STATUTPAIEMENT );
        String modeLivraison = request.getParameter( MODELIVRAISON );
        String statutLivraison = request.getParameter( STATUTLIVRAISON );

        String Message;
        boolean erreur;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ||
                montant == -1 || modePaiement.trim().isEmpty() || modeLivraison.trim().isEmpty() ) {
            Message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a"
                    + " href=\"creerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande.";
            erreur = true;
        } else {
            Message = "Création Commande Avec Succes";
            erreur = false;
        }

        /*
         * Création des beans Client et Commande et initialisation avec les
         * données récupérées
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

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_ERREUR, erreur );
        request.setAttribute( ATT_MESSAGE, Message );
        request.setAttribute( ATT_COMMANDE, commande );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost( req, resp );
    }

}
