public class BeeFactory
{
    // This follows factory pattern
    public BeeType makeBees(String userInput)
    {
        //returns one of the bee classes
        if (userInput.equals("queen"))
        {
            return new Queen(new queenCombat(), new lazy());   
        } 
        else if (userInput.equals("baby"))
        {
            return new Baby(new babyCombat(), new lazy());
        } 
        else if (userInput.equals("guardian"))
        {
            return new Guardian(new guardianCombat(), new helpful());
        } 
        else if (userInput.equals("drone"))
        {
            return new Drone(new droneCombat(), new efficient());
        }
        else if (userInput.equals("worker"))
        {
            return new Worker(new workerCombat(), new helpful());
        }
        else
        {
            System.out.println("You made a null!");
            return null;
        }
    }
}