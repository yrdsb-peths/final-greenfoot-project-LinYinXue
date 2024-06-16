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
    private int minEnemies = 1;
    private int maxEnemies = 5;
    private boolean treasureAdded = false;
    private boolean bossSpawned = false;
    private int enemiesDefeated =0;
    private int enemiesForLevelUp = 5;
    public Level()
    {
        super(700, 500,1);
        prepare();
    }
    private void prepare()
    {
        Hero hero = new Hero();
        addObject(hero, 100, 300);
        spawnEnemies();
    }
    
    public void act()
    {
        if(bossSpawned || treasureAdded || getObjects(Hero.class).isEmpty())
        {
            return;
        }
        Hero hero = (Hero) getObjects(Hero.class).get(0);

        if (hero.getLevel() >= 20 && getObjects(Enemy.class).isEmpty()) 
        {
            spawnBoss();
            bossSpawned = true;
        }

        if (bossSpawned && getObjects(Boss.class).isEmpty()) {
            addTreasure();
            treasureAdded = true;
        }
    }
    
    private void spawnEnemies() 
    {
        int numberOfEnemies = Greenfoot.getRandomNumber(maxEnemies - minEnemies + 1) + minEnemies;
        for (int i = 0; i < numberOfEnemies; i++) {
            addObject(new Enemy(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }
    
    public void spawnBoss()
    {
        Boss boss = new Boss();
        addObject(boss, getWidth()/2, getHeight()/2);
    }
    
    public void addTreasure()
    {
        Treasure treasure = new Treasure();
        addObject(treasure, getWidth()/2, getHeight()/2);
    }
    
    public void enemiesDefeated() 
    {
        enemiesDefeated++;
    }

    public int getEnemiesDefeated()
    {
        return enemiesDefeated;
    }

    public int getEnemiesForLevelUp()
    {
        return enemiesForLevelUp;
    }
}
