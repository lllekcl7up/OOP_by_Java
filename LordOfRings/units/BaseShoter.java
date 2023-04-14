package OOP_by_Java.LordOfRings.Units;


import java.util.ArrayList;


public abstract class BaseShoter extends BaseHero {
    public int ammo;

    public BaseShoter( String name, String herotype, double health, int attack, int defense, int speed, int damageMin, int damageMax ) {
        super( name, herotype, health, attack, defense, speed, damageMin, damageMax );
        this.ammo = 0;
    }

    public int getAmmo() { return ammo; }
    public void setAmmo(int ammo) { this.ammo = ammo; }

    @Override
    public String getInfo() {
        return  herotype + " " +
        "health: " + (int)super.health +
                ", attack: " + super.attack +
                ", defence: " + super.defense +
                ", speed: " + super.speed +
                ", damage: " + super.damageMin + "-" + super.damageMax +
                ", ammo: " + this.ammo;
    }


    @Override
    public void doStep( ArrayList<BaseHero> enemySide ) {
        if ( this.state == 1 ) {
            if ( this.ammo > 0 ) {
                for( BaseHero hero: enemySide ) {
                    if ( hero.state != -1 ) {
                        if ( this.getDistance( hero ) <= 5 ) { // 5 - Должно зависеть от типа юнита...
                            this.doAttack( hero, getDamage( hero.defense ) );
                            this.ammo--;
                            return;
                        } else { // Здесь должна быть более сложная логика
                            // TODO: Повторно проверить и найти противника на минимальном расстоянии
                            this.doAttack( hero, getDamage( hero.defense ) );
                            this.ammo--;
                            return;
                        }

                    }

                }
                System.out.println( "У " + this + " Нет цели для атаки" );
            }
        }
    }
}
