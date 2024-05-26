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
    }
    
    private void moveHero()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            setImage(leftImage);
            setRotation(180);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            setImage(rightImage);
            setRotation(0);
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
        Weapon weapon = new Weapon();
        if(getRotation()==180)
        {
            weapon.setRotation(180);
            getWorld().addObject(weapon, getX()-20, getY());
        }
        else
        {
            weapon.setRotation(0);
            getWorld().addObject(weapon, getX()+20, getY());
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
    
}
