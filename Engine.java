import java.util.ArrayList;

public class Engine
{
    // this allows us to type "text" instead of System.out.println over and over
    void text(Object line)
    {
        System.out.println(line);
    }

    // needed to interact with the user and populate enemies and bee's
    UserInterface user = new UserInterface();
    EnemyFactory enemyFactory = new EnemyFactory();
    RandomEvents event = new RandomEvents();
    ArrayList<BeeType> beeType = new ArrayList<BeeType>();
    Hive hive = new Hive();
    String randomEvent;

    // boolean that will trigger the end condition for the game
    boolean gameEnd = false;

    public boolean gameRun()
    {
        while(gameEnd == false)
        {
            //get attacked every 10 days
            if(hive.getDay() == 10)
            {
                text("There was a swarm of Hornets that attacked your hive!");
                randomEvent = "atk1";
            }
            else if(hive.getDay() == 20)
            {
                text("There was a swarm of YellowJackets that attacked your hive!");
                randomEvent = "atk2";
            }
            else if(hive.getDay() == 30)
            {
                text("There was a swarm of DragonFlys that attacked your hive!");
                randomEvent = "atk3";
            }
            else
            {
                randomEvent = event.getEvent();
                if(randomEvent.equals("flowers"))
                {
                    hive.setNectar(10);
                    text("The flowers are blooming today! Your bees found an extra 10 Nectar!");
                }
            }

            // Runs main interactiohn with user. value is stored for case of battle lost
            int turn = user.UI(hive, randomEvent);
            if(turn == 0)// lost battle
            {
                text("The queen is dead! GAME OVER");
                gameEnd = true;
            }
                
            //after 31 days (1 month) you win the game!
            if (hive.getDay() == 31)
            {
                gameEnd = true;
                text("You survived 31 days! You Win!");
            }
        }
        return gameEnd;
    }
}