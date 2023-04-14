package OOP_by_Java.LordOfRings.Units;


public class Spearman extends BaseMelee {
    public Spearman( String name, int x, int y) {
        super( name, "Копейщик", 100, 12, 9, 4, 8, 16 );
        super.setPos( new Point2D( x, y ) );
    }
}
