import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossBall extends Actor
{
    /**
     * Act - do whatever the BossBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int damage = 5;
    private int animationCounter = 0;
    private GreenfootImage[] images;
    private int animationDelay = 5; 
    private int delayCounter = 0;
    public BossBall()
    {
        int numberOfFrames = 3;
        images = new GreenfootImage[numberOfFrames];

        for (int i = 0; i < numberOfFrames; i++) {
            images[i] = new GreenfootImage("images/attack_boss/attack" + (i + 1) + ".png");
            images[i].scale(40, 40);
        }
        setImage(images[0]);
    }
    public void act()
    {
        // Add your action code here.
        move(4);
        animate();
        if(checkCollision())
        {
            return;
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    private void animate()
    {
        delayCounter++;
        if (delayCounter >= animationDelay)
        {
            delayCounter = 0;
            animationCounter = (animationCounter + 1) % images.length;
            setImage(images[animationCounter]);
        }
    }
    private boolean checkCollision()
    {
        Hero hero = (Hero) getOneIntersectingObject(Hero.class);
        if(hero !=null)
        {
            hero.takeDamage(damage);
            getWorld().removeObject(this);
            return true;
        }        
        return false;
}
}
