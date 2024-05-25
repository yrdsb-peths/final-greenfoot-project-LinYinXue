import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main character, hero.
 * 
 * @author (Lin Yin) 
 * @version (2024 May)
 */
public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health = 100;
    private int attackRange = 50;
    private int attackCooldown = 25;
    private int cooldownTime = 0;
    public void act()
    {
        // Add your action code here.
        moveHero();
        damageHero();
        if(cooldownTime > 0)
        {
            cooldownTime--;
        }
        if(Greenfoot.isKeyDown("a") && cooldownTime == 0)
        {
            attack();
            cooldownTime = attackCooldown;
        }
    }
    
    private void moveHero()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-3);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+3);
        }
    }
    
    private void damageHero()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            attack();
        }
    }
    
    public void attack()
    {
        Enemy enemy = (Enemy) getOneObjectAtOffset(0,0,Enemy.class);
        if(enemy !=null)
        {
            enemy.takeDamage(5);
        }
    }
    
    private void checkCollison()
    {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy!=null)
        {
            takeDamage(enemy.getDamage());
        }
    }
    public void takeDamage(int damage)
    {
        health -= damage;
    }
    
}
