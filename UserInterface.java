import java.util.*;
//import java.io.*;

public class UserInterface
{
    String mainSelect[] = {"upgrade", "collection", "production", "end day"};
    String upgradeSelect[] = {"nursery", "wax", "honey", "hospital"};
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
            // this will upgrade inventory capacity based on choice (honey, wax, nectar, bees)
            // upgrading the queens chamber upgrades bees 
            //what would you like to upgrade?
            // give options here
            UserCommands upgrade = new upgrade();
            upgrade.option();
        }
        if (userInput == "collection")
        {
            UserCommands collection = new collection();
            collection.option();
        }
        if (userInput == "production")
        {
            UserCommands production = new upgrade();
            production.option();
        }
        if (userInput == "end day")
        {
            UserCommands endDay = new upgrade();
            endDay.option();
        }
    }

}