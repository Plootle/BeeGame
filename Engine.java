import java.util.ArrayList;

public class Engine
{
    // needed to interact with the user and populate enemies and bee's
    UserInterface user = new UserInterface();
    //UserCommands command = new UserCommands();
    //BeeFactory beeFactory = new BeeFactory();
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
                randomEvent = "atk1";
            }
            else if(hive.getDay() == 20)
            {
                randomEvent = "atk2";
            }
            else if(hive.getDay() == 30)
            {
                randomEvent = "atk3";
            }
            else
            {
                randomEvent = event.getEvent();
                if(randomEvent.equals("flowers"))
                    hive.setNectar(10);
                
            }
            user.UI(hive, randomEvent);
            //check to see if the game is over
            for(int i = 0; i < beeType.size(); i++)
            {
                if(beeType.get(i).getName() == "Queen" && beeType.get(i).getHp() == 0)
                {
                    gameEnd = true;
                }
            }
            //after 31 days (1 month) you win the game!
            if (hive.getDay() == 31)
                gameEnd = true;
        }
        return gameEnd;
    }
}