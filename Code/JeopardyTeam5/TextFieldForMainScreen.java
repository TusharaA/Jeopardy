import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.*;

/**
 * Write a description of class TextFieldForMainScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextFieldForMainScreen extends Actor
{
    
    GreenfootImage g;
    String ans = "";
    Color color;
    String text;
    
    public TextFieldForMainScreen(String printtext,Color colorvalue) {
       text = printtext;
       color = colorvalue;
       wordWrap(text,color);
    }
    public TextFieldForMainScreen(String printtext,Color colorvalue,int font) {
        
       GreenfootImage g = new GreenfootImage(printtext, font, colorvalue , null);
        setImage(g);
    }
    public void wordWrap(String printtext,Color colorvalue)
        {
          int width = 600; // maximum width of a line
          int size = 30; // font size of text
          int height = new GreenfootImage(" ", size, null, null).getHeight();
          String text = printtext; 
         String[] words = text.split(" "); // get words
         text = words[0];
         for (int i=1; i<words.length; i++)
          { // insert appropriate character(s) between words
            int w = new GreenfootImage(text+" "+words[i], size, null, null).getWidth(); // width of line with the next word
            text += (w > width-20 ? "\n" : " ")+words[i];
          }
          // building the image
          String[] lines = text.split("\n"); // get lines
         GreenfootImage image = new GreenfootImage(width, height*lines.length); // final image
          for (int i=0; i<lines.length; i++)
              { // draw each line image on final image
	           GreenfootImage line = new GreenfootImage(lines[i], size, colorvalue, null);
              image.drawImage(line, 10, i*height);    
              }
              setImage(image);        
      }
    
    /**
     * Act - do whatever the TextFieldForMainScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
