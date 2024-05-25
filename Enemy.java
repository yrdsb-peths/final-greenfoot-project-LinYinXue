import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage = 10;
    private int health = 100;
    private Label healthBar;
    
    public Enemy()
    {
        healthBar = new Label("Health:" + health, 20);
    }
    public void addedToWorld(World world)
    {
        getWorld().addObject(healthBar, getX(), getY() -20);
    }
    public void act()
    {
        // Add your action code here.
        followHero();
        updateHealthBar();
        if(health<=0)
        {
            getWorld().removeObject(healthBar);
            getWorld().removeObject(this);
        }
    }
    
    private void followHero()
    {
        Hero hero = (Hero) getWorld().getObjects(Hero.class).get(0);
        turnTowards(hero.getX(), hero.getY());
        move(2);
    }
    
    public void takeDamage(int damage)
    {
        health -= damage;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    private void updateHealthBar()
    {
        healthBar.setValue("Health:" + health);
        healthBar.setLocation(getX(), getY()-20);
        
    }
}
