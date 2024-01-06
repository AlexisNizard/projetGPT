package swXsda;

public class PersonnageConcret extends Personnage {
    public PersonnageConcret(String nom, int x, int y, int vitesse, int precision) {
        super(nom, x, y, vitesse, precision);
    }

    @Override
    public void action() {
        // Implémenter une action spécifique au personnage
    }

    @Override
    public String parler() {
        return "Je suis " + this.nom + ", un personnage concret.";
    }
}