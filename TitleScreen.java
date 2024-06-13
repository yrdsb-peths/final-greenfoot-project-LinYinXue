import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Adventure Time",90);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(700, 500, 1); 
        GreenfootImage bgImage = new GreenfootImage("bluerock.jpg");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);
        
        addObject(titleLabel, getWidth()/2, 90);
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    private void prepare()
    {
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,350,370);
        Label label2 = new Label("Use \u2190\u2191\u2193\u2192 to move around", 30);
        addObject(label2,350,295);
        Label label3 = new Label("Press <r> to restart", 22);
        addObject(label3,350,195);
    }
}
