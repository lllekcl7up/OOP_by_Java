package OOP_by_Java.LordOfRings.Units;


public class Peasant extends BaseMelee {
    public Peasant( String name, int x, int y) {
        super( name, "Фермер", 70, 2, 1, 3, 2 );
        super.setPos( new Point2D( x, y ) );
    }
}
