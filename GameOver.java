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
    private GreenfootImage[] AnimationFrames;
    private int currentFrame;
    private int animationSpeed;
    private int animationCounter;
    private GreenfootImage heroImage;
    private GreenfootSound gameOverSound;
    private MyWorld world;
    public GameOver()
    {    
        super(700, 500, 1); 
        GreenfootImage bg = new GreenfootImage("gameover.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        HeroDeath death = new HeroDeath();
        addObject(death,360,300);
        showText("Press 'r' to Restart", getWidth()/2, getHeight()-50);
        playGameOverSound();
    }

    private void playGameOverSound() 
    {
        gameOverSound = new GreenfootSound("GameOverSound.mp3");
        gameOverSound.setVolume(40);
        gameOverSound.play();
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
    public MyWorld getWorld()
    {
        return world;
    }
}
