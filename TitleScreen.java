import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        super(700, 450, 1); 
        GreenfootImage bgImage = new GreenfootImage("Title_At.png");
        bgImage.scale(getWidth(), getHeight());
        setBackground(bgImage);
        
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
        Hero hero = new Hero();
        addObject(hero, 360,260);
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,360,320);
        Label label2 = new Label("Use \u2190\u2191\u2193\u2192 to move around", 30);
        addObject(label2,360,370);
        Label label3 = new Label("Press <r> to restart", 22);
        addObject(label3,360,195);
    }
}
