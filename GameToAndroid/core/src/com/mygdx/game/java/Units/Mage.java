package com.mygdx.game.java.Units;



import com.mygdx.game.java.Magick.Spell;
import com.mygdx.game.java.Pos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Mage extends SpellCaster {
    public Mage(String name, Pos pos) {

        super(20,20,name,pos,7,7,7,7,0, 6);
    }

    @Override
    public String getInfo() {
        return "Маг ";
    }

    @Override
    protected void pickTarget(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        this.targetHero = this.nearestAliveEnemy(enemies);
    }

    @Override
    protected Spell selectSpell() {
        if (this.targetHero.strength<=3 || this.mana<=4) return Spell.MagickArrow;
        else if (this.targetHero.strength<=5) return Spell.FireBall;
        else if (this.mana>=7) return Spell.Lightning;
        else return Spell.FireBall;
    }

}
