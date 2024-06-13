import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Treasure here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Treasure extends Actor
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String [] weapon = {"Sword","Axe","Bow","Hammer","Sheid","Dagger"};
    private String [] weaponImages = {"Sword","Axe","Bow","Hammer","Sheid","Dagger"};
    private GreenfootImage treasure;
    private GreenfootSound treasureSound;
    public Treasure()
    {
        treasure = new GreenfootImage("treasure.png");
        treasure.scale(60,60); 
        setImage(treasure);
    }
    public void act()
    {
        if(isTouching(Hero.class))
        {
            Hero hero = (Hero) getOneIntersectingObject(Hero.class);
            if(hero!= null)
            {
                Greenfoot.playSound("treasure_open.mp3");
                hero.goToWorld("MyWorld");
            }
        }
    }
    
}
