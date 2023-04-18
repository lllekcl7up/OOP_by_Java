package com.mygdx.game.java.Units;


import com.mygdx.game.java.Magick.Spell;
import com.mygdx.game.java.Pos;

import java.util.ArrayList;

public abstract class SpellCaster extends BaseHero {
    protected int mana;
    protected  int maxMana;

    public SpellCaster(int mana, int maxMana, String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak, int initiative) {
        super(name, pos, strength, maxStrength, armor, maxArmor, armorBreak, initiative);
        this.mana = mana;
        this.maxMana = maxMana;
    }
    protected void castSpell(Spell spell){
        if (spell==null) {
            System.out.println(this.getInfo()+this.name+" can't do anything useful...");
            return;
        }
        System.out.println(this.getInfo()+this.name+" casts "+spell.name+" on "
                +this.targetHero.getInfo()+this.targetHero.name);
        this.mana -= spell.manaCost;
        this.targetHero.getStrengthDamage(spell.spellPower);
    }
    protected abstract Spell selectSpell();
    protected abstract void pickTarget(ArrayList<BaseHero> enemies,ArrayList<BaseHero> allies);

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.turn(enemies, allies);
        if (this.state.equals("dead")) return;
        if (this.mana<3) {
            System.out.println(this.getInfo()+this.name+" hasn't got enough mana to cast anything..." );
            return;
        }
        this.pickTarget(enemies, allies);
        this.castSpell(this.selectSpell());
    }
    @Override
    public String toString() {
        return super.toString()+" \uD83E\uDE84"+this.mana+"("+this.maxMana+")";
    }
}
