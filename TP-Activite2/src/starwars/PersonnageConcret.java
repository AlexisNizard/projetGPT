package starwars;

public class PersonnageConcret extends Personnage {
    public PersonnageConcret(String n, int x, int y, int v, int precision) {
        super(n, x, y, v, precision);
    }

    @Override
    public void action() {
        // Implémenter une action spécifique au personnage
    }
}
