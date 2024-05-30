import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage = 5;
    public Weapon()
    {
        GreenfootImage image = new GreenfootImage("blue-draught.png");
        image.scale(20,20);
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
