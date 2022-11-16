import java.util.*;
//import java.io.*;

public class UserInterface
{
    String mainSelect[] = {"upgrade", "collection", "production", "end day"};
    String upgradeSelect[] = {"bees", "honey", "nectar", "wax"};   //subject to change
    String collectSelect[] = {"cancel"};
    String produceSelect[] = {"honey", "wax", "worker", "drone", "guardian", "cancel"};
    String finalSelect[] = {"ok", "cancel"};
    Scanner scanner = new Scanner(System.in);
    String breaker = "******************************************";
    UpgradeType ut = new UpgradeType();
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

    public void UI(Hive hive)
    {
        int day = hive.getDay();
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
                text("Bees: Capacity increases from " + hive.getBeeInv() + " --> " + hive.getBeeInv() + 20);
                text("Cost: 25 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                
                if (ut.validateInvUpgrade(hive) == true)
                {
                    if(userInput == "ok")
                    {
                        UserCommands beeUpgrade = new beeUpgrade();
                        beeUpgrade.option();   
                    }
                }
                else
                {
                    UI(hive);
                }
                    
                if(userInput == "cancel")
                {
                    UI(hive);
                }
            }
            if (userInput == "honey")
            {
                text("Honey: Capacity increases from " + hive.getHonInv() + " --> " + hive.getHonInv() + 100);
                text("Cost: 25 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                if(ut.validateInvUpgrade(hive) == true)
                {
                    // run check to see if they can afford it
                    if(userInput == "ok")
                    {
                        UserCommands honeyUpgrade = new honeyUpgrade();
                        honeyUpgrade.option();   
                    }
                    if(userInput == "cancel")
                    {
                        UI(hive);
                    }
                }
                
            }
            if (userInput == "nectar")
            {
                text("Nectar: Capacity increases from " + hive.getNecInv() + " --> " + hive.getNecInv() + 100);
                text("Cost: 25 Wax");
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
                    UI(hive);
                }
            }
            if (userInput == "wax")
            {
                text("Wax: Capacity increases from " + hive.getWaxInv() + " --> " + hive.getWaxInv() + 100);
                text("Cost: 25 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                //make sure they have the resources
                if(userInput == "ok")
                {
                    UserCommands waxUpgrade = new waxUpgrade();
                    waxUpgrade.option();   
                }
                if(userInput == "cancel")
                {
                    UI(hive);
                }
            }
            if(userInput == "cancel")
            {
                UI(hive);  
            }
        }

        /*
         * displays the current statistics of the players hive
         */
        if (userInput == "collection")
        {
            // call the collection option and display the necessary info
            UserCommands collection = new collection();
            collection.option();
            text(breaker);
            text("Cancel");
            userInput = scanner.nextLine();
            validInput(userInput, collectSelect);
            
            // allows the player to look at the info until they type cancel
            if(userInput == "cancel")
            {
                UI(hive);  
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
            if(userInput == "worker")       
            {
                UserCommands workProd = new workProduce();
                workProd.option();
            }
            if(userInput == "drone")       
            {
                UserCommands droneProd = new droneProduce();
                droneProd.option();
            }
            if(userInput == "guardian")       
            {
                UserCommands guardianProd = new guardianProduce();
                guardianProd.option();
            }
            if(userInput == "cancel")
            {
                UI(hive);
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