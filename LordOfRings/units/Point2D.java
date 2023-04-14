package OOP_by_Java.LordOfRings.Units;


public class Point2D {
    public int x;
    public int y;

    // Полный конструктор
    public Point2D( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    // Конструктор без параметров
    public Point2D() {
        this( 0, 0 );
    }


    public String toString() {
        return String.format( "(%d, %d)", this.x, this.y );
    }


    public boolean isEqual( Point2D pos ) {
        if ( pos.y == this.y & pos.x == this.x ) {
            return true;
        }
        return false;
    }

    
    public double getDistance ( Point2D other ) {
        return Math.sqrt( Math.pow(this.x - other.x, 2 ) + Math.pow( this.x - other.y, 2 ) );
    }
}
