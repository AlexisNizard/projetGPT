package starwars;

public class Arme {
    private int puissance;
    private Personnage possesseur;

    // Constructeur
    public Arme(int puissance, Personnage possesseur) {
        this.puissance = puissance;
        this.possesseur = possesseur;
    }

    // Getter pour puissance
    public int getPuissance() {
        return puissance;
    }

    // Setter pour puissance
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    // Getter pour possesseur
    public Personnage getPossesseur() {
        return possesseur;
    }

    // Setter pour possesseur
    public void setPossesseur(Personnage possesseur) {
        this.possesseur = possesseur;
    }

    // Méthode pour tirer sur une cible
    public void tirer(Cible cible) {
        if (possesseur != null && possesseur.estVivant()) {
            cible.recevoirDegats(this.puissance);
        }
    }
}
