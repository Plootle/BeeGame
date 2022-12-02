import java.util.Random;
// This helps us implement the decorator pattern into BeeType
public interface JobType
{
    public int work(String event);
    Random rn = new Random();
}

/*
 * Job type specifies numerical value for their output in their given job role
 * ex. efficient: the main type for drones, will be able to collect more nectar than other types of bees. 
 */
class efficient implements JobType
{
    //the drones jobs are to bring back the most nectar
    @Override
    public int work(String event)
    {
        int nectar = 0;
        if(event == "jazz")
            nectar = (rn.nextInt(8) + 3) * 2;
        else if(event == "rainy")
            nectar = (rn.nextInt(8) + 3) / 2;
        else
            nectar = rn.nextInt(8) + 3;
        return nectar;
    }
}

class helpful implements JobType
{
    //workers and guardians can be helpful with nectar gathering
    @Override
    public int work(String event)
    {
        int nectar = 0;
        if(event == "jazz")
            nectar = (rn.nextInt(3) + 1) * 2;
        else if(event == "rainy")
            nectar = (rn.nextInt(3) + 1) / 2;
        else
            nectar = rn.nextInt(3) + 1;
        return nectar;
    }
}

class lazy implements JobType
{
    //the queen and babies dont help with nectar gathering
    @Override
    public int work(String event)
    {
        return 0;
    }
}
