import java.util.Random;

public class RandomEvents
{
    public String getEvent()
    {
        String event="";
        Random rn = new Random();
        if(rn.nextInt(10)+1 == 10)
        {
            int eventSelect = rn.nextInt(4)+1;
            if(eventSelect == 1)
                event = "jazz";
            else if( eventSelect == 2)
                event = "atk";
            else if( eventSelect == 3)
                event = "flowers";
            else if( eventSelect == 4)
                event = "rainy";
        }
        else
            event = "none";
        return event;
    }
}