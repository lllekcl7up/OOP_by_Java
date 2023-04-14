package OOP_by_Java.LordOfRings.Units;

public class Crossbowman extends BaseShoter {
    public Crossbowman( String name, int x, int y ) {
        super( name, "Арбалетчик", 100, 12, 5, 4, 5, 15 );
        super.setPos( new Point2D( x, y ) );
        super.ammo = 16;
    }
}
