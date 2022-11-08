import java.util.Random;

public interface JobType
{
    public int work();
    Random rn = new Random();
}

/*
 * Job type specifies numerical value for their output in their given job role
 * ex. efficient: the main type for drones, will be able to collect mroe nectar than other types of bees. 
 */

class efficient implements JobType
{
    //the drones jobs are to bring back the most nectar
    @Override
    public int work()
    {
        int nectar = rn.nextInt(20) + 15;
        return nectar;
    }
}

class helpful implements JobType
{
    //workers and guardians can be helpful with nectar gathering
    @Override
    public int work()
    {
        int nectar = rn.nextInt(6) + 1;
        return nectar;
    }
}

class lazy implements JobType
{
    //the queen and babies dont help with nectar gathering
    @Override
    public int work()
    {
        return 0;
    }
}
