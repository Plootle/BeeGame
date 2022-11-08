public abstract class Resources
{
    public String getName() {return "";}
}

class Nectar extends Resources
{
    public String getName()
    {
        return "Nectar";
    }
}

class Honey extends Resources
{
    public String getName()
    {
        return "Honey";
    }
}

class Wax extends Resources
{
    public String getName()
    {
        return "Wax";
    }
}