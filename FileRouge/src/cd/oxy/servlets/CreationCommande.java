package cd.oxy.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cd.oxy.beans.Client;
import cd.oxy.beans.Commande;
import cd.oxy.forms.CreationCommandeForms;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet( "/CreationCommande" )
public class CreationCommande extends HttpServlet {
    public static final long   serialVersionUID  = 1L;

    public static final String ATT_COMMANDE      = "commande";
    public static final String ATT_FORM          = "form";
    public static final String SESSION_CLIENTS   = "clients";
    public static final String SESSION_COMMANDES = "commandes";

    public static final String VUE_FORMS         = "/WEB-INF/creerCommande.jsp";
    public static final String VUE_DATA          = "/WEB-INF/afficherCommande.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Transmission à la page JSP en charge de l'affichage des données */
        this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        CreationCommandeForms form = new CreationCommandeForms();

        Commande commande = form.nouveauCommande( request );

        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_COMMANDE, commande );

        if ( form.getErreurs().isEmpty() ) {

            /* Alors récupération de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );

            /*
             * Si aucune map n'existe, alors initialisation d'une nouvelle map
             */
            if ( clients == null ) {
                clients = new HashMap<String, Client>();
            }
            /* Puis ajout du client de la commande courante dans la map */
            clients.put( commande.getClient().getNom(), commande.getClient() );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );
            /* Ensuite récupération de la map des commandes dans la session */
            Map<String, Commande> commandes = (HashMap<String, Commande>) session.getAttribute( SESSION_COMMANDES );

            /*
             * Si aucune map n'existe, alors initialisation d'une nouvelle map
             */
            if ( commandes == null ) {
                commandes = new HashMap<String, Commande>();
            }
            /* Puis ajout de la commande courante dans la map */
            commandes.put( commande.getDate(), commande );
            /* Et enfin (ré)enregistrement de la map en session */
            session.setAttribute( SESSION_COMMANDES, commandes );

            /* Affichage de la fiche récapitulative */
            this.getServletContext().getRequestDispatcher( VUE_DATA ).forward( request, response );
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les erreurs */
            this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
        }

    }

}
