package swXsda;

public class DocumentUniversel extends Objet {
    private int connaissances;
    private boolean estLu;
    private Personnage proprietaire; // Le propriétaire du document

    // Constructeur
    public DocumentUniversel(String nom, int prix, int connaissances) {
        super(nom, prix);
        this.connaissances = connaissances;
        this.estLu = false;
        this.proprietaire = null;
    }

    // Getter pour le propriétaire
    public Personnage getProprietaire() {
        return proprietaire;
    }

    // Setter pour le propriétaire
    public void setProprietaire(Personnage proprietaire) {
        this.proprietaire = proprietaire;
    }

    // Méthode pour lire le document
    public void lire() {
        if (!estLu && proprietaire != null) {
            proprietaire.setConnaissances(proprietaire.getConnaissances() + this.connaissances);
            this.estLu = true;
        }
    }

    // Getter pour connaissances
    public int getConnaissances() {
        return connaissances;
    }

    // Setter pour connaissances
    public void setConnaissances(int connaissances) {
        this.connaissances = connaissances;
    }

    // Méthode pour vérifier si le document a déjà été lu
    public boolean estDejaLu() {
        return estLu;
    }
}
