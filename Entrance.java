import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entrance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entrance extends Actor
{
    /**
     * Act - do whatever the Entrance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String nextWorld;
    public Entrance (String nextWorld)
    {
        this.nextWorld = nextWorld;
    }
    public void act()
    {
        // Add your action code here.
        if(isTouching(Hero.class))
        {
            World world = getWorld();
            if(world instanceof MyWorld)
            {
                ((MyWorld)world).startLevel(nextWorld);
            }
            else if(world instanceof Level)
            {
                ((Level)world).startLevel(nextWorld);
            }
        }
    }
}
