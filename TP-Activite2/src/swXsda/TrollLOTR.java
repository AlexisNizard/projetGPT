package swXsda;

public class TrollLOTR extends Personnage implements MonstreLOTR {
    private int force;
    private int puanteur;

    // Constructeur
    public TrollLOTR(String nom, int x, int y, int vitesse, int force, int puanteur) {
        super(nom, x, y, vitesse, 0); // La précision est fixée à 0 par défaut pour les trolls
        this.force = force;
        this.puanteur = puanteur;
    }

    // Implémentation de la méthode attaque de l'interface MonstreLOTR
    @Override
    public void attaque(Personnage p) {
        if (!(p instanceof TrollLOTR)) { // Un troll ne peut pas attaquer un autre troll
            int degats = this.force + (this.puanteur / 10);
            p.recevoirDegats(degats);
        }
    }

    // Getter pour la force
    public int getForce() {
        return force;
    }

    // Setter pour la force
    public void setForce(int force) {
        this.force = force;
    }

    // Implémentation de la méthode getPuanteur de l'interface MonstreLOTR
    @Override
    public int getPuanteur() {
        return puanteur;
    }

    @Override
    public void action() {
        // Comportement spécifique du troll
        // Par exemple, rugir ou chercher des ennemis
    }

    @Override
    public String parler() {
        return "Grrr, je suis " + this.nom + ", un Troll du Seigneur des Anneaux!";
    }
}
