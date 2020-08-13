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

import cd.oxy.beans.Commande;

/**
 * Servlet implementation class SuppressionCommande
 */
@WebServlet( "/SuppressionCommande" )
public class SuppressionCommande extends HttpServlet {
    private static final long  serialVersionUID    = 1L;

    public static final String PARAM_DATE_COMMANDE = "dateCommande";
    public static final String SESSION_COMMANDES   = "commandes";
    public static final String VUE                 = "/listerCommandes";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionCommande() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* R�cup�ration du param�tre */
        String dateCommande = getValeurParameter( request, PARAM_DATE_COMMANDE );

        /* R�cup�ration de la Map des commandes enregistr�es en session */
        HttpSession session = request.getSession();
        @SuppressWarnings( "unchecked" )
        Map<String, Commande> commandes = (HashMap<String, Commande>) session.getAttribute( SESSION_COMMANDES );

        /*
         * Si la date de la commande et la Map des commandes ne sont pas vides
         */
        if ( dateCommande != null && commandes != null ) {
            /* Alors suppression de la commande de la Map */
            commandes.remove( dateCommande );
            /* Et remplacement de l'ancienne Map en session par la nouvelle */
            session.setAttribute( SESSION_COMMANDES, commandes );
        }
        /* Redirection vers la fiche r�capitulative */
        response.sendRedirect( request.getContextPath() + VUE );
    }

    /*
     * M�thode utilitaire qui retourne null si un param�tre est vide, et son
     * contenu sinon.
     */
    private static String getValeurParameter( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

}