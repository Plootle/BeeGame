public class BeeFactory
{
    public BeeType makeBees(String userInput)
    {
        if (userInput.equals("queen"))
        {
            //this will return one of the bee classes
            return new Queen(new queen(), new lazy());   
        } 
        else if (userInput.equals("baby"))
        {
            //this will return one of the bee classes
            return new Baby(new baby(), new lazy());
        } 
        else if (userInput.equals("guardian"))
        {
            //this will return one of the bee classes
            return new Guardian(new guardian(), new helpful());
        } 
        else if (userInput.equals("drone"))
        {
            //this will return one of the bee classes
            return new Drone(new drone(), new efficient());
        }
        else if (userInput.equals("worker"))
        {
            //this will return one of the bee classes
            return new Worker(new worker(), new helpful());
        }
        else
        {
            System.out.println("You made a null!");
            return null;
        }
    }
}