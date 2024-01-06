package swXsda;

import java.util.ArrayList;
import java.util.List;

public class HumanoideLOTR extends Personnage {
    private List<Objet> inventaire;

    // Constructeur
    public HumanoideLOTR(String nom, int x, int y, int vitesse, int precision) {
        super(nom, x, y, vitesse, precision);
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
    public void donnerObjet(HumanoideLOTR receveur, String nomObjet) {
        Objet objet = retirerObjet(nomObjet);
        if (objet != null) {
            receveur.ajouterObjet(objet);
        }
    }
    
    public void prendreArme(ArmeUniverselle arme) {
        if (inventaire.contains(arme)) {
            arme.setProprietaire(this);
        }
    }

    public void utiliserArme(ArmeUniverselle arme, Personnage cible) {
        if (arme.getProprietaire() == this && cible instanceof Cible) {
            arme.tirer((Cible) cible);
        }
    }

    public void prendreDocument(DocumentUniversel document) {
        if (inventaire.contains(document)) {
            document.setProprietaire(this);
        }
    }

    public void lireDocument(DocumentUniversel document) {
        if (document.getProprietaire() == this) {
            document.lire();
        }
    }

    @Override
    public void action() {
        // Implémenter une action spécifique à l'humanoïde de LOTR
    }

    @Override
    public String parler() {
        return "Je suis un humanoïde de LOTR nommé " + this.nom;
    }
}
