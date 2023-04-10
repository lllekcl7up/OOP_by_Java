package LordOfRings.units;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements GameInterfase {
    protected String name;
    protected float hp;
    protected int maxHp;
    protected int attack;
    protected int damageMin;
    protected int damageMax;
    protected int defense;
    protected int speed;
    protected Position coords;
    protected String state;
    protected static int heroCnt;

    @Override
    public String toString() {
        return name +
                " H:" + Math.round(hp) +
                " D:" + defense +
                " A:" + attack +
                " Dmg:" + Math.round(Math.abs((damageMin+damageMax)/2)) +
                " " + state;
    }

    public int[] getCoords() {return new int[]{coords.posX, coords.posY};}

    protected BaseHero(float hp, int maxHp, int attack, int damageMin,
                    int damageMax, int defense, int speed, int posX, int posY) {
        this.name = getName();
        this.hp = hp;
        this.maxHp = maxHp;
        this.attack = attack;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.defense = defense;
        this.speed = speed;
        coords = new Position(posX, posY);
        state = "Stand";
        heroCnt++;
    }

    public int getSpeed() { return speed;}
    public float getHp() { return hp;}
    @Override
    public void step(ArrayList<BaseHero> team1, ArrayList<BaseHero> team2) {}
    public int findNearest(ArrayList<BaseHero> team){
        int index = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < team.size(); i++) {
            if(min > coords.getDistance(team.get(i).coords) && !team.get(i).state.equals("Die")) {
                index = i;
                min = coords.getDistance(team.get(i).coords);
            }
        }
        return index;
    }

    protected void getDamage(float damage){
        this.hp -= damage;
        if (hp <= 0) {
            hp = 0;
            state = "Die";
        }
        if (hp > maxHp) hp = maxHp;
    }
    @Override
    public StringBuilder getInfo() {
        return new StringBuilder("");
    }

    protected String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

}
