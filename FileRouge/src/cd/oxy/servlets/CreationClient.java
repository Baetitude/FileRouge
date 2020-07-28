package cd.oxy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cd.oxy.beans.Client;
import cd.oxy.forms.CreationClientForms;

/**
 * Servlet implementation class CreationClient
 */
@WebServlet( "/CreationClient" )
public class CreationClient extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String ATT_CLIENT       = "client";
    private static final String ATT_FORMS        = "form";

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
            this.getServletContext().getRequestDispatcher( VUE_DATA ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
        }

    }
}
