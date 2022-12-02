public class UpgradeType
{
    void text(Object line)
    {
        System.out.println(line);
    }

    // calculate the max amount of honey based on materials and worker bees available
    public int calcMaxHoney(Hive hive)
    {
        /* 
         * store how many worker bees are available and get
         * the maximum amount of honey that could be made as well
         * as the maximym amount of honey based on inventory size
         */ 
        int ab = hive.getAvailable();
        int maxHoney = hive.getNectar()/3; 
        int invMax = hive.getHonInv() - hive.getHoney();

        // math that determines the max
        if (maxHoney + hive.getHoney() > hive.getHonInv())
            return invMax;
        else if(maxHoney > ab)
            return ab;
        else if(maxHoney <= ab)
            return maxHoney;
        return 0;
    }

    // calculate the max amount of wax based on materials and worker bees available
    public int calcMaxWax(Hive hive)
    {
        /* 
         * store how many worker bees are available and get
         * the maximum amount of wax that could be made as well
         * as the maximym amount of wax based on inventory size
         */ 
        int ab = hive.getAvailable();
        int maxWax = hive.getNectar()/5; 
        int invMax = hive.getWaxInv() - hive.getWax();

        // math that determines the max
        if (maxWax + hive.getWax() > hive.getWaxInv())
            return invMax;
        else if(maxWax > ab)
            return ab;
        else if( maxWax <= ab)
            return maxWax;
        return 0;
    }

    // calculations for the production of each type of bee
    public int calcMaxWork(Hive hive)
    {
        // 1 to 1 conversion of honey to worker
        int maxWorker = hive.getHoney(); 
        // difference between capacity and current quantity
        int invMax = hive.getBeeInv() - hive.getBeeTotal(); 
        
        // returns amount to reach max capacity
        if (maxWorker + hive.getBeeTotal() > hive.getBeeInv())
            return invMax; 
        // returns users desired amount
        else 
            return maxWorker;
    }

    public int calcMaxDrone(Hive hive)
    {
        // 2 to 1 conversion of honey to drone
        int maxDrone = hive.getHoney()/2;
        int invMax = hive.getBeeInv() - hive.getBeeTotal();
        if (maxDrone + hive.getBeeTotal() > hive.getBeeInv())
            return invMax;
        else 
            return maxDrone;
    }

    public int calcMaxGuard(Hive hive)
    {
        // 3 to 1 conversion of honey to worker
        int maxGuard = hive.getHoney()/3;
        int invMax = hive.getBeeInv() - hive.getBeeTotal();
        if (maxGuard + hive.getBeeTotal() > hive.getBeeInv())
            return invMax;
        else 
            return maxGuard;
    }
    
    // Edge case to make sure the user has enough materials for what they want to do
    public boolean validateInvUpgrade(Hive hive)
    {
        if(hive.getWax() < 10)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeHoney(int amount, int max)
    {
        if(amount < 0 || amount > max)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeWax(int amount, int max)
    {
        if(amount < 0 || amount > max)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeBee(int amount, int max)
    {
        if(amount < 0 || amount > max)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }
}