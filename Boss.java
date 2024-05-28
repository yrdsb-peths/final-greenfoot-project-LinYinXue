import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

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
    private int health = 10000;
    private int shootCooldown = 50;
    private int cooldownTime = 0;
    private Label healthBar;
    private Random random = new Random();
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
        moveRandomly();
        checkFire();

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
    
    private void moveRandomly()
    {
        if(random.nextInt(100)<2)
        {
            setRotation(random.nextInt(360));
        }
    }
    
    private void checkFire()
    {
        if(cooldownTime >0)
        {
            cooldownTime--;
        }
        if(cooldownTime ==0)
        {
            shoot();
            cooldownTime = shootCooldown;
        }
    }
    private void shoot()
    {
        Hero hero = (Hero) getWorld().getObjects(Hero.class).get(0);
        BossBall bossBall = new BossBall();
        getWorld().addObject(bossBall, getX(), getY());
        bossBall.turnTowards(hero.getX(), hero.getY());
    }
  
}
