package cd.oxy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cd.oxy.beans.Client;

/**
 * Servlet implementation class CreationClient
 */
@WebServlet( "/CreationClient" )
public class CreationClient extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String ATT_CLIENT       = "client";
    private static final String ATT_MESSAGE      = "message";
    private static final String ATT_ERREUR       = "erreur";

    private static final String VUE_FORMS        = "/WEB-INF/creerClient.jsp";
    private static final String VUE_DATA         = "/WEB-INF/afficherClient.jsp";

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

        String Message;
        boolean eRReur;
        /*
         * Initialisation du message à afficher : si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message
         * d'erreur, sinon on affiche un message de succès
         */
        if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() ) {
            Message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> "
                    + "<a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
            eRReur = true;
        } else {
            Message = "Création client Avec Succes";
            eRReur = false;
        }

        /*
         * Création du bean Client et initialisation avec les données récupérées
         */
        Client client = new Client();
        client.setNom( nom );
        client.setPrenom( prenom );
        client.setAdresse( adresse );
        client.setTelephone( telephone );
        client.setEmail( email );

        /* Ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_ERREUR, eRReur );
        request.setAttribute( ATT_MESSAGE, Message );
        request.setAttribute( ATT_CLIENT, client );

        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost( req, resp );
    }
}
