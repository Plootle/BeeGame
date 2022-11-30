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
                
                if(userInput == "cancel")
                {
                    UI(hive);
                }
                // run check to see if they can afford it
                if (userInput == "ok" && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands beeUpgrade = new beeUpgrade(hive);
                    beeUpgrade.option();   
                }
                else
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
                // run check to see if they can afford it
                if(userInput == "cancel")
                {
                    UI(hive);
                }
                if(userInput == "ok" && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands honeyUpgrade = new honeyUpgrade(hive);
                    honeyUpgrade.option();   
                }
                else
                {
                    UI(hive);
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
                if(userInput == "cancel")
                {
                    UI(hive);
                }
                if(userInput == "ok" && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands nectarUpgrade = new nectarUpgrade(hive);
                    nectarUpgrade.option();   
                }
                else
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
                
                if(userInput == "cancel")
                {
                    UI(hive);  
                }
                if(userInput == "ok" && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands waxUpgrade = new waxUpgrade(hive);
                    waxUpgrade.option();   
                }
                else
                {
                    UI(hive);
                }
            }
        }

        /*
         * displays the current statistics of the players hive
         */
        if (userInput == "collection")
        {
            // call the collection option and display the necessary info
            UserCommands collection = new collection(hive);
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

            if(userInput == "worker" && hive.getBeeTotal() < hive.getBeeInv())       
            {
                text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
                text("How many workers would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxWork(hive));
                int userAmount = scanner.nextInt();
                if(ut.validateMakeBee(userAmount, ut.calcMaxWork(hive)) == true)
                {
                    UserCommands workProd = new workProduce(hive, userAmount);
                    workProd.option();
                }
                else
                {
                    UI(hive);
                }
            }
            if(userInput == "drone" && hive.getBeeTotal() < hive.getBeeInv())       
            {
                text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
                text("How many drones would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxDrone(hive));
                int userAmount = scanner.nextInt();
                
                if(ut.validateMakeBee(userAmount, ut.calcMaxDrone(hive)) == true)
                {
                    UserCommands droneProd = new droneProduce(hive, userAmount);
                    droneProd.option();
                }
                else
                {
                    UI(hive);
                }
            }
            if(userInput == "guardian" && hive.getBeeTotal() < hive.getBeeInv())       
            {
                text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
                text("How many guardians would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxGuard(hive));
                int userAmount = scanner.nextInt();
                
                if(ut.validateMakeBee(userAmount, ut.calcMaxGuard(hive)) == true)
                {
                    UserCommands guardianProd = new guardianProduce(hive, userAmount);
                    guardianProd.option();
                }
                else
                {
                    UI(hive);
                }
            }
            if(userInput == "cancel")
            {
                UI(hive);
            }

            if(userInput == "honey" && hive.getAvailable() > 0 && hive.getHoney() < hive.getHonInv())
            {
                text("You have " + hive.getAvailable() + "/" + hive.getWorker() + " Worker Bees available!");
                text("How much honey would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxHoney(hive));
                int userAmount = scanner.nextInt();
                if (ut.validateMakeHoney(userAmount, ut.calcMaxHoney(hive)) == true)
                {
                    UserCommands honeyProd = new honeyProduce(hive, userAmount);
                    honeyProd.option();
                }
                else
                {
                    UI(hive);
                }
            }
            else if(userInput == "wax" && hive.getAvailable() > 0 && hive.getWax() < hive.getWaxInv())
            {
                text("You have " + hive.getAvailable() + "/" + hive.getWorker() + " Worker Bees available!");
                text("How much wax would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxWax(hive));
                int userAmount = scanner.nextInt();
                if (ut.validateMakeHoney(userAmount, ut.calcMaxHoney(hive)) == true)
                {
                    UserCommands waxProd = new waxProduce(hive, userAmount);
                    waxProd.option();
                }
                else
                {
                    UI(hive);
                }
            }
            else if(hive.getAvailable() == 0)
            {
                text("All of your Worker Bees are tired!");
            }
            else if(hive.getHoney() == hive.getHonInv() || hive.getWax() == hive.getWaxInv() || hive.getBeeTotal() == hive.getBeeInv())
            {
                text("You are at max capacity for this material!");
            } 
        }

        /*
         * this will end the round/day and have all the bee's do their daily work
         * it will also increase the day counter and allow for possible events
         */
        if (userInput == "end day")
        {
            UserCommands endDay = new endDay(hive);
            endDay.option();
        }
    }
}