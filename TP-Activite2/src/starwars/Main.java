package starwars;

public class Main {
    public static void main(String[] args) {
        // Création des personnages
        Personnage personnage1 = new PersonnageConcret("Luke", 0, 0, 5, 80);
        Personnage personnage2 = new PersonnageConcret("Vador", 10, 10, 5, 85);

        // Création des armes
        Arme arme1 = new Arme(50, personnage1);
        Arme arme2 = new Arme(60, personnage2);

        // Assigner des armes aux personnages
        personnage1.setArme(arme1);
        personnage2.setArme(arme2);

        // Création d'un drone et d'un vaisseau piloté
        Drone drone = new Drone(100, 3, new Arme(30, null), 70);
        VaisseauPilote vaisseauPilote = new VaisseauPilote(100, 4, new Arme(40, personnage1), personnage1);

        // Simuler des attaques
        System.out.println("Personnage 1 attaque Personnage 2");
        arme1.tirer(personnage2);
        System.out.println("Points de vie de Personnage 2: " + personnage2.getPointsVie());

        System.out.println("Drone attaque Personnage 1");
        drone.tirer(personnage1);
        System.out.println("Points de vie de Personnage 1: " + personnage1.getPointsVie());

        System.out.println("Vaisseau Piloté attaque Drone");
        vaisseauPilote.tirer(drone);
        System.out.println("État du Drone: " + drone.getEtat());

        // Création et utilisation de l'Étoile de la Mort
        EtoileDeLaMort etoileDeLaMort = EtoileDeLaMort.getInstance(personnage2);
        System.out.println("Étoile de la Mort attaque Vaisseau Piloté");
        etoileDeLaMort.tirer(vaisseauPilote);
        System.out.println("État du Vaisseau Piloté: " + vaisseauPilote.getEtat());

        // Démontrer l'action spécifique des vaisseaux
        drone.actionSpecifique();
        vaisseauPilote.actionSpecifique();
        etoileDeLaMort.actionSpecifique();

        // Test de la résilience des vaisseaux face à différentes puissances d'armes
        System.out.println("\nTest de la résilience des vaisseaux");
        Arme armePuissante = new Arme(80, null);
        armePuissante.tirer(drone);
        System.out.println("État du Drone après attaque puissante: " + drone.getEtat());

        armePuissante.tirer(vaisseauPilote);
        System.out.println("État du Vaisseau Piloté après attaque puissante: " + vaisseauPilote.getEtat());

        // Test avec un personnage sans arme
        System.out.println("\nTest avec un personnage sans arme");
        Personnage personnageSansArme = new PersonnageConcret("Leia", 5, 5, 3, 75);
        Arme armeNulle = new Arme(0, personnageSansArme);
        personnageSansArme.setArme(armeNulle);
        personnageSansArme.getArme().tirer(personnage1);
        System.out.println("Points de vie de Personnage 1 après attaque sans arme: " + personnage1.getPointsVie());

        // Test de précision de tir entre un Drone et un Vaisseau Piloté
        System.out.println("\nTest de précision de tir");
        for (int i = 0; i < 5; i++) {
            drone.tirer(personnage2);
            vaisseauPilote.tirer(personnage2);
        }
        System.out.println("Points de vie de Personnage 2 après plusieurs tirs: " + personnage2.getPointsVie());

        // Test de l'unicité de l'Étoile de la Mort
        System.out.println("\nTest de l'unicité de l'Étoile de la Mort");
        EtoileDeLaMort autreEtoileDeLaMort = EtoileDeLaMort.getInstance(personnage1);
        System.out.println("Les deux instances de l'Étoile de la Mort sont-elles identiques ? " + 
                           (etoileDeLaMort == autreEtoileDeLaMort));

        // Test de la destruction d'un vaisseau
        System.out.println("\nTest de la destruction d'un vaisseau");
        while (vaisseauPilote.getEtat() > 0) {
            etoileDeLaMort.tirer(vaisseauPilote);
        }
        System.out.println("État final du Vaisseau Piloté: " + vaisseauPilote.getEtat());
    }
}
