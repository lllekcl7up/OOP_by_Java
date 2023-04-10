package LordOfRings.units;

public class Archer extends Shooter{
    public Archer(Position coords) {
        super(60.f, 60, 10, 3, 5, 3,
                9, 22, 10, coords.posX, coords.posY);
    }

    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Лучник:\t").append(Archer.super.name)
                .append("\t| ATK:\t").append(Archer.super.attack)
                .append("\t| HP:\t").append(Archer.super.hp)
                .append(" \t| Arrows:").append(Archer.super.ammo)
                .append("\t|").append("\t| (X.Y) : ").append(Archer.super.coords.posX).append(".").append(Archer.super.coords.posY);
    }
}