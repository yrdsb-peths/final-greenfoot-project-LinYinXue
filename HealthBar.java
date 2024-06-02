import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int maxHealth;
    private int currentHealth;
    public HealthBar(int maxHealth)
    {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        updateImage();
    }
    
    public void updateHealth (int health)
    {
        this.currentHealth = health;
        updateImage();
    }
    
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(100,20);
        image.setColor(Color.RED);
        image.fillRect(0,00,100,20);
        image.setColor(Color.GREEN);
        image.fillRect (0,0,(int)((double)currentHealth/maxHealth * 100),20);
        setImage(image);
    }
}
