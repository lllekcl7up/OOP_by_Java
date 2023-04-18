package com.mygdx.game.java.Units;


import com.mygdx.game.java.Magick.Spell;
import com.mygdx.game.java.Pos;

import java.util.ArrayList;
import java.util.Comparator;


public class Monk extends SpellCaster {
    public Monk(String name, Pos pos) {
        super(20,20,name,pos,9,9,8,8,0,5);
    }

    @Override
    public String getInfo() {
        return "Монах ";
    }

    @Override
    protected void pickTarget(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        allies.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.state.equals("dead")) return 1;
                if (h1.getStrPerc()>h2.getStrPerc()) return 1;
                return -1;
            }
        });
        this.targetHero = allies.get(0);
    }

    @Override
    protected Spell selectSpell() {
        if (this.targetHero.strength==this.targetHero.maxStrength) return null;
        if (this.mana <=4 || (this.targetHero.maxStrength-this.targetHero.strength)<=3) return Spell.OmsHealing;
        else if ((this.targetHero.maxStrength-this.targetHero.strength)<=5) return Spell.DmsHealing;
        else if ((this.mana)>=7) return Spell.RealHealing;
        return Spell.DmsHealing;
    }
}
