import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeroDeath here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeroDeath extends Actor
{
    /**
     * Act - do whatever the HeroDeath wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage[] AnimationFrames;
    private int currentFrame;
    private int animationSpeed;
    private int animationCounter;
    private GreenfootImage heroImage;
    public HeroDeath()
    {
        AnimationFrames  = new GreenfootImage[8]; 
        for(int i = 0; i < AnimationFrames.length; i++) 
        {
            AnimationFrames[i] = new GreenfootImage("images/hero_death/death" + i + ".png");
            AnimationFrames[i].scale(100, 100);
        }
        currentFrame = 0;
        animationSpeed = 5; 
        animationCounter = 0;
        
        setImage(AnimationFrames[currentFrame]);
    }
    public void act()
    {
        // Add your action code here.
        if(animationCounter % animationSpeed == 0) {
            setImage(AnimationFrames[currentFrame]);
            currentFrame++;
            if(currentFrame >= AnimationFrames.length) {
                currentFrame = AnimationFrames.length - 1; // Stop at the last frame
            }
        }
        animationCounter++;
    }
}
