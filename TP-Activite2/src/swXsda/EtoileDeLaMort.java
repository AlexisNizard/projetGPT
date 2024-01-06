package swXsda;

public class EtoileDeLaMort extends VaisseauPilote {
    private static EtoileDeLaMort instance;

    // Constructeur privé
    public EtoileDeLaMort(Personnage pilote) {
        super(100, 5, new ArmeUniverselle("Nom de l'arme", 0, 1000, pilote), pilote);
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
        chargerSuperlaser();
    }

    private void chargerSuperlaser() {
        // Logique de chargement du superlaser
        System.out.println("Chargement du superlaser en cours...");
        // Implémenter ici la logique de chargement
    }
}
