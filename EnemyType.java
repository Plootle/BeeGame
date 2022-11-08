public abstract class EnemyType
{
    public String getName() {return "";};
    private boolean life = true;

    public boolean isAlive()
    {
        return life;
    }

    public void isDead()
    {
        life = false;
    }
}

class Hornet extends EnemyType
{
    public String getName()
    {
        return "Hornet";
    }
}

class YellowJacket extends EnemyType
{
    public String getName()
    {
        return "YellowJacket";
    }
}

class DragonFly extends EnemyType
{
    public String getName()
    {
        return "DragonFly";
    }
}