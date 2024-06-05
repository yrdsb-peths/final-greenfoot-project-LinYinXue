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
    private int attackCooldown = 25;
    private int cooldownTime = 0;
    private GreenfootImage rightImage;
    private GreenfootImage leftImage;
    private boolean facingRight = true;
    public Hero()
    {
        rightImage = new GreenfootImage("man.png");
        leftImage = new GreenfootImage (rightImage);
        leftImage.mirrorVertically();
        setImage(rightImage);
    }
    public void act()
    {
        // Add your action code here.
        moveHero();
        checkAttack();
        checkCollisions();
    }
    
    private void moveHero()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-4, getY());
            setImage(leftImage);
            setRotation(180);
            facingRight = false;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+4, getY());
            setImage(rightImage);
            setRotation(0);
            facingRight = true;
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-4);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY()+4);
        }
    }
    
    private void checkAttack()
    {
        if(cooldownTime >0)
        {
            cooldownTime--;
        }
        if(Greenfoot.isKeyDown("a") && cooldownTime==0)
        {
            attack();
            cooldownTime = attackCooldown;
        }
    }
    
    public void attack()
    {
        Attack attack = new Attack();
        if(facingRight)
        {
            getWorld().addObject(attack, getX()+20, getY());
            attack.setRotation(0);
        }
        else
        {
            getWorld().addObject(attack, getX()-20, getY());
            attack.setRotation(180);
        }
    }
    
    public void takeDamage(int damage)
    {
        health -= damage;
        if(health<=0)
        {
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    
    private void checkCollisions()
    {
        if(isTouching(Enemy.class))
        {
            health -=10;
        }
    }
}
