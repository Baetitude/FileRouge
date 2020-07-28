package cd.oxy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cd.oxy.beans.Commande;
import cd.oxy.forms.CreationCommandeForms;

/**
 * Servlet implementation class CreationCommande
 */
@WebServlet( "/CreationCommande" )
public class CreationCommande extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String ATT_COMMANDE     = "commande";
    private static final String ATT_FORM         = "form";

    private static final String VUE_FORMS        = "/WEB-INF/creerCommande.jsp";
    private static final String VUE_DATA         = "/WEB-INF/afficherCommande.jsp";

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
            this.getServletContext().getRequestDispatcher( VUE_DATA ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE_FORMS ).forward( request, response );
        }

    }

}
