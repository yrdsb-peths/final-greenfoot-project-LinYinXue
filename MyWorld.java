import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Hero hero;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    
    private void prepare()
    {
        hero = new Hero();
        addObject(hero, 100, 300);
        
        Entrance entranceLevel = new Entrance("Level");
        addObject(entranceLevel,400, 300);
    
        Entrance entranceBossLevel = new Entrance("BossLevel");
        addObject(entranceBossLevel,400, 300);
    }
    public Hero getHero()
    {
        return hero;
    }
    public void startLevel(String levelName)
    {
        if(levelName.equals("Level"))
        {
            Greenfoot.setWorld(new Level());

        }
        else if (levelName.equals ("BossLevel"))
        {
            Greenfoot.setWorld(new BossLevel());
        }
    }
    
    public void returnHome()
    {
        Greenfoot.setWorld(this);
        hero.setLocation(100,300);
    }
    
}
