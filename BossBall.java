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
    public BossBall()
    {
        GreenfootImage image = new GreenfootImage("ball.png");
        image.scale(10,10);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
        move(4);
        if(checkCollision())
        {
            return;
        }
        if(isAtEdge())
        {
            getWorld().removeObject(this);
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
