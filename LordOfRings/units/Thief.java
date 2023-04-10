package LordOfRings.units;

public class Thief extends Warrior {
    int disguise;

    public Thief(Position coords) {
        super(70.f, 70, 10, 2, 6, 7,
                6, coords.posX, coords.posY);
        this.disguise = 50;
    }

    @Override
    public StringBuilder getInfo() {
        StringBuilder builder = new StringBuilder();
        return builder.append("Вор: \t").append(Thief.super.name)
                .append("\t| ATK:\t").append(Thief.super.attack)
                .append("\t| HP:\t").append(Thief.super.hp)
                .append(" \t|\t\t\t|").append("\t| (X.Y) : ").append(Thief.super.coords.posX).append(".").append(Thief.super.coords.posY);
    }
}
