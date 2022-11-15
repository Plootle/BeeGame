import java.util.*;
//import java.io.*;

public class UserInterface
{
    String mainSelect[] = {"upgrade", "collection", "production", "end day"};
    String upgradeSelect[] = {"bees", "honey", "nectar", "wax"};   //subject to change
    String collectSelect[] = {"cancel"};
    String produceSelect[] = {"honey", "wax", "cancel"};
    String finalSelect[] = {"ok", "cancel"};
    Scanner scanner = new Scanner(System.in);
    String breaker = "******************************************";

    // this allows us to type "text" instead of System.out.println over and over
    void text(Object line)
    {
        System.out.println(line);
    }

    /*
     * Function used to compare users input to a list of valid inputs for the turn
     */
    public String validInput(String userIn, String validMoves[])
    {
        //Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < validMoves.length; i ++)
        {
            if(userIn.equals(validMoves[i]))
            {
                //scanner.close();
                return userIn;
            }
        }
        text("Please select a valid option!");
        
        userIn = scanner.nextLine();
        userIn = userIn.toLowerCase();
        
        userIn = validInput(userIn, validMoves);
        //scanner.close();
        return userIn;
    }

    // public String notEnoughResources() //compare int values?
    // {
    //     if(value 1 < value reqluired)
    //     {
    //         text("You don't have enough resources!");
    //     }
    // }

    // public String notEnoughSpace() //compare int values?
    // {
    //     if(value 1 < value reqluired)
    //     {
    //         text("You don't have enough inventory space!");
    //     }
    // }

    public void UI(int day)
    {
        text("It is day " + day + "!");
        text("What would you like to do today?");
        text(breaker);
        text("Upgrade, Collection, Production, End Day");
        text(breaker);
        String userInput = scanner.nextLine();
        validInput(userInput, mainSelect);
        
        if (userInput == "upgrade")
        {
            text("What would you like to upgrade?");
            text(breaker);
            text("Bees, Honey, Nectar, Wax"); 
            text(breaker);
            userInput = scanner.nextLine();
            validInput(userInput, upgradeSelect);
            if (userInput == "bees")
            {

                text("Bees: Capacity increases from " );//+ curHoney + " --> " + newHoney);
                text("Cost: " + "resources here");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                if(userInput == "ok")
                {
                    UserCommands beeUpgrade = new beeUpgrade();
                    beeUpgrade.option();   
                }
                if(userInput == "cancel")
                {
                    //recursion? go back to the start day?
                }
            }
            if (userInput == "honey")
            {
                text("Honey: Capacity increases from " );//+ curHoney + " --> " + newHoney);
                text("Cost: " + "resources here");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                if(userInput == "ok")
                {
                    UserCommands honeyUpgrade = new honeyUpgrade();
                    honeyUpgrade.option();   
                }
                if(userInput == "cancel")
                {
                    //recursion? go back to the start day?
                }
            }
            if (userInput == "nectar")
            {
                text("Nectar: Capacity increases from " );//+ curHoney + " --> " + newHoney);
                text("Cost: " + "resources here");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                if(userInput == "ok")
                {
                    UserCommands nectarUpgrade = new nectarUpgrade();
                    nectarUpgrade.option();   
                }
                if(userInput == "cancel")
                {
                    //recursion? go back to the start day?
                }
            }
            if (userInput == "wax")
            {
                text("Wax: Capacity increases from " );//+ curHoney + " --> " + newHoney);
                text("Cost: " + "resources here");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                if(userInput == "ok")
                {
                    UserCommands waxUpgrade = new waxUpgrade();
                    waxUpgrade.option();   
                }
                if(userInput == "cancel")
                {
                    //recursion? go back to the start day?
                }
            }
            // upgrading the queens chamber upgrades bees 
        }

        /*
         * displays the current statistics of the players hive
         */
        if (userInput == "collection")
        {
            UserCommands collection = new collection();
            collection.option();
            // the above will display everything and the below makes it so
            // the screen will not move on until the player selects cancel
            text(breaker);
            text("Cancel");
            userInput = scanner.nextLine();
            validInput(userInput, collectSelect); //get at position 1 or make a new string that just says cancel
            if(userInput == "cancel")
            {
                //recursion? go back to the start day?  
            }
        }
        
        /*
         * allows the player to convert one resource to another
         * specifically nectar into wax or honey
         */
        if (userInput == "production")
        {
            // show the current resources
            text(breaker);
            text("3 Nectar = 1 Honey");
            text("5 Nectar = 1 Wax");
            text("1 honey = 1 Worker");
            text("2 honey = 1 Drone");
            text("3 honey = 1 Guardian");
            text("What would you like more of?");
            text("Honey, Wax, Worker, Drone, Guardian, Cancel");
            text(breaker);
            userInput = scanner.nextLine();
            validInput(userInput, produceSelect);
            if(userInput == "honey")
            {
                UserCommands honeyProd = new honeyProduce();
                honeyProd.option();
            }
            if(userInput == "wax")
            {
                UserCommands waxProd = new waxProduce();
                waxProd.option();
            }
            // if(userInput == "wax")       //can we make this one beeProduce in user commands?
            // {                            //if not, we need a workerProduce, droneProduce, and guardianProduce
            //     UserCommands waxProd = new waxProduce();
            //     waxProd.option();
            // }
            if(userInput == "cancel")
            {
                //recursion? go back to the start day? 
            }
        }

        /*
         * this will end the round/day and have all the bee's do their daily work
         * it will also increase the day counter and allow for possible events
         */
        if (userInput == "end day")
        {
            UserCommands endDay = new endDay();
            endDay.option();
        }
    }
}