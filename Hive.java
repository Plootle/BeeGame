public class Hive
{
    private int dayCounter = 0;
    private int nectar = 0;
    private int nectarInv = 10;
    private int honey = 0;
    private int honeyInv = 10;
    private int wax = 0;
    private int waxInv = 10;
    private int queenBee = 1;
    private int workerBee = 0;
    private int droneBee = 0;
    private int guardianBee = 0;
    private int beeInv = 20;
    //int babyBee = 0;

    /*
     * keeping track of the number of items
     */
    public int getDay()
    {
        return dayCounter;
    }

    public int getNectar()
    {
        return nectar;
    }

    public int getHoney()
    {
        return honey;
    }

    public int getWax()
    {
        return wax;
    }

    public int getQueen()
    {
        return queenBee;
    }

    public int getWorker()
    {
        return workerBee;
    }

    public int getDrone()
    {
        return droneBee;
    }

    public int getGuardian()
    {
        return guardianBee;
    }

    public int getBeeTotal()
    {
        return queenBee + workerBee + droneBee + guardianBee;
    }

    /*
     * increment the wanted values
     */
    public void addDay()
    {
        dayCounter++;
    }
    public void addNectar(int add)
    {
        nectar += add;
    }
    public void addHoney(int add)
    {
        honey += add;
    }
    public void addWax(int add)
    {
        wax += add;
    }
    public void addWorker(int add)
    {
        workerBee += add;
    }
    public void addDrone(int add)
    {
        droneBee += add;
    }
    public void addGuardian(int add)
    {
        guardianBee += add;
    }

    /*
     * this will return the inventory sizes
     */
    public int getNecInv()
    {
        return nectarInv;
    }
    public int getHonInv()
    {
        return honeyInv;
    }
    public int getWaxInv()
    {
        return waxInv;
    }
    public int getBeeInv()
    {
        return beeInv;
    }

    /*
     * this will increment the inventory sizes
     */
    public void addNecInv(int add)
    {
        nectarInv += add;
    }
    public void addHonInv(int add)
    {
        honeyInv += add;
    }
    public void addWaxInv(int add)
    {
        waxInv += add;
    }
    public void addBeeInv(int add)
    {
        beeInv += add;
    }
    
}