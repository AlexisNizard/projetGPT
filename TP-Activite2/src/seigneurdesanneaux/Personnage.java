package seigneurdesanneaux;

public abstract class Personnage {
    protected String nom;
    protected int pointsVie, connaissances, x, y, v;

    // Constructeur
    public Personnage(String nom, int x, int y, int v) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.pointsVie = 100;
        this.connaissances = 0;
        this.v = v;
    }

    // Getter pour pointsVie
    public int getPointsVie() {
        return this.pointsVie;
    }

    // Setter pour pointsVie
    public void setPointsVie(int pv) {
        this.pointsVie = pv;
    }

    // Getter pour connaissances
    public int getConnaissances() {
        return this.connaissances;
    }

    // Setter pour connaissances
    public void setConnaissances(int co) {
        this.connaissances = co;
    }

    // Méthode pour déplacer le personnage
    public void seDeplacer(int dx, int dy, int t) {
        this.x += dx * v * t;
        this.y += dy * v * t;
    }

    // Méthode abstraite pour parler
    public abstract String parler();

    // Autres méthodes spécifiques au personnage peuvent être ajoutées ici
}
