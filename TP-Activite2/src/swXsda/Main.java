package swXsda;


public class Main {
    public static void main(String[] args) {
        // Test du Seigneur des Anneaux
        HumanoideLOTR elfe = new HumanoideLOTR("Legolas", 10, 10, 5, 80);
        HumanoideLOTR nain = new HumanoideLOTR("Gimli", 5, 5, 4, 70);

        Objet bijou = new Objet("Collier d'or", 100);
        ArmeUniverselle epee = new ArmeUniverselle("Épée des rois", 150, 30, elfe);
        DocumentUniversel grimoire = new DocumentUniversel("Grimoire ancien", 200, 50);

        elfe.ajouterObjet(bijou);
        elfe.ajouterObjet(epee);
        elfe.ajouterObjet(grimoire);

        elfe.donnerObjet(nain, "Collier d'or");
        elfe.prendreArme(epee);
        elfe.prendreDocument(grimoire);

        elfe.utiliserArme(epee, nain);
        System.out.println("Points de vie du nain après attaque : " + nain.getPointsVie());

        elfe.lireDocument(grimoire);
        System.out.println("Connaissances de l'elfe après lecture : " + elfe.getConnaissances());

        elfe.lireDocument(grimoire);
        System.out.println("Connaissances de l'elfe après relecture : " + elfe.getConnaissances());

        TrollLOTR troll = new TrollLOTR("Troll des montagnes", 20, 20, 3, 40, 100);
        troll.attaque(elfe);
        System.out.println("Points de vie de l'elfe après attaque du troll : " + elfe.getPointsVie());

        nain.prendreDocument(grimoire);
        nain.lireDocument(grimoire);
        System.out.println("Connaissances du nain après tentative de lecture : " + nain.getConnaissances());

        nain.prendreArme(epee);
        nain.utiliserArme(epee, elfe);
        System.out.println("Points de vie de l'elfe après tentative d'attaque du nain : " + elfe.getPointsVie());

        troll.attaque(nain);
        System.out.println("Points de vie du nain après attaque du troll : " + nain.getPointsVie());

        TrollLOTR troll2 = new TrollLOTR("Troll de la forêt", 25, 25, 3, 35, 120);
        System.out.println("Points de vie du troll2 avant attaque : " + troll2.getPointsVie());
        troll.attaque(troll2);
        System.out.println("Points de vie du troll2 après attaque : " + troll2.getPointsVie());

        // Test de Star Wars
        Personnage personnage1 = new PersonnageConcret("Luke", 0, 0, 5, 80);
        Personnage personnage2 = new PersonnageConcret("Vador", 10, 10, 5, 85);

        ArmeUniverselle arme1 = new ArmeUniverselle("Blaster", 50, 50, personnage1);
        ArmeUniverselle arme2 = new ArmeUniverselle("Sabre laser", 60, 60, personnage2);

        personnage1.setArme(arme1);
        personnage2.setArme(arme2);

        Drone drone = new Drone(100, 3, new ArmeUniverselle("Canon", 30, 30, null), 70);
        VaisseauPilote vaisseauPilote = new VaisseauPilote(100, 4, new ArmeUniverselle("Laser", 40, 40, personnage1), personnage1);

        arme1.tirer(personnage2);
        System.out.println("Points de vie de Personnage 2: " + personnage2.getPointsVie());

        drone.tirer(personnage1);
        System.out.println("Points de vie de Personnage 1: " + personnage1.getPointsVie());

        vaisseauPilote.tirer(drone);
        System.out.println("État du Drone: " + drone.getEtat());

        EtoileDeLaMort etoileDeLaMort = EtoileDeLaMort.getInstance(personnage2);
        etoileDeLaMort.tirer(vaisseauPilote);
        System.out.println("État du Vaisseau Piloté: " + vaisseauPilote.getEtat());

        drone.actionSpecifique();
        vaisseauPilote.actionSpecifique();
        etoileDeLaMort.actionSpecifique();

        ArmeUniverselle armePuissante = new ArmeUniverselle("Superlaser", 80, 80, null);
        armePuissante.tirer(drone);
        System.out.println("État du Drone après attaque puissante: " + drone.getEtat());

        armePuissante.tirer(vaisseauPilote);
        System.out.println("État du Vaisseau Piloté après attaque puissante: " + vaisseauPilote.getEtat());

        Personnage personnageSansArme = new PersonnageConcret("Leia", 5, 5, 3, 75);
        ArmeUniverselle armeNulle = new ArmeUniverselle("Pistolet-jouet", 0, 0, personnageSansArme);
        personnageSansArme.setArme(armeNulle);
        personnageSansArme.getArme().tirer(personnage1);
        System.out.println("Points de vie de Personnage 1 après attaque sans arme: " + personnage1.getPointsVie());

        for (int i = 0; i < 5; i++) {
            drone.tirer(personnage2);
            vaisseauPilote.tirer(personnage2);
        }
        System.out.println("Points de vie de Personnage 2 après plusieurs tirs: " + personnage2.getPointsVie());

        EtoileDeLaMort autreEtoileDeLaMort = EtoileDeLaMort.getInstance(personnage1);
        System.out.println("Les deux instances de l'Étoile de la Mort sont-elles identiques ? " + (etoileDeLaMort == autreEtoileDeLaMort));

        while (vaisseauPilote.getEtat() > 0) {
            etoileDeLaMort.tirer(vaisseauPilote);
        }
        System.out.println("État final du Vaisseau Piloté: " + vaisseauPilote.getEtat());
    }
}
