import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ResultScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResultScreen272 extends OpenCard272
{
    ICardComponent card;
    /**
     * Act - do whatever the ResultScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ResultScreen272(ICardComponent card){
    this.card=card;
    }
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
           timeOutCard((MyWorld)getWorld(),this.card);
       }
    }    
}
