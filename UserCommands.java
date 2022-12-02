import java.util.ArrayList;
// Here, we implement the use of a command pattern
public interface UserCommands
{
    
    public void option();
}

/*
 * Upgrades will increase capacity for the specified resource
 */
class beeUpgrade implements UserCommands
{
    Hive hive = new Hive();
    public beeUpgrade(Hive h)
    {
        this.hive = h;
    }
    @Override
    public void option()
    {
        hive.addBeeInv(20);
        hive.setWax(-10);
    }
}

class honeyUpgrade implements UserCommands
{
    Hive hive = new Hive();
    public honeyUpgrade(Hive h)
    {
        this.hive = h;
    }
    @Override
    public void option()
    {
        hive.addHonInv(100);
        hive.setWax(-10);
    }
}

class nectarUpgrade implements UserCommands
{
    Hive hive = new Hive();
    public nectarUpgrade(Hive h)
    {
        this.hive = h;
    }
    @Override
    public void option()
    {
        hive.addNecInv(100);
        hive.setWax(-10);
    }
}

class waxUpgrade implements UserCommands
{
    Hive hive = new Hive();
    public waxUpgrade(Hive h)
    {
        this.hive = h;
    }
    @Override
    public void option()
    {
        hive.addWaxInv(100);
        hive.setWax(-10);
    }
}

/*
 * Show detailed comprehension of the hive
 * - Day Count
 * - Inventory of all materials
 * - # of bees
 */
class collection implements UserCommands
{

    Hive hive = new Hive();
    public collection(Hive h)
    {
        this.hive = h;
    }
    void text(Object line)
    {
        System.out.println(line);
    }
    
    @Override
    public void option()
    {
        text("Current Day: " + hive.getDay());
        text("Total Nectar: " + hive.getNectar() + "/" + hive.getNecInv());
        text("Total Honey: " + hive.getHoney() + "/" + hive.getHonInv());
        text("Total Wax: " + hive.getWax() + "/" + hive.getWaxInv());
        text("Queen Bees: " + hive.getQueen());
        text("Worker Bees: " + hive.getWorker());
        text("Drone Bees: " + hive.getDrone());
        text("Guardian Bees: " + hive.getGuardian());
        text("Total Bees: " + hive.getBeeTotal() + "/" + hive.getBeeInv());
    }
}

/*
 * Shows user resources and prompts the production of said resources
 * (ie x nectar to make y honey)
 * it also allows the user to produce bees for x amount of honey
 */
class honeyProduce implements UserCommands
{
    Hive hive = new Hive();
    int amount;
    public honeyProduce(Hive h, int a)
    {
        this.hive = h;
        this.amount = a;
    }
    @Override
    public void option()
    {
        hive.setHoney(amount);
        hive.setNectar(amount*(-3));
        hive.setAvailable(amount * (-1));
    }
}

class waxProduce implements UserCommands
{
    Hive hive = new Hive();
    int amount;
    public waxProduce(Hive h, int a)
    {
        this.hive = h;
        this.amount = a;
    }
    @Override
    public void option()
    {
        hive.setWax(amount);
        hive.setNectar(amount * (-5));
        hive.setAvailable(amount * (-1));
    }
}

class workProduce implements UserCommands
{
    Hive hive = new Hive();
    int amount;
    public workProduce(Hive h, int a)
    {
        this.hive = h;
        this.amount = a;
    }
    @Override
    public void option()
    {
        hive.setWorker(amount);
        hive.setHoney(amount * (-1));
    }
}

class droneProduce implements UserCommands
{
    Hive hive = new Hive();
    int amount;
    public droneProduce(Hive h, int a)
    {
        this.hive = h;
        this.amount = a;
    }
    @Override
    public void option()
    {
        hive.setDrone(amount);
        hive.setHoney(amount * (-2));
    }
}

class guardianProduce implements UserCommands
{
    Hive hive = new Hive();
    int amount;
    public guardianProduce(Hive h, int a)
    {
        this.hive = h;
        this.amount = a;
    }

    @Override
    public void option()
    {
        hive.setGuardian(amount);
        hive.setHoney(amount * (-3));
    }
}

/*
 * Takes game to a new day
 * important for progressing growth of baby bees, 
 * allowing workers to start job again,
 * allows for random events
 */
class endDay implements UserCommands
{
    Hive hive = new Hive();
    String event;
    public endDay(Hive h, String e)
    {
        this.hive = h;
        this.event = e;
    }
    @Override
    public void option()
    {
        hive.resetAvailable();
        hive.addDay();
        
        if(event.equals("jazz"))
        {
            System.out.println("A BEE-utiful song plays in the village nearby. The Bee's are inspired to collect more than usual!");
        }
        if(event.equals("rainy"))
        {
            System.out.println("It is un-BEE-leavibly rainy today, making it hard to collect nectar. Nectar Collection is lower than usual today...");
        }
        // Nectar collection done automatically at the start of the day.
        for(int i = 0; i < hive.getWorker(); i++)
        {
            JobType effiJobType = new helpful();
            hive.setNectar(effiJobType.work(event)); 
        }
        for(int i = 0; i < hive.getDrone(); i++)
        {
            JobType effiJobType = new efficient();
            hive.setNectar(effiJobType.work(event)); 
        }
        for(int i = 0; i < hive.getGuardian(); i++)
        {
            JobType effiJobType = new helpful();
            hive.setNectar(effiJobType.work(event)); 
        }
        
        // If nectar collection goes above inventory capacity, sets amount to be inventory size
        if(hive.getNectar() > hive.getNecInv())
        {
            System.out.println("Capped out");
            hive.setNectarReset(hive.getNecInv());
        }
    }
}

/*
 * In case of bad event, prompts user to battle.
 */
class battle implements UserCommands
{
    Hive hive;
    ArrayList<BeeType> beeList;
    ArrayList<EnemyType> enemyList;
    public battle(Hive h, ArrayList<BeeType> bL, ArrayList<EnemyType> eL)
    {
        this.hive = h;
        this.beeList = bL;
        this.enemyList = eL;
    }
    @Override
    public void option()
    {
        //hornets       day 10
        //yellowjackets day 20
        //dragonflies   day 30
        //fight order (guardian, drones, workers, then the queen)
    }
}