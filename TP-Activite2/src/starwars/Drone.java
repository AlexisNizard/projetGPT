package starwars;

public class Drone extends VaisseauSpatial {
    private int precisionIntrinseque; // Précision spécifique au drone

    // Constructeur
    public Drone(int etat, int blindage, Arme arme, int precisionIntrinseque) {
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
        // Par exemple, le drone pourrait effectuer une analyse de la zone environnante
        analyserZone();
    }

    private void analyserZone() {
        // Implémentation simplifiée de l'analyse de zone
        System.out.println("Analyse de la zone en cours par " + this.getClass().getSimpleName());

        // Simulation d'une analyse
        try {
            Thread.sleep(2000); // Pause de 2 secondes pour simuler l'analyse
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Analyse terminée par " + this.getClass().getSimpleName());
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
