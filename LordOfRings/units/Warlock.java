package OOP_by_Java.LordOfRings.Units;


public class Warlock extends BaseMag {
    public Warlock( String name, int x, int y ) {
        super( name, "Шаман", 120, 17, 12, 9, 5, 5 );
        super.setPos( new Point2D( x, y ) );
        super.magic = 1;
    }
}
