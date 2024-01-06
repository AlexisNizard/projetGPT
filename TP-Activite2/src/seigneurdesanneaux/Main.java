package seigneurdesanneaux;

public class Main {
    public static void main(String[] args) {
        // Création d'humanoïdes
        Humanoide elfe = new Humanoide("Legolas", 10, 10, 5);
        Humanoide nain = new Humanoide("Gimli", 5, 5, 4);

        // Création d'objets, d'une arme et d'un document
        Objet bijou = new Objet("Collier d'or", 100);
        Arme epee = new Arme("Épée des rois", 150, 30);
        Document grimoire = new Document("Grimoire ancien", 200, 50);

        // Ajout d'objets dans l'inventaire de l'elfe
        elfe.ajouterObjet(bijou);
        elfe.ajouterObjet(epee);
        elfe.ajouterObjet(grimoire);

        // Transfert d'un objet de l'elfe au nain
        elfe.donnerObjet(nain, "Collier d'or");

        // L'elfe prend possession de l'épée et du grimoire
        elfe.prendreArme(epee);
        elfe.prendreDocument(grimoire);

        // L'elfe utilise l'épée contre le nain
        elfe.utiliserArme(epee, nain);
        System.out.println("Points de vie du nain après attaque : " + nain.getPointsVie());

        // L'elfe lit le grimoire
        elfe.lireDocument(grimoire);
        System.out.println("Connaissances de l'elfe après lecture : " + elfe.getConnaissances());


        // Test de la non-modification des connaissances après relecture
        elfe.lireDocument(grimoire);
        System.out.println("Connaissances de l'elfe après relecture du même grimoire : " + elfe.getConnaissances());

        // Création d'un troll
        Troll troll = new Troll("Troll des montagnes", 20, 20, 3, 40, 100);

        // Test de l'attaque du troll
        troll.attaque(elfe);
        System.out.println("Points de vie de l'elfe après attaque du troll : " + elfe.getPointsVie());
        
        // Test de la tentative de lecture d'un document par un non-propriétaire
        nain.prendreDocument(grimoire); // Le nain essaie de prendre possession du grimoire
        nain.lireDocument(grimoire); // Le nain essaie de lire le grimoire
        System.out.println("Connaissances du nain après tentative de lecture : " + nain.getConnaissances());

        // Test de la tentative d'utilisation d'une arme par un non-propriétaire
        nain.prendreArme(epee); // Le nain essaie de prendre possession de l'épée
        nain.utiliserArme(epee, elfe); // Le nain essaie d'utiliser l'épée contre l'elfe
        System.out.println("Points de vie de l'elfe après tentative d'attaque du nain : " + elfe.getPointsVie());

        // Test de la rencontre avec un troll par le nain
        troll.attaque(nain); // Le troll attaque le nain
        System.out.println("Points de vie du nain après attaque du troll : " + nain.getPointsVie());

        // Ajout d'un test pour vérifier qu'un troll n'attaque pas un autre troll
        Troll troll2 = new Troll("Troll de la forêt", 25, 25, 3, 35, 120);
        System.out.println("Points de vie du troll2 avant attaque : " + troll2.getPointsVie());
        System.out.println("Le troll2 se fait attaqué par un autre troll, cela ne doit pas fonctionner : ");
        troll.attaque(troll2); // Le premier troll essaie d'attaquer le second troll
        System.out.println("Points de vie du troll2 après attaque : " + troll2.getPointsVie());


    }
}
