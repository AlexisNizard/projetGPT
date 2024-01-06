package seigneurdesanneaux;

public class Troll extends Personnage implements Monstre {
    private int force;
    private int puanteur;

    // Constructeur
    public Troll(String nom, int x, int y, int v, int force, int puanteur) {
        super(nom, x, y, v);
        this.force = force;
        this.puanteur = puanteur;
    }

    // Implémentation de la méthode attaque de l'interface Monstre
    @Override
    public void attaque(Personnage p) {
        if (!(p instanceof Troll)) { // Un troll n'attaque pas un autre troll
            int degats = this.force + (this.puanteur / 10);
            p.setPointsVie(p.getPointsVie() - degats);
        }
    }

    // Implémentation de la méthode getPuanteur de l'interface Monstre
    @Override
    public int getPuanteur() {
        return puanteur;
    }

    // Getter pour la force
    public int getForce() {
        return force;
    }

    // Setter pour la force
    public void setForce(int force) {
        this.force = force;
    }

    // Méthode parler (implémentation de la méthode abstraite de Personnage)
    @Override
    public String parler() {
        return "Grrr, je suis " + this.nom + " le Troll!";
    }

    // Autres méthodes spécifiques aux trolls peuvent être ajoutées ici
}
