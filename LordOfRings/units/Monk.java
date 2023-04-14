package OOP_by_Java.LordOfRings.Units;


public class Monk extends BaseMelee {
    public Monk( String name, int x, int y) {
        super( name, "Монах", 120, 12, 7, 5, 8 );
        super.setPos( new Point2D( x, y ) );
    }
}
