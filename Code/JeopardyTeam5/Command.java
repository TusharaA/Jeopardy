/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Command  implements ICommand
{
    // instance variables - replace the example below with your own
    private int x;
    ICardComponent icard;

    /**
     * Constructor for objects of class Command
     */
    public Command(ICardComponent icard)
    {
        this.icard = icard;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public void execute(MyWorld world,ICardState state,ICardComponent card,String typeOfTopic,String score, int x)
    {
         ICardComponent icardcomp=state.displayQCard((MyWorld)world,state,card,typeOfTopic,score,x);
       //  icard.setCardState(ic);
       // world.removeObject(icard);
    }
    
    
}
