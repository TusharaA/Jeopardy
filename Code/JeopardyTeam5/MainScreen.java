import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class MainScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainScreen extends Actor
{
    /**
     * Act - do whatever the MainScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean soundHasPlayed=false;
    public void act() 
    {
        if (!soundHasPlayed)
    {
        Greenfoot.playSound("202.mp3");
        soundHasPlayed = true;  //This will cause this if block never to run again, unless you have code somewhere that turns it to false again.
    }
        
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObjects(getWorld().getObjects(TextFieldForMainScreen.class));
            getWorld().addObject(new TextFieldForMainScreen("Please select category to proceed",Color.BLUE),414,294);
            MainTopicComposite Category202 = new MainTopicComposite("202");
            MainTopicComposite Category272 = new MainTopicComposite("272");
            MainTopicComposite Category273 = new MainTopicComposite("273");
            MainTopicComposite Category207 = new MainTopicComposite("207");
            Category272.setName("272");
            Category202.setName("202");
            Category273.setName("273");
            Category207.setName("207");
            getWorld().addObject(Category202,105,70);
            getWorld().addObject(Category272,476,389);
            getWorld().addObject(Category273,120,387);
            getWorld().addObject(Category207,491,74);
           }
        }
        
        
    }   
    


