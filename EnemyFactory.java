public class EnemyFactory
{
    // This follows factory pattern
    public EnemyType makeEnemy(String enemyName)
    {
        if(enemyName.equals("hornet"))
        {
            return new Hornet(new hornetCombat());
        }

        if(enemyName.equals("yellowjacket"))
        {
            return new YellowJacket(new yellowjacketCombat());
        }

        if(enemyName.equals("dragonfly"))
        {
            return new DragonFly(new dragonflyCombat());
        }
        return null;
    }
}