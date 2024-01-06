package seigneurdesanneaux;

import java.util.ArrayList;
import java.util.List;

public class Humanoide extends Personnage {
    private List<Objet> inventaire;

    // Constructeur
    public Humanoide(String nom, int x, int y, int v) {
        super(nom, x, y, v);
        this.inventaire = new ArrayList<>();
    }

    // Méthode pour ajouter un objet à l'inventaire
    public void ajouterObjet(Objet objet) {
        this.inventaire.add(objet);
    }

    // Méthode pour retirer un objet de l'inventaire
    public Objet retirerObjet(String nomObjet) {
        for (Objet objet : inventaire) {
            if (objet.getNom().equals(nomObjet)) {
                inventaire.remove(objet);
                return objet;
            }
        }
        return null;
    }

    // Méthode pour donner un objet à un autre humanoïde
    public void donnerObjet(Humanoide receveur, String nomObjet) {
        Objet objet = retirerObjet(nomObjet);
        if (objet != null) {
            receveur.ajouterObjet(objet);
        }
    }

    @Override
    public String parler() {
        return "Je suis un humanoïde nommé " + this.nom;
    }
    
    public void utiliserArme(Arme arme, Personnage cible) {
        if (arme.getProprietaire() == this) {
            arme.utiliser(cible);
        }
    }

    public void lireDocument(Document document) {
        if (document.getProprietaire() == this) {
            document.lire(this);
        }
    }
    
    public void prendreArme(Arme arme) {
        if (inventaire.contains(arme)) {
            arme.setProprietaire(this);
        }
    }

    public void prendreDocument(Document document) {
        if (inventaire.contains(document)) {
            document.setProprietaire(this);
        }
    }

}
