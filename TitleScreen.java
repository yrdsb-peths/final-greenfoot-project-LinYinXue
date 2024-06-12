import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Adventure Time",70);
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
        Hero hero = new Hero();
        addObject(hero,515,101);
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,295,283);
        hero.setLocation(300,200);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 30);
        addObject(label2,312,327);
        label.setLocation(310,323);
        label2.setLocation(300,275);
        Label label3 = new Label("Press <r> to restart", 22);
        addObject(label3,376,195);
        label3.setLocation(130,220);
    }
}
