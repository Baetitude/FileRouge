package cd.oxy.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListerCommandes
 */
@WebServlet( "/ListerCommandes" )
public class ListerCommandes extends HttpServlet {
    private static final long   serialVersionUID = 1L;

    private static final String ATT_CLIENT       = "commande";
    private static final String ATT_FORM         = "form";

    private static final String VUE              = "/WEB-INF/listerCommandes.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerCommandes() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /*
         * À la réception d'une requête GET, affichage de la liste des commandes
         */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
