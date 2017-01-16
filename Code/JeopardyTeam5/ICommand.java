/**
 * Write a description of class Command here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
interface ICommand {
public void execute(MyWorld world,ICardState state,ICardComponent card,String typeOfTopic,String score, int x);
};
