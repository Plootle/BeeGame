import java.util.Random;

public abstract class BeeType
{
    public int hp = 0;
    private boolean life = true;
    abstract public int fight();
    abstract public int work();
    public String getName() {return "";}
    Random rn = new Random();
    protected CombatType combat;
    protected JobType work;
    public BeeType(CombatType combatType, JobType jobType){this.combat = combatType; this.work = jobType;}
    
    //checks to make sure the bee is still alive
    public Boolean isAlive()
    {
        if(hp == 0) 
        {
            life = false;
        }
        return life;
    }

    public void isDead()
    {
        life = false;
    }

    //returns the current hp of the bee
    public int getHp()
    {
        return hp;
    }

    //updates the bee's health
    public void setHp(int newHp)
    {
        hp = newHp;
        isAlive();
    }
}

class Queen extends BeeType
{
    public String getName()
    {
        return "Queen";
    }
    public Queen(queen combat, lazy work)
    {
        super(combat, work);
        setHp(100);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work();
    }
}

class Baby extends BeeType
{
    public String getName()
    {
        return "Baby";
    }
    public Baby(baby combat, lazy work)
    {
        super(combat, work);
        setHp(100);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work();
    }
}

class Guardian extends BeeType
{
    public String getName()
    {
        return "Guardian";
    }
    public Guardian(guardian combat, helpful work)
    {
        super(combat, work);
        setHp(100);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work();
    }
}

class Drone extends BeeType
{
    public String getName()
    {
        return "Drone";
    }
    public Drone(drone combat, efficient work)
    {
        super(combat, work);
        setHp(100);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work();
    }
}

class Worker extends BeeType
{
    public String getName()
    {
        return "Worker";
    }
    public Worker(worker combat, helpful work)
    {
        super(combat, work);
        setHp(100);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work();
    }
}