import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
public class OpenCard202  extends QuestionCardLeaf202 implements ICardState {
    
    @Override
    public ICardComponent displayQCard(MyWorld world,ICardState state,ICardComponent card,String typeOfTopic,String score, int x) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void timeOutCard(MyWorld world,ICardComponent card) {
        world.removeObjects(world.getObjects(Question.class));
        world.removeObjects(world.getObjects(TextField.class));
        world.removeObjects(world.getObjects(QuestionScreen.class));
        world.removeObjects(world.getObjects(ExplanationText.class));
        world.removeObjects(world.getObjects(ResultScreen202.class));
        ((QuestionCardLeaf202)card).setCardState(new DisabledCard202());
        
    }

    @Override
    public void resetCard() {
        System.out.println("Reset Open Card");
        setCardState(new ClosedCard202());
    }

}
