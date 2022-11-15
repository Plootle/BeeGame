import java.util.Random;

public interface CombatType
{
    public int combat();
    Random rn = new Random();
}

class queen implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the queen does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}

class baby implements CombatType
{
    @Override
    public int combat()
    {
        //return 0 because babies cant attack
        return 0;
    }
}

class guardian implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the guardian does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}

class drone implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the drone does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}

class worker implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the worker does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}

class hornet implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the hornet does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}

class yellowjacket implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the yellowjacket does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}

class dragonfly implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the dragonfly does
        int roll = rn.nextInt(6) + 1;
        return roll;
    }
}