package seigneurdesanneaux;

public class Objet {
    protected String nom;
    protected int prix;

    // Constructeur
    public Objet(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }

    // Setter pour le nom
    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter pour le prix
    public int getPrix() {
        return prix;
    }

    // Setter pour le prix
    public void setPrix(int prix) {
        this.prix = prix;
    }

    // Autres méthodes et logique spécifique à un objet peuvent être ajoutées ici
}
