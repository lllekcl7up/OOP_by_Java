package com.mygdx.game.java.Units;


import com.mygdx.game.java.Pos;

import java.util.ArrayList;
import java.util.Random;

public class Sniper extends RangeAttackUnit {

    public Sniper(String name, Pos pos) {
        super(10, 10, 70, name, pos, 13, 13, 8, 8, 4, 9);
    }

    @Override
    public void attackTarget() {
        if (new Random().nextInt(100)+1 <= this.accuracy) {
            if ((float) (this.strength - this.targetHero.armor) / (float) this.targetHero.strength >= 0.2){
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks ♥️ of " + this.targetHero.getInfo() + this.targetHero.name);
                this.targetHero.getStrengthDamage(Math.max(this.strength - this.targetHero.armor, 0));
            }else{
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks \uD83D\uDEE1 of " + this.targetHero.getInfo() + this.targetHero.name);
                this.targetHero.getArmorDamage(this.armorBreak);
            }
        } else {
            System.out.println(this.getInfo() + this.name + " misses "+
                    "trying to attack "+this.targetHero.getInfo()+" "+this.targetHero.name);
        }

    }

    @Override
    public String getInfo() {
        return "Снайпер ";
    }
}
