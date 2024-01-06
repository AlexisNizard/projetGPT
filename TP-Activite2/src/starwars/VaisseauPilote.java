package starwars;


public class VaisseauPilote extends VaisseauSpatial {
    private Personnage pilote;

    // Constructeur
    public VaisseauPilote(int etat, int blindage, Arme arme, Personnage pilote) {
        super(etat, blindage, arme);
        this.pilote = pilote;
    }

    // Getter pour pilote
    public Personnage getPilote() {
        return pilote;
    }

    // Setter pour pilote
    public void setPilote(Personnage pilote) {
        this.pilote = pilote;
    }

    // Implémentation de la méthode abstraite actionSpecifique
    @Override
    public void actionSpecifique() {
        // Logique spécifique au vaisseau piloté
        // Par exemple, exécuter des manœuvres complexes ou explorer des zones dangereuses
    }

    // Surcharge de la méthode tirer pour utiliser la précision du pilote
    @Override
    public void tirer(Cible cible) {
        if (this.arme != null && this.etat > 0 && this.pilote != null && this.pilote.estVivant()) {
            if (new java.util.Random().nextInt(100) < pilote.getPrecision()) {
                this.arme.tirer(cible);
            }
        }
    }
}
