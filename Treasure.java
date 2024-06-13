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
    public void act()
    {
        if(isTouching(Hero.class))
        {
            Hero hero = (Hero) getOneIntersectingObject(Hero.class);
            if(hero!= null)
            {
                String weapon = getRandomWeapon();
                hero.obtainWeapon(weapon);
                Greenfoot.playSound("treasure_open.mp3");
                hero.goToWorld("MyWorld");
            }
        }
    }
    private String getRandomWeapon()
    {
        int index = Greenfoot.getRandomNumber(weapons.length);
        return weapons[index];
    }
}
