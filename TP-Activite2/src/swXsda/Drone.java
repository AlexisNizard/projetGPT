package swXsda;

public class Drone extends VaisseauSpatial {
    private int precisionIntrinseque; // Précision spécifique au drone

    // Constructeur
    public Drone(int etat, int blindage, ArmeUniverselle arme, int precisionIntrinseque) {
        super(etat, blindage, arme);
        this.precisionIntrinseque = precisionIntrinseque;
    }

    // Getter pour la précision intrinsèque
    public int getPrecisionIntrinseque() {
        return precisionIntrinseque;
    }

    // Setter pour la précision intrinsèque
    public void setPrecisionIntrinseque(int precisionIntrinseque) {
        this.precisionIntrinseque = precisionIntrinseque;
    }

    // Implémentation de la méthode abstraite actionSpecifique
    @Override
    public void actionSpecifique() {
        // Logique spécifique au drone
        analyserZone();
    }

    private void analyserZone() {
        // Logique de l'analyse de zone par le drone
        System.out.println("Le drone " + this.getClass().getSimpleName() + " analyse la zone.");
        // Implémenter ici la logique d'analyse de zone
    }

    // Surcharge de la méthode tirer pour utiliser la précision intrinsèque du drone
    @Override
    public void tirer(Cible cible) {
        if (this.arme != null && this.etat > 0) {
            if (new java.util.Random().nextInt(100) < precisionIntrinseque) {
                this.arme.tirer(cible);
            }
        }
    }
}
