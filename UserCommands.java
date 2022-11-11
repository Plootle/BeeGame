
// Here, we implement the use of a command pattern
public interface UserCommands
{
    public void option();
}

/*
 * Upgrade Facilites to hold more workers, rate fo production 
 * 
 */
class upgrade implements UserCommands
{
    @Override
    public void option()
    {
        //system.in
        //if statements for options
    }
}
/*
 * Shows user resources and prompts the production of said resources
 * (ie x honey to make y wax)
 */
class produce implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

/*
 * Show detailed comprehension of the hive
 * - Level of each facility
 * - # of bees in each facility
 * - Inventory of all materials
 * - Day Count
 */
class collection implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

/*
 * Takes game to a new day
 * important for progressing growth of baby bees, 
 * allowing workers to start job again,
 * allows for random events
 */
class endDay implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

/*
 * In case of bad event, prompts user to battle
 */
class battle implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}