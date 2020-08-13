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
import cd.oxy.forms.CreationClientForms;

/**
 * Servlet implementation class CreationClient
 */
@WebServlet( "/CreationClient" )
public class CreationClient extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    public static final String  ATT_CLIENT       = "client";
    public static final String  ATT_FORMS        = "form";
    public static final String  SESSION_CLIENTS  = "clients";

    private static final String VUE_FORMS        = "/WEB-INF/creerClient.jsp";
    private static final String VUE_DATA         = "/WEB-INF/afficherClient.jsp";

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Transmission � la page JSP en charge de l'affichage des donn�es */
        this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Pr�paration de l'objet formulaire */
        CreationClientForms form = new CreationClientForms();

        /*
         * Appel au traitement et � la validation de la requ�te, et r�cup�ration
         * du bean en r�sultant
         */
        Client client = form.nouveauClient( request );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_CLIENT, client );
        request.setAttribute( ATT_FORMS, form );

        if ( form.getErreurs().isEmpty() ) {
            /* Alors r�cup�ration de la map des clients dans la session */
            HttpSession session = request.getSession();
            Map<String, Client> clients = (HashMap<String, Client>) session.getAttribute( SESSION_CLIENTS );

            /*
             * Si aucune map n'existe, alors initialisation d'une nouvelle map
             */
            if ( clients == null ) {
                clients = new HashMap<String, Client>();
            }

            /* Puis ajout du client courant dans la map */
            clients.put( client.getNom(), client );
            /* Et enfin (r�)enregistrement de la map en session */
            session.setAttribute( SESSION_CLIENTS, clients );

            /* Affichage de la fiche r�capitulative */
            this.getServletContext().getRequestDispatcher( VUE_DATA ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
        }

    }
}
