public class EnemyFactory
{
    // This follows factory pattern
    public EnemyType makeEnemy(String enemyName)
    {
        if(enemyName.equals("hornet"))
        {
            return new Hornet();
        }

        if(enemyName.equals("yellowjacket"))
        {
            return new YellowJacket();
        }

        if(enemyName.equals("dragonfly"))
        {
            return new DragonFly();
        }
        return null;
    }
}