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
    private int enemyCount =5;
    private MyWorld world;
    private HealthBar healthBar;
    public Level()
    {
        super(800, 600,1);
        this.world = world;
        prepare();
        healthBar = new HealthBar(100);
        addObject(healthBar, 100, 20);
    }
    private void prepare()
    {
        healthBar = new HealthBar(100);
        Hero hero = new Hero();
        addObject(hero, 100, 300);
        for (int i = 0; i<enemyCount; i++)
        {
            addObject(new Enemy(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    public void act()
    {
        // Add your action code here.
        if(getObjects(Enemy.class).isEmpty())
        {
            world.returnHome();
        }
    }
    
}
