import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    /**
     * Act - do whatever the Level1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int enemyCount =2;
    private boolean entranceAdded = false;
    public Level()
    {
        super(700, 500,1);
        prepare();
    }
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero, 100, 300);
        for (int i = 0; i<enemyCount; i++)
        {
            addObject(new Enemy(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    
    public void act()
    {
        checkEnemies();
    }
    
    public void checkEnemies()
    {
        if(getObjects(Enemy.class).isEmpty()&&!entranceAdded)
        {
            Entrance entrance = new Entrance("My World");
            addObject(entrance, getWidth()/2, getHeight()/2);
            entranceAdded = true;
        }
    }
    public void leaveLevel()
    {
        
    }
    
    public void startLevel(String nextWorld)
    {
        if("MyWorld".equals(nextWorld))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        else if ("Level".equals(nextWorld))
        {
            Greenfoot.setWorld(new Level());
        }
    }
    
}
