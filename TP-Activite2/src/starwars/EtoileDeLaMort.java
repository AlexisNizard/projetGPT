package starwars;

public class EtoileDeLaMort extends VaisseauPilote {
    private static EtoileDeLaMort instance;

    // Constructeur privé
    private EtoileDeLaMort(Personnage pilote) {
        super(100, 5, new Arme(1000, pilote), pilote);
    }

    // Méthode pour obtenir l'instance de l'Étoile de la Mort
    public static EtoileDeLaMort getInstance(Personnage pilote) {
        if (instance == null) {
            instance = new EtoileDeLaMort(pilote);
        }
        return instance;
    }

    // Implémentation de la méthode abstraite actionSpecifique
    @Override
    public void actionSpecifique() {
        // Logique spécifique à l'Étoile de la Mort
        // Par exemple, l'Étoile de la Mort pourrait charger son superlaser pour détruire une planète
        chargerSuperlaser();
    }

    private void chargerSuperlaser() {
        int tempsChargement = 5; // Temps de chargement du superlaser en secondes

        for (int i = tempsChargement; i > 0; i--) {
            System.out.println("Chargement du superlaser : " + i + " secondes restantes");
            try {
                Thread.sleep(1000); // Attendre une seconde
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Le superlaser est chargé et prêt à tirer !");
    }


}
