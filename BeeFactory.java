public class BeeFactory
{
    public BeeType makeBees(String userInput)
    {
        //this returns one of the bee classes
        if (userInput.equals("queen"))
        {
            return new Queen(new queen(), new lazy());   
        } 
        else if (userInput.equals("baby"))
        {
            return new Baby(new baby(), new lazy());
        } 
        else if (userInput.equals("guardian"))
        {
            return new Guardian(new guardian(), new helpful());
        } 
        else if (userInput.equals("drone"))
        {
            return new Drone(new drone(), new efficient());
        }
        else if (userInput.equals("worker"))
        {
            
            return new Worker(new worker(), new helpful());
        }
        else
        {
            System.out.println("You made a null!");
            return null;
        }
    }
}