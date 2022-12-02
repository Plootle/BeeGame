import java.util.Random;
// This helps us implement the decorator pattern into BeeType and EnemyType
public interface CombatType
{
    public int combat();
    Random rn = new Random();
}

/*
 * Bees will have a set range on how each of them can attack and deal damage
 * ex. guardianCombat: Guardian bees will deal 5 damage minimum and up to 10 maximum 
 */
class queenCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the queen does
        int roll = 1;
        return roll;
    }
}

class babyCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return 0 because babies cant attack
        return 0;
    }
}

class guardianCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the guardian does
        int roll = rn.nextInt(10) + 5;
        return roll;
    }
}

class droneCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the drone does
        int roll = rn.nextInt(6) + 3;
        return roll;
    }
}

class workerCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the worker does
        int roll = rn.nextInt(3) + 1;
        return roll;
    }
}

//Creating how each enemy fights
class hornetCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the hornet does
        int roll = rn.nextInt(3) + 1;
        return roll;
    }
}

class yellowjacketCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the yellowjacket does
        int roll = rn.nextInt(6) + 3;
        return roll;
    }
}

class dragonflyCombat implements CombatType
{
    @Override
    public int combat()
    {
        //return the amount of damage the dragonfly does
        int roll = rn.nextInt(10) + 5;
        return roll;
    }
}