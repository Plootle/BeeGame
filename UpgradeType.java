public class UpgradeType
{
    void text(Object line)
    {
        System.out.println(line);
    }

    public int calcMaxHoney(Hive hive)
    {
        int ab = hive.getAvailable();
        // max amount of possible honey that could be made
        int maxHoney = hive.getNectar()/3; 
        // max amount of possible wax based on inventory size
        int invMax = hive.getHonInv() - hive.getHoney();
        if (maxHoney + hive.getHoney() > hive.getHonInv())
            return invMax;
        else if(maxHoney >= ab)
            return ab;
        else if( maxHoney <= ab)
            return maxHoney;
        
        return 0;
    }

    // ex 5 workers, 35 nectar
    // 10 workers, 20 nectar
    public int calcMaxWax(Hive hive)
    {
        int ab = hive.getAvailable();
        // max amount of possible wax that could be made
        int maxWax = hive.getNectar()/5; 
        // max amount of possible wax based on inventory size
        int invMax = hive.getWaxInv() - hive.getWax();
        if (maxWax + hive.getWax() > hive.getWaxInv())
            return invMax;
        else if(maxWax >= ab)
            return ab;
        else if( maxWax <= ab)
            return maxWax;
        
        return 0;
    }

    public int calcMaxWork(Hive hive)
    {
        int maxWorker = hive.getHoney(); // 1 to 1 conversion of honey to worker
        int invMax = hive.getBeeInv() - hive.getBeeTotal();// difference between capacity and current quantity
        if (maxWorker + hive.getBeeTotal() > hive.getBeeInv())
            return invMax;// returns amount to reach max capacity
        else 
            return maxWorker;// returns users desired amount
    }

    public int calcMaxDrone(Hive hive)
    {
        int maxDrone = hive.getHoney()/2;
        int invMax = hive.getBeeInv() - hive.getBeeTotal();
        if (maxDrone + hive.getBeeTotal() > hive.getBeeInv())
            return invMax;
        else 
            return maxDrone;
    }

    public int calcMaxGuard(Hive hive)
    {
        int maxGuard = hive.getHoney()/3;
        int invMax = hive.getBeeInv() - hive.getBeeTotal();
        if (maxGuard + hive.getBeeTotal() > hive.getBeeInv())
            return invMax;
        else 
            return maxGuard;
    }
    
    public boolean validateInvUpgrade(Hive hive) //compare int values?
    {
        
        if(hive.getWax() < 25)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeHoney(int amount, int max) //compare int values?
    {
        
        if(amount < 0 || amount > max)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeWax(int amount, int max) //compare int values?
    {
        
        if(amount < 0 || amount > max)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeBee(int amount, int max) //compare int values?
    {
        if(amount < 0 || amount > max)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }
}