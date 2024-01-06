package swXsda;

public abstract class VaisseauSpatial implements Cible {
    protected int etat; // État du vaisseau, de 100 (neuf) à 0 (détruit)
    protected int blindage; // Niveau de blindage du vaisseau
    protected ArmeUniverselle arme; // Arme équipée sur le vaisseau

    // Constructeur
    public VaisseauSpatial(int etat, int blindage, ArmeUniverselle arme) {
        this.etat = etat;
        this.blindage = blindage;
        this.arme = arme;
    }

    // Getter pour l'état
    public int getEtat() {
        return etat;
    }

    // Setter pour l'état
    public void setEtat(int etat) {
        this.etat = etat;
        if (this.etat < 0) {
            this.etat = 0; // Assure que l'état ne devient pas négatif
        }
    }

    // Getter pour le blindage
    public int getBlindage() {
        return blindage;
    }

    // Setter pour le blindage
    public void setBlindage(int blindage) {
        this.blindage = blindage;
    }

    // Méthode pour recevoir des dégâts
    @Override
    public void recevoirDegats(int degats) {
        int dommagesEffectifs = degats / blindage;
        setEtat(this.etat - dommagesEffectifs);
    }

    // Méthode pour tirer sur une cible
    public void tirer(Cible cible) {
        if (this.arme != null && this.etat > 0) {
            this.arme.tirer(cible);
        }
    }

    // Méthode abstraite pour des comportements spécifiques de vaisseaux
    public abstract void actionSpecifique();

    // Autres méthodes spécifiques aux vaisseaux spatiaux peuvent être ajoutées ici
}
