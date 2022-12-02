import java.util.ArrayList;

public class Battle 
{
    EnemyFactory enemyFactory = new EnemyFactory();
    BeeFactory beeFactory = new BeeFactory();
    
    /* Call to factory to initializ Bees for fight.
     * Sets up array of bees for any of the battles
     * The order is also specific as we always want guardians fighting first and queen last
     */ 
    public ArrayList<BeeType> soldiers(Hive hive)
    {
        ArrayList<BeeType> beeList = new ArrayList<>();

        // Collects all guardians
        for(int i = 0; i < hive.getGuardian(); i++)
        {
            beeList.add(beeFactory.makeBees("guardian"));
        }

        // Collects all drones
        for(int i = 0; i < hive.getDrone(); i++)
        {
            beeList.add(beeFactory.makeBees("drone"));
        }

        // Collects workers
        for(int i = 0; i < hive.getWorker(); i++)
        {
            beeList.add(beeFactory.makeBees("worker"));
        }

        // Queen is always last resort in battle
        beeList.add(beeFactory.makeBees("queen"));

        return beeList;
    }

    /*
     * Main logic for any battle, where its a one on one battle until a unit dies.
     * 
     */
    public int takeBattle(ArrayList<EnemyType> eList, ArrayList<BeeType> beeList, Hive hive)
    {
        System.out.println("Bee Army count: " + beeList.size() + " Enemy Army count: " + eList.size());
        while (beeList.size() > 0 || eList.size() > 0)
        {
            // Gets 1 unit for each side and their combat rolls
            BeeType bee = beeList.get(0);
            EnemyType enemy = eList.get(0);
            int beeRoll = bee.fight();
            int enemyRoll = enemy.fight();
            
            // Bees get to hit first
            // Damage immedietly applied
            enemy.setHp(enemy.getHp() - beeRoll);
            
            // If enemy dies, we want to remove them from enemy list
            if(enemy.isAlive() == false)
            {
                System.out.println(enemy.getName() + " has died");
                // if the last enemy dies, we can immedietly return
                if(eList.size() ==1)    
                    return 1;
                // update enemy list
                eList.remove(0); 
            }

            // Enemy turn, immedietly updates health
            bee.setHp(bee.getHp() - enemyRoll);
            
            // Removing the correct bees from the array list
            if(bee.isAlive() == false)
            {
                System.out.println(bee.getName() + " has died");
                if(bee.getName().equals("Guardian"))
                    hive.setGuardian(-1); 
                else if(bee.getName().equals("Drone"))
                    hive.setDrone(-1);
                else if(bee.getName().equals("Worker"))
                    hive.setWorker(-1);
                else if(bee.getName().equals("Queen"))
                    return 0;    
                beeList.remove(0);
            }
        }
        return 1;
    }

    //these are the preset attacks that will occure every 10 days or as an event
    public int atk(Hive hive)
    {
        ArrayList<EnemyType> eList = new ArrayList<>();
        ArrayList<BeeType> beeList = soldiers(hive);
        
        //populate the arraylist that the bees need to fight
        for(int i = 0; i < 3; i++)
        {
            eList.add(enemyFactory.makeEnemy("hornet"));
        }
        
        return takeBattle(eList, beeList, hive);
    }

    public int atk1(Hive hive)
    {
        ArrayList<EnemyType> eList = new ArrayList<>();
        ArrayList<BeeType> beeList = soldiers(hive);

        //populate the arraylist that the bees need to fight
        for(int i = 0; i < 10; i++)
        {
            eList.add(enemyFactory.makeEnemy("hornet"));
        }
        
        return takeBattle(eList, beeList, hive);
    }

    public int atk2(Hive hive)
    {
        ArrayList<EnemyType> eList = new ArrayList<>();
        ArrayList<BeeType> beeList = soldiers(hive);
        
        //populate the arraylist that the bees need to fight
        for(int i = 0; i < 10; i++)
        {
            eList.add(enemyFactory.makeEnemy("yellowjacket"));
        }
        
        return takeBattle(eList, beeList, hive);
    }

    public int atk3(Hive hive)
    {
        ArrayList<EnemyType> eList = new ArrayList<>();
        ArrayList<BeeType> beeList = soldiers(hive);
        
        //populate the arraylist that the bees need to fight
        for(int i = 0; i < 10; i++)
        {
            eList.add(enemyFactory.makeEnemy("dragonfly"));
        }
        return takeBattle(eList, beeList, hive);
    }
}