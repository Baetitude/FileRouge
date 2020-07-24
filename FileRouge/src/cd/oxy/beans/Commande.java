package cd.oxy.beans;

public class Commande {
    // Propriete
    private Client client;
    private String date;
    private Double montant;
    private String modePaiement;
    private String stautPaiement;
    private String modeLivarison;
    private String statutLivarison;

    // getter and setter
    public Client getClient() {
        return client;
    }

    public void setClient( Client client ) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant( Double montant ) {
        this.montant = montant;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement( String modePaiement ) {
        this.modePaiement = modePaiement;
    }

    public String getStautPaiement() {
        return stautPaiement;
    }

    public void setStautPaiement( String stautPaiement ) {
        this.stautPaiement = stautPaiement;
    }

    public String getModeLivarison() {
        return modeLivarison;
    }

    public void setModeLivarison( String modeLivarison ) {
        this.modeLivarison = modeLivarison;
    }

    public String getStatutLivarison() {
        return statutLivarison;
    }

    public void setStatutLivarison( String statutLivarison ) {
        this.statutLivarison = statutLivarison;
    }

}
