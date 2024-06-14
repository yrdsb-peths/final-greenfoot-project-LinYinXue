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
    private int enemyCount;
    private GreenfootSound bgm;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        prepare();
        bgm = new GreenfootSound("BGM.mp3");
        bgm.setVolume(30);
        bgm.playLoop();
    }
    
    private void prepare()
    {
        hero = new Hero();
        addObject(hero, 100, 300);
        
        Entrance entranceLevel = new Entrance("Level");
        addObject(entranceLevel,400, 300);
    }

    public Hero getHero()
    {
        return hero;
    }
    public void startLevel(String nextWorld)
    {
        if("MyWorld".equals(nextWorld))
        {
            Greenfoot.setWorld(new MyWorld());
            restartGame();
        }
        else if ("Level".equals(nextWorld))
        {
            bgm.stop();
            Greenfoot.setWorld(new Level());
        }
    }
    
    public void returnHome()
    {
        bgm.stop();
        Greenfoot.setWorld(this);
        hero.setLocation(100,300);
    }
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("r")) 
        {
            restartGame();
        }
    }

    private void restartGame() 
    {
        bgm.stop(); // Stop background music when restarting
        Greenfoot.setWorld(new MyWorld());
    }
    
}
