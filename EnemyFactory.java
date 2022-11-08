public class EnemyFactory
{
    // This follows factory pattern
    public EnemyType makeEnemy(String enemyName)
    {
        if(enemyName.equals("hornet"))
        {
            return new Hornet(new hornet());
        }

        if(enemyName.equals("yellowjacket"))
        {
            return new YellowJacket(new yellowjacket());
        }

        if(enemyName.equals("dragonfly"))
        {
            return new DragonFly(new dragonfly());
        }
        return null;
    }
}