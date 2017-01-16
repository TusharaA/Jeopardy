import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ObserveSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CountScore extends Actor implements Observer
{
    // instance variables - replace the example below with your own
   int presentScore1=0;
   int presentScore2=0;
   int player;
   MyWorld w;
   public CountScore(MyWorld world ){
       //System.out.println(world.getScore());
       w=world;
       player=world.getPlayer();
       presentScore1=(world.getScore1());
       presentScore2=(world.getScore2());
        
    }

   
        
    public void printScore(int score1,int score2){
       w.removeObjects(w.getObjects(PrintScore.class));
       w.addObject(new PrintScore(score1),275,444); 
       w.addObject(new PrintScore(score2),375,444); 
    }
    
    public void update(int point){
        
        
        if(player==1){
            presentScore1=presentScore1+point;
            w.setScore1(presentScore1);
            w.setPlayer(2);
        }else if(player==2){
            presentScore2=presentScore2+point;
            w.setScore2(presentScore2);
            w.setPlayer(1);
        }
        printScore(presentScore1,presentScore2);
    }
    
}
