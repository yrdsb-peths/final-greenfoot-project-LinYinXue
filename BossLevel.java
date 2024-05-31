import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossLevel extends World
{
    /**
     * Act - do whatever the BossLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private MyWorld world;
    public void act()
    {
        // Add your action code here.
        if(getObjects(Boss.class).isEmpty())
        {
            world.returnHome();
        }
    }
    
    public BossLevel()
    {
        super(800, 600,1);
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Boss(), getWidth()/2, getHeight()/2);
    }
}
