package LordOfRings.units;

public class Position {
    protected int posX;
    protected int posY;

    public Position(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    protected boolean isLeft(Position oponent){
        return posX < oponent.posX;
    }

    protected double getDistance(Position oponent){
        return Math.sqrt(Math.pow(posX - oponent.posX,2) + Math.pow(posY - oponent.posY,2));
    }
}
