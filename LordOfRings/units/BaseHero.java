package OOP_by_Java.LordOfRings.Units;


import java.util.ArrayList;


public abstract class BaseHero implements BaseHeroInterfase, Comparable<BaseHero> {
    public String name;
    public String herotype;

    public double health;
	protected int healthMax;

    protected int attack;
    protected int defense;
    public int speed;

    protected int damageMin;
    protected int damageMax;

    public int posX;
    public int posY;

    public String side;
    protected int state;


    // Полный конструктор
    public BaseHero( String name, String herotype, double health, int attack, int defense, int speed, int damageMin, int damageMax ) {
        this.name = name;
        this.herotype = herotype;
        this.health = health;
        this.healthMax = (int)health;

        this.attack = attack;
        this.defense = defense;
        this.speed = speed;

        this.damageMin = damageMin;
        this.damageMax = damageMax;

        this.side = "";
        this.state = 1;
    }

    // Полный конструктор, без разброса в уроне
    public BaseHero( String name, String herotype, double health, int attack, int defense, int speed, int damage ) {
        this( name, herotype, health, attack, defense, speed, damage, damage );
    }


    // Геттеры, для изменения значений приватных полей
    public String getName  () { return this.name;      }
    public double getHealth() { return this.health;    }
    public int getHealthMax() { return this.healthMax; }
    public int getAttack   () { return this.attack;    }
    public int getDefense  () { return this.defense;   }
    public int getSpeed    () { return this.speed;     }
    public int getDamageMin() { return this.damageMin; }
    public int getDamageMax() { return this.damageMax; }
    public int getPosX     () { return this.posX;      }
    public int getPosY     () { return this.posY;      }
    public int getState    () { return this.state;     }
    public Point2D getPos  () { return new Point2D(posX, posY); }


    // Сеттеры, для получения значений приватных полей
    public void setName     ( String name   ) { this.name      = name;      }
    public void setHealth   ( double health ) { this.health    = health;    }
    public void setAttack   ( int attack    ) { this.attack    = attack;    }
    public void setDefense  ( int defense   ) { this.defense   = defense;   }
    public void setSpeed    ( int speed     ) { this.speed     = speed;     }
    public void setDamageMin( int damageMin ) { this.damageMin = damageMin; }
    public void setDamageMax( int damageMax ) { this.damageMax = damageMax; }
    public void setState    ( int state     ) { this.state     = state;     }

    // Сеттеры, для позиционирования
    public void setPos      ( Point2D pos ) { this.posX = pos.x; this.posY = pos.y; }
    public void setPosX     ( int posX    ) { setPos( new Point2D( posX, this.posY ) ); }
    public void setPosY     ( int posY    ) { setPos( new Point2D( this.posX, posY ) ); }

    public String getInfo() {
        return herotype + " " +
                "health: " + (int)this.health +
                ", attack: " + this.attack +
                ", defence: " + this.defense +
                ", speed: " + this.speed +
                ", damage: " + this.damageMin + "-" + this.damageMax ;
    }


    protected double getDistance ( BaseHero hero ) {
        return Math.sqrt( Math.pow( hero.posX - this.posX, 2 ) + Math.pow( hero.posY - this.posY, 2 ) );
    }

    // Рассчитываем урон по цели, минимальный урон == 1
    public double getDamage( int heroDefense ) {
        double damage = heroDefense - this.attack - ( ( damageMin + damageMax ) / 2 );
        if ( damage < 0 )
            return damage * -1;
        return 1;
    }

    // Действие Атака
    public void doAttack( BaseHero hero, double damage ) {
        System.out.println( hero + " получает урон " + getDamage( hero.defense ) + " от " + this.side + ":" + this.name);
        hero.doDamage( damage );
    }

    // Получаем урон 
    public void doDamage( double damage ) {
        setHealth( getHealth() - damage );
        if ( getHealth() <= 0 ) {
            setHealth( 0 );
            setState ( -1 );
            System.out.println( this + " персонаж погиб\n" );
        } else
            System.out.println( this + "\n" );
    }

    @Override
    public void doStep( ArrayList<BaseHero> enemySide ) {
        if ( this.state == 1 ) {
            for( BaseHero hero: enemySide ) {
                if ( hero.health > 0 ) {
                    System.out.println( hero + " -<- Получает урон " + getDamage( hero.defense ) + " от " + this.side + ":" + this.name);
                    this.doAttack( hero, getDamage( hero.defense ) );
                    return;
                }
            }
            System.out.println( "У " + this + " -<- Нет цели для атаки" );
        }
    }

    // Вывод всех полей в строковом виде
    public String toString() {
      
        return String.format( "%s:%s: health: %.1f/%d ♥, %s, attack: %d ⚔, defense: %d ✊, speed: %d, damage: %d-%d ☠, pos: %s, state: %s",
            this.side,
            this.name,

            this.health,
            this.healthMax,

            this.herotype,

            this.attack,
            this.defense,
            this.speed,

            this.damageMin,
            this.damageMax,

            this.getPos(),

            this.state );
    }

    // Сотировка по убыванию скорости
    @Override
    public int compareTo( BaseHero hero ) {
        // return Integer.compare( this.speed, hero.speed );
        if ( this.speed < hero.speed )
            return 1;
        else if ( this.speed > hero.speed )
            return -1;
        else
            return 0;
    }
}