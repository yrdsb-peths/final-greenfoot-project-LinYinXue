import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Hero hero;
    private GreenfootSound bgm;
    private GreenfootImage[] AnimationFrames;
    private int currentFrame;
    private int animationSpeed;
    private int animationCounter;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1);
        prepare();
        bgm = new GreenfootSound("BGM.mp3");
        bgm.setVolume(30);
        bgm.playLoop();
        AnimationFrames  = new GreenfootImage[6]; 
        for(int i = 0; i < AnimationFrames.length; i++) 
        {
            AnimationFrames[i] = new GreenfootImage("images/village/village" + i + ".png");
            AnimationFrames[i].scale(getWidth(), getHeight());
        }
        setBackground(AnimationFrames[currentFrame]);
        animationSpeed = 5;
    }
    
    private void prepare()
    {
        hero = new Hero();
        addObject(hero, 100, 300);
        
        Entrance entranceLevel = new Entrance("Level");
        addObject(entranceLevel,450, 300);
    }

    public Hero getHero()
    {
        return hero;
    }
    public void startLevel(String nextWorld)
    {
        if("MyWorld".equals(nextWorld))
        {
            Greenfoot.setWorld(new MyWorld());
            restartGame();
        }
        else if ("Level".equals(nextWorld))
        {
            Greenfoot.setWorld(new Level());
        }
    }
    
    public void returnHome()
    {
        Greenfoot.setWorld(this);
        hero.setLocation(100,300);
    }
    
    public void act() 
    {
        if (Greenfoot.isKeyDown("r")) 
        {
            restartGame();
        }
        animate();
    }
    private void restartGame() 
    {
        Greenfoot.setWorld(new MyWorld());
    }
    private void animate()
    {
        animationCounter++;
        if(animationCounter % animationSpeed ==0)
        {
            currentFrame = (currentFrame + 1) % AnimationFrames.length;
            setBackground(AnimationFrames[currentFrame]);
        }
    }
}