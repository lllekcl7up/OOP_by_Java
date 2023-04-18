package com.mygdx.game.java.Units;


import com.mygdx.game.java.Pos;
import java.util.Random;

public class CrossBowman extends RangeAttackUnit {
    private final int WEAPONDAMAGE;

    public CrossBowman(String name, Pos pos) {
        super(15,15,85,name,pos,9,9,10,10,3, 9);
        this.WEAPONDAMAGE = 10;
    }

    @Override
    public void attackTarget() {
        if (new Random().nextInt(100)+1 <= this.accuracy) {
            if ((float) (this.WEAPONDAMAGE - this.targetHero.armor) / (float) this.targetHero.strength >= 0.2){
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks ♥️ of " + this.targetHero.getInfo() + this.targetHero.name);
                this.targetHero.getStrengthDamage(Math.max(this.WEAPONDAMAGE- this.targetHero.armor, 0));
            }else{
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks \uD83D\uDEE1 of " + this.targetHero.getInfo() + " " + this.targetHero.name);
                this.targetHero.getArmorDamage(this.armorBreak);
            }
        } else {
            System.out.println(this.getInfo() +this.name + " misses trying to attack "
                    +this.targetHero.getInfo()+this.targetHero.name);
        }

    }

    @Override
    public String getInfo() {
        return "Арбалетчик ";
    }

}
