public class UpgradeType
{
    void text(Object line)
    {
        System.out.println(line);
    }

    // ex 5 workers, 35 nectar
    // 10 workers, 20 nectar
    public int calcMaxWax(Hive hive)
    {
        int wb = hive.getWorker();
        
        int maxWax = hive.getNectar()/5; // max amount of possible wax that could be made

        if(maxWax >= wb)
            return wb;
        else if( maxWax <= wb)
            return maxWax;
        
        return 0;
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

    public boolean validateMakeWax(Hive hive, int amountToMake) //compare int values?
    {
        
        if(hive.getWax() < 25)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }

    public boolean validateMakeHoney(Hive hive) //compare int values?
    {
        
        if(hive.getNectar() < 25)
        {
            text("You don't have enough resources!");
            return false;
        }
        return true;
    }
}