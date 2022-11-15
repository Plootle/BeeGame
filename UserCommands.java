
// Here, we implement the use of a command pattern
public interface UserCommands
{
    public void option();
}

/*
 * Upgrades will increase capacity for the specified resource
 */
class beeUpgrade implements UserCommands
{
    @Override
    public void option()
    {
        //system.in
        //if statements for options
    }
}

class honeyUpgrade implements UserCommands
{
    @Override
    public void option()
    {
        //system.in
        //if statements for options
    }
}

class nectarUpgrade implements UserCommands
{
    @Override
    public void option()
    {
        //system.in
        //if statements for options
    }
}

class waxUpgrade implements UserCommands
{
    @Override
    public void option()
    {
        //system.in
        //if statements for options
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
 * Shows user resources and prompts the production of said resources
 * (ie x nectar to make y honey)
 * it also allows the user to produce bees for x amount of honey
 */
class honeyProduce implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

class waxProduce implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

class workProduce implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

class droneProduce implements UserCommands
{
    @Override
    public void option()
    {
        
    }
}

class guardianProduce implements UserCommands
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