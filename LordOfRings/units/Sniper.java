package OOP_by_Java.LordOfRings.Units;


public class Sniper extends BaseShoter {
    public Sniper( String name, int x, int y ) {
        super( name, "Лучник", 100, 12, 10, 9, 8, 10 );
        super.setPos( new Point2D( x, y ) );
        super.ammo = 32;
    }
}
