package swXsda;

public abstract class Personnage implements Cible {
    protected String nom;
    protected int pointsVie, x, y, vitesse, precision; // Ces attributs sont communs dans les deux univers
    protected int connaissances;
    protected ArmeUniverselle arme;

    // Constructeur
    public Personnage(String nom, int x, int y, int vitesse, int precision) {
        this.nom = nom;
        this.x = x;
        this.y = y;
        this.pointsVie = 100; // Valeur par défaut pour les points de vie
        this.vitesse = vitesse;
        this.precision = precision;
    }

    // Méthode pour déplacer le personnage
    public void seDeplacer(int dx, int dy, int temps) {
        this.x += dx * vitesse * temps;
        this.y += dy * vitesse * temps;
    }

    // Méthode abstraite pour une action spécifique du personnage
    public abstract void action();

    // Getter et Setter pour les points de vie
    public int getPointsVie() {
        return pointsVie;
    }

    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
        if (this.pointsVie < 0) {
            this.pointsVie = 0; // Assure que les points de vie ne sont pas négatifs
        }
    }

    // Getter et Setter pour la précision
    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    // Implémentation de la méthode de l'interface Cible
    @Override
    public void recevoirDegats(int degats) {
        this.pointsVie -= degats;
        if (this.pointsVie < 0) {
            this.pointsVie = 0;
        }
    }

    // Méthode pour vérifier si le personnage est vivant
    public boolean estVivant() {
        return this.pointsVie > 0;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public abstract String parler(); 

	public int getConnaissances() {
        return connaissances;
    }

    public void setConnaissances(int connaissances) {
        this.connaissances = connaissances;
    }
    
    public void setArme(ArmeUniverselle arme) {
        this.arme = arme;
    }

    public ArmeUniverselle getArme() {
        return this.arme;
    }
    // Autres méthodes spécifiques au personnage peuvent être ajoutées ici
}
