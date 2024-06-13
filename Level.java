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
    private int minEnemies = 4;
    private int maxEnemies = 9;
    private boolean treasureAdded = false;
    public Level()
    {
        super(700, 500,1);
        prepare();
    }
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero, 100, 300);
        int numberOfEnemies = Greenfoot.getRandomNumber(maxEnemies - minEnemies +1) +minEnemies;
        for (int i = 0; i<numberOfEnemies; i++)
        {
            addObject(new Enemy(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    
    public void act()
    {
        if(getObjects(Enemy.class).isEmpty()&&!treasureAdded)
        {
            addTreasure();
            treasureAdded = true;
        }
    }
    
    public void addTreasure()
    {
        Treasure treasure = new Treasure();
        addObject(treasure, getWidth()/2, getHeight()/2);
    }
}
