import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

public class PrintScore extends Actor 
{
    public PrintScore(int text)
    {
        //getWorld().removeObject(this);
        //System.out.println(text);
        GreenfootImage g = new GreenfootImage(String.valueOf(text), 18, Color.WHITE , null);
       setImage(g);
       
    }
    public void act()
    {
              //observer pattern to be added      
            if(Greenfoot.mouseClicked(this)){
        getWorld().removeObject(this);
        
    }}
}
