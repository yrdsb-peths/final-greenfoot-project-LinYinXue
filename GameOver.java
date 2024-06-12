import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("sand.jpg");
        setBackground(bg);
        showText("Press 'r' to Restart", getWidth()/2, getHeight()-50);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
