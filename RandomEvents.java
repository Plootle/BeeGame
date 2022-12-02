import java.util.Random;
public class RandomEvents
{
    public String getEvent()
    {
        String event="";
        Random rn = new Random();
        //Theres a 1/10 chance of a random event happening each day
        if(rn.nextInt(10)+1 == 10)
        {
            //If there is a random event, roll between these 4 events
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
        //a normal day will play out
        else
            event = "none";
        return event;
    }
}