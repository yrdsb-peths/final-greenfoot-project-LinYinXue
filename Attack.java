import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage = 10;
    private GreenfootImage[] frame;
    private int currentFrame;
    private int animationSpeed;
    private int animationCounter;
    public Attack()
    {
        frame = new GreenfootImage[4];
        for(int i = 0; i< frame.length; i++)
        {
            frame[i] = new GreenfootImage("images/Attack_sprite/attack"+i+".png");
            frame[i].scale(30,30);
        }
        setImage(frame[currentFrame]);
        animationSpeed = 5;
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
        animateAttack();
    }
    private void animateAttack()
    {
        animationCounter++;
        if(animationCounter % animationSpeed ==0)
        {
            currentFrame = (currentFrame + 1) % frame.length;
            setImage(frame[currentFrame]);
        }
    }
    private boolean checkCollision()
    {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy !=null)
        {
            enemy.takeDamage(damage);
            getWorld().removeObject(this);
            return true;
        }  
        Boss boss = (Boss) getOneIntersectingObject(Boss.class);
        if(boss !=null)
        {
            boss.takeDamage(damage);
            getWorld().removeObject(this);
            return true;
        }    
        return false;
    }
    
}
