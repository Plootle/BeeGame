// This follows the strategy pattern
public abstract class BeeType
{

    //needed variables
    public int hp = 0;
    private boolean life = true;
    abstract public int fight();
    abstract public int work();
    public String getName() {return "";}
    protected CombatType combat;
    protected JobType work;
    public BeeType(CombatType combatType, JobType jobType){this.combat = combatType; this.work = jobType;}
    String event = "";
    
    //checks to make sure the bee is still alive
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

//creating classes for each type of Bee and how they fight/work
class Queen extends BeeType
{
    public String getName()
    {
        return "Queen";
    }
    public Queen(queenCombat combat, lazy work)
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
        return work.work(event);
    }
}

//this was taken out due to complications, but the idea is the same as the rest
class Baby extends BeeType
{
    public String getName()
    {
        return "Baby";
    }
    public Baby(babyCombat combat, lazy work)
    {
        super(combat, work);
        setHp(1);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work(event);
    }
}

class Guardian extends BeeType
{
    public String getName()
    {
        return "Guardian";
    }
    public Guardian(guardianCombat combat, helpful work)
    {
        super(combat, work);
        setHp(25);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work(event);
    }
}

class Drone extends BeeType
{
    public String getName()
    {
        return "Drone";
    }
    public Drone(droneCombat combat, efficient work)
    {
        super(combat, work);
        setHp(12);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work(event);
    }
}

class Worker extends BeeType
{
    public String getName()
    {
        return "Worker";
    }
    public Worker(workerCombat combat, helpful work)
    {
        super(combat, work);
        setHp(6);
    }
    @Override
    public int fight()
    {
        return combat.combat();
    }
    @Override
    public int work()
    {
        return work.work(event);
    }
}