package cd.oxy.forms;

import javax.servlet.http.HttpServletRequest;

import cd.oxy.beans.Commande;

public class CreationCommandeForms {

    private static final String ATT_NOM         = "nomClient";
    private static final String ATT_PRENOM      = "prenomClient";
    private static final String ATT_ADRESSE     = "adresseClient";
    private static final String ATT_TELEPHONE   = "telephoneClient";
    private static final String ATT_EMAIL       = "emailClient";

    private static final String ATT_DATE        = "dd/MM/yyyy HH:mm:ss";
    private static final String ATT_MONTANT     = "montantCommande";

    private static final String MODEPAIEMENT    = "modePaiementCommande";
    private static final String STATUTPAIEMENT  = "statutPaiementCommande";
    private static final String MODELIVRAISON   = "modeLivraisonCommande";
    private static final String STATUTLIVRAISON = "statutLivraisonCommande";

    public Commande nouveauCommande( HttpServletRequest request ) {

    }
}
