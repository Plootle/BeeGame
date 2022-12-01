import java.util.ArrayList;

public class Battle 
{
    EnemyFactory enemyFactory = new EnemyFactory();
    public void atk1(Hive hive)
    {
        ArrayList<EnemyType> eList = new ArrayList<>();
        ArrayList<BeeType> beeList = new ArrayList<>();
        // call enemy factory, add to array
            // call all guardians and add them to the array first
            // then drones, then workers, then the queen (last in the array)
            // loop through array
                // while enemy i.isAlive
                        // bee[i] vs enemy[i]
                        //UserCommands battle = new battle(hive, beeArrayList, EnemyArrayList);

        for(int i = 0; i < 10; i++)
        {
            
            eList.add(enemyFactory.makeEnemy("hornet"));
        }

        for(int i=0; i < hive.getGuardian(); i++)
        {
            
        }
    }
}
