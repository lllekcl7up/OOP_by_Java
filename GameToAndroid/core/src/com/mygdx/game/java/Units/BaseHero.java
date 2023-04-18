package com.mygdx.game.java.Units;

import com.mygdx.game.java.Pos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public abstract class BaseHero implements GameInterface {
    public String name;
    public String state;

    public Pos pos;
    protected int strength, maxStrength;
    protected int armor, maxArmor;
    protected int armorBreak;
    protected BaseHero targetHero;

    public int initiative;

    public BaseHero(String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak, int initiative) {
        this.name = name;
        this.state = "ready";
        this.pos = pos;
        this.strength = strength;
        this.maxStrength = maxStrength;
        this.armor = armor;
        this.maxArmor = maxArmor;
        this.armorBreak = armorBreak;
        this.targetHero = null;
        this.initiative = initiative;
    }

    protected void Die() {
        System.out.println(this.getInfo()+this.name+" dies a horrible death...");
        this.state = "dead";
    }

    protected void getStrengthDamage(int dmg) {
        if (dmg<0) {
            System.out.println(this.getInfo()+this.name+" restores "+Math.min(-dmg, this.maxStrength-this.strength)+" ♥️ ");
            this.strength += Math.min(-dmg, this.maxStrength-this.strength);

        }else {

            System.out.println(this.getInfo() + this.name + " gets " + Math.min(dmg, this.strength) + " ♥️ dmg");
            this.strength -= Math.min(dmg, this.strength);
            if (strength == 0) this.Die();
        }
    }

    protected void getArmorDamage(int armorDmg) {
        System.out.println(this.getInfo()+this.name+" gets "+Math.min(armorDmg, this.armor)+" \uD83D\uDEE1 dmg");
        this.armor -= Math.min(armorDmg, this.armor);
    }

    protected void getHealing(int healPoints) {
        this.strength += Math.min(healPoints, this.maxStrength - this.strength);
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        if (this.state.equals("dead")) System.out.println(this.getInfo()+" "+this.name+" is very very dead...");
    }

    @Override
    public String toString() {
        return this.getStateSymbol()+" "+this.getInfo()+this.name+
                " \uD83C\uDFAF"+this.pos.toString()+
                " \uD83C\uDF1F:"+this.initiative+
                " ♥️:"+this.strength+"("+this.maxStrength+")"+
                " \uD83D\uDEE1"+this.armor+"("+this.maxArmor+")";

    }

    public BaseHero nearestAliveEnemy(ArrayList<BaseHero> enemies){
        PriorityQueue<BaseHero> aliveEnemies = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.state.equals("dead")) return 1;
                if (h2.state.equals("dead")) return -1;
                if (pos.distanceFrom(h1.pos)>pos.distanceFrom(h2.pos)) return 1;
                return  -1;
            }
        });
        aliveEnemies.addAll(enemies);
        return aliveEnemies.poll();
    }
    public float getStrPerc(){
        return (float)this.strength/(float)this.maxStrength;
    }
    private String getStateSymbol(){
        switch (this.state){
            case "dead": return "☠️";
            case "ready": return "\uD83D\uDC40";
            case "busy": return "⏱️";
            default: return this.state;
        }
    }
}
