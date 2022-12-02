import java.util.*;
//import java.io.*;

public class UserInterface
{
    String mainSelect[] = {"upgrade", "collection", "production", "end day"};
    String upgradeSelect[] = {"bees", "honey", "nectar", "wax"};
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
     * Function to validate a user input with a list of valid choices for game selection
     */
    public String validInput(String validMoves[])
    {
        scanner.reset();
        String userIn = scanner.nextLine();
        userIn.toLowerCase();
        // Compares users input to lsit of choices
        for(int i = 0; i < validMoves.length; i++)
        {
            // if input matches an appropriate choice
            if(userIn.equals(validMoves[i]))
                return userIn;
        }
        text("Please select a valid option!");
        
        // userIn = userIn.toLowerCase();
        // validInput(userIn, validMoves);
        return validInput(validMoves);
    }

    /*
     * User Interface for Upgrade menu
     * Upgrade menu allows user to upgrade capacity of Bees, Honey, Nectar, and Wax
     */
    public int UpgradeUI(Hive hive, String event)
    {
        String userInput;
        text("What would you like to upgrade?");
        text(breaker);
        text("Bees, Honey, Nectar, Wax"); 
        text(breaker);
        userInput = validInput(upgradeSelect); // Prompts user input and validates selection


        // If statements based on user choice

        // Upgrade amount of bees hive can store
        if (userInput.equals("bees"))
        {
            int sizeIncrement = hive.getBeeInv() + 20; // display value
            text("Bees: Capacity increases from " + hive.getBeeInv() + " --> " + sizeIncrement);
            text("Cost: 10 Wax");
            text(breaker);
            text("Cancel \t\t\t OK");
            userInput = validInput(finalSelect);
            
            if(userInput.equals("cancel"))
                return 0;
            // run check to see if they can afford it
            if (userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
            {
                UserCommands beeUpgrade = new beeUpgrade(hive);
                beeUpgrade.option();  
                return 0; 
            }
            else
            {
                text("Cannot afford upgrade :(");
                return 0;
            }
        }
        
        // Upgrade amount of hoeny hive can store
        if (userInput.equals("honey"))
        {
            int sizeIncrement = hive.getHonInv() + 25;
            text("Honey: Capacity increases from " + hive.getHonInv() + " --> " + sizeIncrement);
            text("Cost: 10 Wax");
            text(breaker);
            text("Cancel \t\t\t OK");
            userInput = validInput( finalSelect); // Prompts user input and validates selection
            
            if(userInput.equals("cancel"))
                return 0;
            // run check to see if they can afford it
            if(userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
            {
                UserCommands honeyUpgrade = new honeyUpgrade(hive);
                honeyUpgrade.option();   
                return 0;
            }
            else
            {
                text("Cannot afford upgrade :(");
                return 0;
            }
        }

        // Upgrade amount of nectar the hive can store.
        if (userInput.equals("nectar"))
        {
            int sizeIncrement = hive.getNecInv() + 50;
            text("Nectar: Capacity increases from " + hive.getNecInv() + " --> " + sizeIncrement);
            text("Cost: 10 Wax");
            text(breaker);
            text("Cancel \t\t\t OK");
            userInput = validInput( finalSelect);// Prompts user input and validates selection

            if(userInput.equals("cancel"))
                return 0;
            // run check to see if they can afford it
            if(userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
            {
                UserCommands nectarUpgrade = new nectarUpgrade(hive);
                nectarUpgrade.option();  
                return 0; 
            }
            else
            {
                text("Cannot afford upgrade :(");
                return 0;
            }
        }
        // Upgrade amount of wax the hive can store.
        if (userInput.equals("wax"))
        {
            int sizeIncrement = hive.getWaxInv() + 25;
            text("Wax: Capacity increases from " + hive.getWaxInv() + " --> " + sizeIncrement);
            text("Cost: 10 Wax");
            text(breaker);
            text("Cancel \t\t\t OK");
            userInput = validInput( finalSelect); // Prompts user input and validates selection
            
            if(userInput.equals("cancel"))
                return 0;
            // run check to see if they can afford it
            if(userInput.equals("ok") && ut.validateInvUpgrade(hive) == true)
            {
                UserCommands waxUpgrade = new waxUpgrade(hive);
                waxUpgrade.option();   
                return 0;
            }
            else
            {
                text("Cannot afford upgrade :(");
                return 0;
            }
        }
        return 0;
    }

    // Display to user entire Hive inventory
    public int CollectionUI(Hive hive, String event)
    {
        String userInput;
        // call the collection option and display the necessary info
        UserCommands collection = new collection(hive);
        collection.option();
        text(breaker);
        text("Cancel");
        userInput = validInput( collectSelect); // Prompts user input and validates selection
        
        // allows the player to look at the info until they type "cancel"
        if(userInput.equals("cancel"))
            return 0;
        return 0;  
    }

    /*
     * User Interface for Production menu
     * Upgrade menu allows user to produce wax or honey
     * Also allows user to invite more workers, drones, or guardians to the hive.
     */
    public int ProductionUI(Hive hive, String event)
    {
        String userInput;
        text(breaker);
        text("3 Nectar = 1 Honey");
        text("5 Nectar = 1 Wax");
        text("1 honey = 1 Worker");
        text("2 honey = 1 Drone");
        text("3 honey = 1 Guardian");
        text("What would you like more of?");
        text("Honey, Wax, Worker, Drone, Guardian, Cancel");
        text(breaker);
        userInput = validInput( produceSelect); // Prompts user input and validates selection

        //Production for new bees with the necessary edge cases making sure they have enough materials
        if(userInput.equals("worker") && hive.getBeeTotal() < hive.getBeeInv())       
        {
            text("You have " + hive.getBeeTotal() + "/" + hive.getBeeInv() + " Bees!");
            text("How many workers would you like to produce?");
            text("Min: 0 \t\t\t Max: " + ut.calcMaxWork(hive));
            int userAmount = scanner.nextInt();
            if(ut.validateMakeBee(userAmount, ut.calcMaxWork(hive)) == true)
            {
                if(userAmount == 0)
                    text("No workers were made!");
                else
                {
                    text("Worker was made!");
                    UserCommands workProd = new workProduce(hive, userAmount);
                    workProd.option();
                }
            }
            else
                text("You are at max capacity for this material!");
            return 0;
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
            return 0;
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
            return 0;
        }

        //Production for honey and wax with the necessary edge cases of going over the inventory cap and production limit
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
        }
        else if(userInput.equals("wax") && hive.getAvailable() > 0 && hive.getWax() < hive.getWaxInv())
        {
            text("You have " + hive.getAvailable() + "/" + hive.getWorker() + " Worker Bees available!");
            text("How much wax would you like to produce?");
            text("Min: 0 \t\t\t Max: " + ut.calcMaxWax(hive));
            int userAmount = scanner.nextInt();
            if (ut.validateMakeWax(userAmount, ut.calcMaxWax(hive)) == true)
            {
                text("Wax was made!");
                UserCommands waxProd = new waxProduce(hive, userAmount);
                waxProd.option();
            }
        }
        else if(hive.getAvailable() == 0)
            text("All of your Worker Bees are tired!");
        else
            text("You are at max capacity for this material!");
         
        if(userInput.equals("cancel"))
        {
            return 0;
        }
        return 0;
    }
    
    // This is where the majority of our text lies and it also calls to the other functions
    public int UI(Hive hive, String event)
    {
        Battle battle = new Battle();
        // Set of attacks for the random events and day 10, 20, and 30
        if(event.equals("atk"))
        {
            text("A surprise attack has hit the hive!!!");
            int result = battle.atk(hive);
            if(result == 0)
                return 0;
            text("You survived the surprise Attack!");
        }
        if(event.equals("atk1"))
        {
            int result = battle.atk1(hive);
            if(result == 0)
                return 0;
            text("You survived the Hornet Attack!");
        }
        if(event.equals("atk2"))
        {
            int result = battle.atk2(hive);
            if(result == 0)
                return 0;
            text("You survived the YellowJacket Attack!");
        }
        if(event.equals("atk3"))
        {
            int result = battle.atk3(hive);
            if(result == 0)
                return 0;
            text("You survived the DragonFly Attack!");
        }

        // Main text screen that allows the user to navigate where they would like to go
        int day = hive.getDay();
        text("It is day " + day + "!");
        text("What would you like to do today?");
        text(breaker);
        text("Upgrade, Collection, Production, End Day");
        text(breaker);
        String userInput;
        userInput = validInput(mainSelect);
        
        /*
         * allows the player to upgrade the inventory space of their resources
         */
        if (userInput.equals("upgrade"))
            UpgradeUI(hive, event);

        /*
         * displays the current statistics of the players hive
         */
        if (userInput.equals("collection"))
        {
            CollectionUI(hive, event);
        }
            
        /*
         * allows the player to convert one resource to another
         * nectar into wax or honey
         * or produce more bee's
         */
        if (userInput.equals("production"))
            ProductionUI(hive, event);

        /*
         * this will end the round/day and have all the bee's do their daily work
         * it will also increase the day counter and allow for possible events
         */
        if (userInput.equals("end day"))
        {
            UserCommands endDay = new endDay(hive, event);
            endDay.option();
        }
        return 1;
    }
}