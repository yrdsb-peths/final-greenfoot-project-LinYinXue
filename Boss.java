import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Actor
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage = 100;
    private int health = 1000;
    private Label healthBar;
    public Boss()
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
        updateHealthBar();
        if(health<=0)
        {
            getWorld().removeObject(healthBar);
            getWorld().removeObject(this);
        }
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
