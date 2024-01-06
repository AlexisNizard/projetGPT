package com.alexis;

public class AVLTree {

    private static class Noeud {
        int valeur;
        Noeud gauche;
        Noeud droite;
        int hauteur;

        public Noeud(int val) {
            this.valeur = val;
            this.gauche = null;
            this.droite = null;
            this.hauteur = 1;
        }
    }

    private int hauteur(Noeud N) {
        if (N == null) return 0;
        return N.hauteur;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Noeud faireSimpleRotationADroite(Noeud y) {
        Noeud x = y.gauche;
        Noeud T2 = x.droite;

        // Effectuer la rotation
        x.droite = y;
        y.gauche = T2;

        // Mettre à jour les hauteurs
        y.hauteur = max(hauteur(y.gauche), hauteur(y.droite)) + 1;
        x.hauteur = max(hauteur(x.gauche), hauteur(x.droite)) + 1;

        return x;
    }

    private Noeud faireSimpleRotationAGauche(Noeud x) {
        Noeud y = x.droite;
        Noeud T2 = y.gauche;

        // Effectuer la rotation
        y.gauche = x;
        x.droite = T2;

        // Mettre à jour les hauteurs
        x.hauteur = max(hauteur(x.gauche), hauteur(x.droite)) + 1;
        y.hauteur = max(hauteur(y.gauche), hauteur(y.droite)) + 1;

        return y;
    }

    private Noeud faireDoubleRotationADroite(Noeud z) {
        z.gauche = faireSimpleRotationAGauche(z.gauche);
        return faireSimpleRotationADroite(z);
    }

    private Noeud faireDoubleRotationAGauche(Noeud z) {
        z.droite = faireSimpleRotationADroite(z.droite);
        return faireSimpleRotationAGauche(z);
    }

    private Noeud equilibrerArbre(Noeud racine, int valeur) {
        int equilibre = hauteur(racine.gauche) - hauteur(racine.droite);

        // Rotation à droite simple
        if (equilibre > 1 && valeur < racine.gauche.valeur)
            return faireSimpleRotationADroite(racine);

        // Rotation à gauche simple
        if (equilibre < -1 && valeur > racine.droite.valeur)
            return faireSimpleRotationAGauche(racine);

        // Rotation à droite double
        if (equilibre > 1 && valeur > racine.gauche.valeur) {
            racine.gauche = faireSimpleRotationAGauche(racine.gauche);
            return faireSimpleRotationADroite(racine);
        }

        // Rotation à gauche double
        if (equilibre < -1 && valeur < racine.droite.valeur) {
            racine.droite = faireSimpleRotationADroite(racine.droite);
            return faireSimpleRotationAGauche(racine);
        }

        return racine;
    }

    public Noeud inserer(Noeud racine, int valeur) {
        if (racine == null)
            return new Noeud(valeur);

        if (valeur < racine.valeur)
            racine.gauche = inserer(racine.gauche, valeur);
        else if (valeur > racine.valeur)
            racine.droite = inserer(racine.droite, valeur);
        else
            return racine;

        racine.hauteur = 1 + max(hauteur(racine.gauche), hauteur(racine.droite));

        return equilibrerArbre(racine, valeur);
    }


    private Noeud trouverSuccesseur(Noeud racine) {
        Noeud courant = racine;
        while (courant.gauche != null)
            courant = courant.gauche;
        return courant;
    }

    public Noeud supprimer(Noeud racine, int valeur) {
        if (racine == null)
            return racine;

        if (valeur < racine.valeur)
            racine.gauche = supprimer(racine.gauche, valeur);
        else if (valeur > racine.valeur)
            racine.droite = supprimer(racine.droite, valeur);
        else {
            if (racine.gauche == null || racine.droite == null) {
                Noeud temp = (racine.gauche != null) ? racine.gauche : racine.droite;

                if (temp == null) {
                    temp = racine;
                    racine = null;
                } else {
                    racine = temp;
                }
            } else {
                Noeud temp = trouverSuccesseur(racine.droite);
                racine.valeur = temp.valeur;
                racine.droite = supprimer(racine.droite, temp.valeur);
            }
        }

        if (racine == null)
            return racine;

        racine.hauteur = 1 + max(hauteur(racine.gauche), hauteur(racine.droite));

        return equilibrerArbre(racine, valeur);
    }


    private void afficherArbre(Noeud racine, int espace) {
        if (racine == null) return;
        espace += 10;
        afficherArbre(racine.droite, espace);
        System.out.println();
        for (int i = 10; i < espace; i++) System.out.print(" ");
        System.out.println(racine.valeur);
        afficherArbre(racine.gauche, espace);
    }

    public static void main(String[] args) {
        AVLTree arbre = new AVLTree();
        Noeud racine = null;

        // Test de l'insertion
        racine = arbre.inserer(racine, 10);
        racine = arbre.inserer(racine, 20);
        racine = arbre.inserer(racine, 30);
        racine = arbre.inserer(racine, 40);
        racine = arbre.inserer(racine, 50);
        racine = arbre.inserer(racine, 25);

        System.out.println("Arbre AVL après les insertions :");
        arbre.afficherArbre(racine, 0);

        // Test de la suppression
        racine = arbre.supprimer(racine, 20);

        System.out.println("\nArbre AVL après la suppression de 20 :");
        arbre.afficherArbre(racine, 0);
    }

}

