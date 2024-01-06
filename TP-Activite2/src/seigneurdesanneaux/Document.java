package seigneurdesanneaux;

public class Document extends Objet {
    private int connaissances;
    private boolean estLu;
    private Humanoide proprietaire; // Ajout de l'attribut proprietaire

    // Constructeur
    public Document(String nom, int prix, int connaissances) {
        super(nom, prix);
        this.connaissances = connaissances;
        this.estLu = false;
        this.proprietaire = null; // Initialise à null
    }

    // Getter pour le propriétaire
    public Humanoide getProprietaire() {
        return proprietaire;
    }

    // Setter pour le propriétaire
    public void setProprietaire(Humanoide proprietaire) {
        this.proprietaire = proprietaire;
    }

    // Méthode pour lire le document
    public void lire(Humanoide lecteur) {
        if (!estLu && lecteur.equals(this.proprietaire)) {
            lecteur.setConnaissances(lecteur.getConnaissances() + this.connaissances);
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

    // Méthode pour vérifier si le document a été lu
    public boolean estDejaLu() {
        return estLu;
    }
}
