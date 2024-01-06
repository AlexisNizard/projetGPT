package swXsda;

public class VaisseauPilote extends VaisseauSpatial {
    private Personnage pilote;

    // Constructeur
    public VaisseauPilote(int etat, int blindage, ArmeUniverselle arme, Personnage pilote) {
        super(etat, blindage, arme);
        this.pilote = pilote;
    }

    // Getter pour le pilote
    public Personnage getPilote() {
        return pilote;
    }

    // Setter pour le pilote
    public void setPilote(Personnage pilote) {
        this.pilote = pilote;
    }

    // Implémentation de la méthode abstraite actionSpecifique
    @Override
    public void actionSpecifique() {
        // Logique spécifique au vaisseau piloté
        executerManoeuvres();
    }

    private void executerManoeuvres() {
        // Logique des manœuvres exécutées par le vaisseau piloté
        System.out.println("Le vaisseau piloté par " + pilote.getNom() + " exécute des manœuvres.");
        // Implémenter ici la logique des manœuvres
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
