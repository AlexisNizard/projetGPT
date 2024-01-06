package swXsda;

public class ArmeUniverselle extends Objet {
    private int puissance;
    private Personnage proprietaire;

    // Constructeur
    // Dans ArmeUniverselle, le constructeur doit ressembler à ceci :
    public ArmeUniverselle(String nom, int prix, int puissance, Personnage proprietaire) {
        super(nom, prix);
        this.puissance = puissance;
        this.proprietaire = proprietaire;
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
    public Personnage getProprietaire() {
        return proprietaire;
    }

    // Setter pour le propriétaire
    public void setProprietaire(Personnage proprietaire) {
        this.proprietaire = proprietaire;
    }

    // Méthode pour utiliser l'arme contre un autre personnage
    public void utiliser(Personnage cible) {
        if (proprietaire != null && proprietaire.equals(this.proprietaire) && cible instanceof Cible) {
            ((Cible) cible).recevoirDegats(this.puissance);
        }
    }
    
    // Méthode pour tirer sur une cible
    public void tirer(Cible cible) {
        if (proprietaire != null && proprietaire.estVivant()) {
            cible.recevoirDegats(this.puissance);
        }
    }
}
