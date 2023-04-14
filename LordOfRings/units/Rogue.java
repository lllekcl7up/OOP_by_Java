package OOP_by_Java.LordOfRings.Units;

public class Rogue extends BaseMelee {
    public Rogue( String name, int x, int y ) {
        super( name, "Вор", 100, 12, 6, 6, 5, 18 );
        super.setPos( new Point2D( x, y ) );
    }
}
