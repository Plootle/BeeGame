import java.util.ArrayList;

public class Engine
{
    // needed to interact with the user and populate enemies and bee's
    UserInterface user = new UserInterface();
    //UserCommands command = new UserCommands();
    BeeFactory beeFactory = new BeeFactory();
    EnemyFactory enemyFactory = new EnemyFactory();

    ArrayList<BeeType> beeType = new ArrayList<BeeType>();

    // counters to keep track of the day and the amount of resources
    int dayCounter = 0;
    int nectar = 0;
    int honey = 0;
    int wax = 0;
    int queenBee = 1;
    int workerBees = 0;


    // boolean that will trigger the end condition for the game
    boolean gameEnd = false;

    public boolean gameRun()
    {
        while(gameEnd == false)
        {
            user.UI(dayCounter);
            //check to see if the game is over
            for(int i = 0; i < beeType.size(); i++)
            {
                if(beeType.get(i).getName() == "Queen" && beeType.get(i).getHp() == 0)
                {
                    gameEnd = true;
                }
            }
        }
        return gameEnd;
    }
}