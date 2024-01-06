package seigneurdesanneaux;

public class Arme extends Objet {
    private int puissance;
    private Humanoide proprietaire;

    // Constructeur
    public Arme(String nom, int prix, int puissance) {
        super(nom, prix);
        this.puissance = puissance;
        this.proprietaire = null;
    }

    // Getter pour la puissance
    public int getPuissance() {
        return puissance;
    }

    // Setter pour la puissance
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    // Getter pour le propriétaire
    public Humanoide getProprietaire() {
        return proprietaire;
    }

    // Setter pour le propriétaire
    public void setProprietaire(Humanoide proprietaire) {
        this.proprietaire = proprietaire;
    }

    // Méthode pour utiliser l'arme contre un autre personnage
    public void utiliser(Personnage cible) {
        if (proprietaire != null && proprietaire.equals(this.proprietaire)) {
            cible.setPointsVie(cible.getPointsVie() - this.puissance);
        }
    }
}
