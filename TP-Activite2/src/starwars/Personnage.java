package starwars;

public abstract class Personnage implements Cible{
    protected String nom;
    protected int pointsVie, x, y, v, precision; // precision de 0 à 100
    private Arme arme; // Ajout d'un attribut pour l'arme

    // Constructeur
    public Personnage(String n, int x, int y, int v, int precision) {
        this.nom = n;
        this.x = x;
        this.y = y;
        this.pointsVie = 100;
        this.v = v;
        this.precision = precision;
    }

    // Getter pour pointsVie
    public int getPointsVie() {
        return this.pointsVie;
    }

    // Setter pour pointsVie
    public void setPointsVie(int pv) {
        this.pointsVie = pv;
    }

    // Getter pour precision
    public int getPrecision() {
        return this.precision;
    }

    // Méthode pour déplacer le personnage
    public void seDeplacer(int dx, int dy, int t) {
        this.x = (int) (this.x + dx * this.v * t / Math.sqrt(dx * dx + dy * dy));
        this.y = (int) (this.y + dy * this.v * t / Math.sqrt(dx * dx + dy * dy));
    }

    // Implémentation de la méthode de l'interface Cible
    public void recevoirDegats(int degats) {
        this.pointsVie -= degats;
        if (this.pointsVie < 0) {
            this.pointsVie = 0;
        }
    }

    // Méthode pour associer une arme à un personnage
    public void setArme(Arme arme) {
        this.arme = arme;
    }

    // Getter pour l'arme
    public Arme getArme() {
        return this.arme;
    }

    // Méthode abstraite pour une action spécifique du personnage
    public abstract void action();

    // Méthode pour vérifier si le personnage est vivant
    public boolean estVivant() {
        return this.pointsVie > 0;
    }
    
    // Méthodes supplémentaires peuvent être ajoutées ici selon les besoins du jeu
}
