import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class ExplanationText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExplanationText extends Actor
{
    ICardComponent card;
    Color color;
    String text;
    public ExplanationText(String printtext,ICardComponent card) {
      text = printtext;
      color = Color.WHITE;
      wordWrap(text,color);
        this.card=card;
      // GreenfootImage g = new GreenfootImage(text, 30, Color.YELLOW , null);
      // setImage(g);  
    }
    
    public void wordWrap(String printtext,Color colorvalue)
        {

          int width = 500; // maximum width of a line
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
              image.drawImage(line, 200, i*height);    
              }
              setImage(image);        
      }
    /**
     * Act - do whatever the ExplanationText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
   
    }    
}
