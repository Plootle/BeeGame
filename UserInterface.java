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
        userIn = userIn.toLowerCase();
        //Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < validMoves.length; i++)
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

    public void UI(Hive hive, String event)
    {
        Battle battle = new Battle();
        if(event.equals("atk"))
        {
            // UserCommands battle = new battle(hive);
            // battle.option();
        }
        if(event.equals("atk1"))
        {
            battle.atk1(hive);
            
        }
        if(event.equals("atk2"))
        {
            
        }
        if(event.equals("atk3"))
        {
            
        }
        int day = hive.getDay();
        text("It is day " + day + "!");
        text("What would you like to do today?");
        text(breaker);
        text("Upgrade, Collection, Production, End Day");
        text(breaker);
        String userInput = scanner.nextLine();
        validInput(userInput, mainSelect);
        
        if (userInput.equals("upgrade"))
        {
            text("What would you like to upgrade?");
            text(breaker);
            text("Bees, Honey, Nectar, Wax"); 
            text(breaker);
            userInput = scanner.nextLine();
            validInput(userInput, upgradeSelect);
            if (userInput.equals("bees"))
            {
                int sizeIncrement = hive.getBeeInv() + 20;
                text("Bees: Capacity increases from " + hive.getBeeInv() + " --> " + sizeIncrement);
                text("Cost: 10 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                
                if(userInput.equals("cancel"))
                {
                    UI(hive, event);
                }
                // run check to see if they can afford it
                if (userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands beeUpgrade = new beeUpgrade(hive);
                    beeUpgrade.option();   
                }
                else
                {
                    UI(hive, event);
                }
            }
            if (userInput.equals("honey"))
            {
                int sizeIncrement = hive.getHonInv() + 25;
                text("Honey: Capacity increases from " + hive.getHonInv() + " --> " + sizeIncrement);
                text("Cost: 10 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                // run check to see if they can afford it
                if(userInput.equals("cancel"))
                {
                    UI(hive, event);
                }
                if(userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands honeyUpgrade = new honeyUpgrade(hive);
                    honeyUpgrade.option();   
                }
                else
                {
                    UI(hive, event);
                }
            }
            if (userInput.equals("nectar"))
            {
                int sizeIncrement = hive.getNecInv() + 50;
                text("Nectar: Capacity increases from " + hive.getNecInv() + " --> " + sizeIncrement);
                text("Cost: 10 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                if(userInput.equals("cancel"))
                {
                    UI(hive, event);
                }
                if(userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands nectarUpgrade = new nectarUpgrade(hive);
                    nectarUpgrade.option();   
                }
                else
                {
                    UI(hive, event);
                }
            }
            if (userInput.equals("wax"))
            {
                int sizeIncrement = hive.getWaxInv() + 25;
                text("Wax: Capacity increases from " + hive.getWaxInv() + " --> " + sizeIncrement);
                text("Cost: 10 Wax");
                text(breaker);
                text("Cancel \t\t\t OK");
                userInput = scanner.nextLine();
                validInput(userInput, finalSelect);
                //make sure they have the resources
                
                if(userInput.equals("cancel"))
                {
                    UI(hive, event);  
                }
                if(userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
                {
                    UserCommands waxUpgrade = new waxUpgrade(hive);
                    waxUpgrade.option();   
                }
                else
                {
                    UI(hive, event);
                }
            }
        }

        /*
         * displays the current statistics of the players hive
         */
        if (userInput.equals("collection"))
        {
            // call the collection option and display the necessary info
            UserCommands collection = new collection(hive);
            collection.option();
            text(breaker);
            text("Cancel");
            userInput = scanner.nextLine();
            validInput(userInput, collectSelect);
            
            // allows the player to look at the info until they type cancel
            if(userInput.equals("cancel"))
            {
                UI(hive, event);  
            }
        }
        
        /*
         * allows the player to convert one resource to another
         * specifically nectar into wax or honey
         */
        if (userInput.equals("production"))
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

            if(userInput.equals("worker") && hive.getBeeTotal() < hive.getBeeInv())       
            {
                text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
                text("How many workers would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxWork(hive));
                int userAmount = scanner.nextInt();
                if(ut.validateMakeBee(userAmount, ut.calcMaxWork(hive)) == true)
                {
                    text("Worker was made!");
                    UserCommands workProd = new workProduce(hive, userAmount);
                    workProd.option();
                }
                else
                    text("You are at max capacity for this material!");
            }
            if(userInput.equals("drone") && hive.getBeeTotal() < hive.getBeeInv())       
            {
                text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
                text("How many drones would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxDrone(hive));
                int userAmount = scanner.nextInt();
                
                if(ut.validateMakeBee(userAmount, ut.calcMaxDrone(hive)) == true)
                {
                    text("Drone was made!");
                    UserCommands droneProd = new droneProduce(hive, userAmount);
                    droneProd.option();
                }
                else
                    text("You are at max capacity for this material!");
            }
            if(userInput.equals("guardian") && hive.getBeeTotal() < hive.getBeeInv())       
            {
                text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
                text("How many guardians would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxGuard(hive));
                int userAmount = scanner.nextInt();
                
                if(ut.validateMakeBee(userAmount, ut.calcMaxGuard(hive)) == true)
                {
                    text("Guardian was made!");
                    UserCommands guardianProd = new guardianProduce(hive, userAmount);
                    guardianProd.option();
                }
                else
                    text("You are at max capacity for this material!");
            }
            if(userInput.equals("cancel"))
            {
                UI(hive, event);
            }

            if(userInput.equals("honey") && hive.getAvailable() > 0 && hive.getHoney() < hive.getHonInv())
            {
                text("You have " + hive.getAvailable() + "/" + hive.getWorker() + " Worker Bees available!");
                text("How much honey would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxHoney(hive));
                int userAmount = scanner.nextInt();
                if (ut.validateMakeHoney(userAmount, ut.calcMaxHoney(hive)) == true)
                {
                    text("Honey was made!");
                    UserCommands honeyProd = new honeyProduce(hive, userAmount);
                    honeyProd.option();
                }
                else
                    text("You are at max capacity for this material!");
            }
            else if(userInput.equals("wax") && hive.getAvailable() > 0 && hive.getWax() < hive.getWaxInv())
            {
                text("You have " + hive.getAvailable() + "/" + hive.getWorker() + " Worker Bees available!");
                text("How much wax would you like to produce?");
                text("Min: 0 \t\t\t Max: " + ut.calcMaxWax(hive));
                int userAmount = scanner.nextInt();
                if (ut.validateMakeHoney(userAmount, ut.calcMaxHoney(hive)) == true)
                {
                    text("Wax was made!");
                    UserCommands waxProd = new waxProduce(hive, userAmount);
                    waxProd.option();
                }
                else
                    text("You are at max capacity for this material!");
            }
            else if(hive.getAvailable() == 0)
            {
                text("All of your Worker Bees are tired!");
            }
        }

        /*
         * this will end the round/day and have all the bee's do their daily work
         * it will also increase the day counter and allow for possible events
         */
        if (userInput.equals("end day"))
        {
            UserCommands endDay = new endDay(hive, event);
            endDay.option();
        }
        else
            UI(hive, event);
    }
}