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
    private GreenfootImage teleport;
    public Entrance (String nextWorld)
    {
        this.nextWorld = nextWorld;
        teleport = new GreenfootImage("teleport.png");
        teleport.scale(140,130); 
        setImage(teleport);
    }
    public String getNextWord()
    {
        return nextWorld;
    }
    public void act()
    {
        // check if entrance is touching the hero.
        if(isTouching(Hero.class))
        {
            Hero hero = (Hero) getOneIntersectingObject(Hero.class);
            if(hero!=null)
            {
              hero.goToWorld(nextWorld);
            }
        }
    }
}
