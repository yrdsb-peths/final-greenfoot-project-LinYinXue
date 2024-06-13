import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Notify here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notify extends Actor
{
    /**
     * Act - do whatever the Notify wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Notify(String weaponName, GreenfootImage weaponImage)
    {
        GreenfootImage bgImage = new GreenfootImage(300, 100);
        bgImage.setColor(Color.BLACK);
        bgImage.fill();
        bgImage.setTransparency(150);
        setImage(bgImage);

        GreenfootImage textImage = new GreenfootImage("Obtained: " + weaponName, 24, Color.WHITE, new Color(0, 0, 0, 0));
        bgImage.drawImage(textImage, 10, 10);
        bgImage.drawImage(weaponImage, bgImage.getWidth() - weaponImage.getWidth() - 10, 10);
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }
}
