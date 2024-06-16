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
    private int health = 150;
    private int attackCooldown = 20;
    private int cooldownTime = 0;
    GreenfootImage[] idleRight = new GreenfootImage[6];
    GreenfootImage[] idleLeft = new GreenfootImage[6];
    private boolean facingRight = true;
    private int cooldownCounter=0;
    private int hitCooldown = 60;
    private String weapon = "None";
    SimpleTimer animationTimer = new SimpleTimer();
    private int enemiesDefeated = 0;
    private int level = 1;
    private int enemiesForLevelUp = 5;
    public Hero()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/idle_Witch/idle" +i+".png");
            idleRight[i].scale(60,70);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage(idleRight[i]);
            idleLeft[i].mirrorVertically();
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    
    public void animateHero()
    {
        int animationSpeed = 100;
        if(animationTimer.millisElapsed()>animationSpeed)
        {
            animationTimer.mark();
            if(facingRight)
            {
                setImage(idleRight[imageIndex]);
            }
            else
            {
                setImage(idleLeft[imageIndex]);
            }
            imageIndex = (imageIndex +1)% idleLeft.length;
        }    
        
    }
    public void act()
    {
        // Add your action code here.
        if(health>0)
        {
            moveHero();
            animateHero();
            checkAttack();
            checkCollisions();
            display();
            checkDefeatEnemies();
            cooldownCounter++;
        }
        else
        {
            gameOver();
        }
    }
    
    private void moveHero()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-4, getY());
            setRotation(180);
            facingRight = false;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+4, getY());
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
            Greenfoot.stop();
        }
    }
    
    private void checkCollisions()
    {
        Enemy enemy = (Enemy) getOneIntersectingObject(Enemy.class);
        if(enemy !=null && cooldownCounter > hitCooldown)
        {
            health -=10;
            cooldownCounter =0;
            enemiesDefeated++;
            if (enemiesDefeated % 5 == 0) 
            {
                levelUp();
            }
            Level level = (Level) getWorld();
            if (level.getObjects(Enemy.class).isEmpty()) 
            {
                if (level.equals(20)) {
                    level.spawnBoss();
                } else {
                    level.addTreasure();
                }
            }
        }
    }
    
    private void display()
    {
        getWorld().showText("Health: " + health, 80,20);
        getWorld().showText("Level: " + level, getWorld().getWidth() - 80,30);
    }
    
    public void levelUp()
    {
        level++;
    }
    private void gameOver()
    {
        Greenfoot.setWorld(new GameOver());
    }
    
    private void checkDefeatEnemies()
    {
        World world = getWorld();
        if (world != null && world instanceof Level) 
        {
            Level level = (Level) world;
            if (world.getObjects(Enemy.class).isEmpty()) 
            {
                enemiesDefeated++; // Increase defeated enemies count
                if (enemiesDefeated % enemiesForLevelUp == 0) 
                { // Check for level up
                    levelUp();
                }
            }
        }
    }
    
    public void goToWorld(String nextWorld)
    {
        if("MyWorld".equals(nextWorld))
        {
            MyWorld myWorld = new MyWorld();
            Greenfoot.setWorld(myWorld);
        }
        else if ("Level".equals(nextWorld))
        {
            Level level = new Level();
            Greenfoot.setWorld(level);
        }
    }
    
    public int getLevel()
    {
        return level;
    }
}