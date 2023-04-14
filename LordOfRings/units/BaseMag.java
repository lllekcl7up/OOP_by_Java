package OOP_by_Java.LordOfRings.Units;


public abstract class BaseMag extends BaseHero {
    public int magic;

    public BaseMag( String name, String herotype, double health, int attack, int defense, int speed, int damageMin, int damageMax ) {
        super( name, herotype, health, attack, defense, speed, damageMin, damageMax );
        this.magic = 0;
    }


    public int getMagic() { return magic; }
    public void setMagic(int magic) { this.magic = magic; }

    @Override
    public String getInfo() {
                return  
                herotype + " " +
                "health: " + (int)super.health +
                ", attack: " + super.attack +
                ", defence: " + super.defense +
                ", speed: " + super.speed +
                ", damage: " + super.damageMin + "-" + super.damageMax +
                ", magic: " + this.magic;
    }
}
