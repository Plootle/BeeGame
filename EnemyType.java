// This follows the strategy pattern
public abstract class EnemyType
{
    public int hp = 0;
    private boolean life = true;
    abstract public int fight();
    public String getName() {return "";};
    protected CombatType combat;
    public EnemyType(CombatType combatType){this.combat = combatType;}

    //checks to make sure the enemy is still alive
    public Boolean isAlive()
    {
        if(hp <= 0) 
        {
            life = false;
        }
        return life;
    }

    public void isDead()
    {
        life = false;
    }

    //returns the current hp of the enemy
    public int getHp()
    {
        return hp;
    }

    //updates the enemies health
    public void setHp(int newHp)
    {
        hp = newHp;
        isAlive();
    }
}
//creating classes for each type of Enemy and how they fight
class Hornet extends EnemyType
{
    public String getName()
    {
        return "Hornet";
    }
    public Hornet(hornetCombat combat)
    {
        super(combat);
        setHp(6);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
}

class YellowJacket extends EnemyType
{
    public String getName()
    {
        return "YellowJacket";
    }
    public YellowJacket(yellowjacketCombat combat)
    {
        super(combat);
        setHp(12);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
}

class DragonFly extends EnemyType
{
    public String getName()
    {
        return "DragonFly";
    }
    public DragonFly(dragonflyCombat combat)
    {
        super(combat);
        setHp(25);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
}