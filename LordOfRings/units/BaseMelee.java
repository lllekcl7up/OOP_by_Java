package OOP_by_Java.LordOfRings.Units;


import java.util.ArrayList;


public abstract class BaseMelee extends BaseHero {
    public BaseMelee(String name, String herotype, double health, int attack, int defense, int speed, int damageMin, int damageMax) {
        super(name, herotype, health, attack, defense, speed, damageMin, damageMax);
    }
    public BaseMelee(String name, String herotype, double health, int attack, int defense, int speed, int damage) {
        super(name, herotype, health, attack, defense, speed, damage);
    }


    @Override
    public void doStep( ArrayList<BaseHero> enemySide ) {
        if ( this.state == 1 ) {
            BaseHero target = enemySide.get( enemySide.size() - 1 );
            double minDistance = this.getDistance( target );

            for (int i = 1; i < enemySide.size() - 1; i++) {
                BaseHero hero = enemySide.get( i );
                if ( hero.state != -1 ) {
                    double newDistanse = this.getDistance( hero );
                    if ( newDistanse < minDistance ) {
                        minDistance = newDistanse;
                        target = hero;
                    // Решаем проблему что последний умер
                    } else if ( enemySide.get( enemySide.size() - 1 ).state == -1 ) {
                        minDistance = newDistanse;
                        target = hero;
                    }
                }
            }

            if ( target.state != -1 ) {
                if ( minDistance < 2 ) {
                    System.out.println( target + " -<- Получает урон " + getDamage( target.defense ) + " от " + this.side + ":" + this.name);
                    this.doAttack( target, getDamage( target.defense ) );
                    return;
                } else {
                    int distanceX = target.posX - this.posX;
                    int distanceY = target.posY - this.posY;
                    if ( Math.abs( distanceX ) > 1 && Math.abs( distanceY ) > 1 ) {
                        int x = distanceX / Math.abs( distanceX );
                        int y = distanceY / Math.abs( distanceY );
                        this.setPos( new Point2D( this.posX + x, this.posY + y ) );
                    } else if ( Math.abs( distanceX ) > 1 ) {
                        int x = distanceX / Math.abs( distanceX );
                        this.setPosX( this.posX + x );
                    } else {
                        int y = distanceY / Math.abs( distanceY );
                        this.setPosY( this.posY + y );
                    }
                    System.out.println( this + " -<- Переместился, на позиию " + this.getPos() );
                    return;
                }
            }
            System.out.println( "У " + this + " -<- Нет цели для атаки, на поле нет живых противников" );
        }
    }

}
