import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class DisabledCard272 extends QuestionCardLeaf272 implements ICardState {
	@Override
	public ICardComponent displayQCard(MyWorld world,ICardState state,ICardComponent card,String typeOfTopic,String score, int x) {
		return null;

	}

	@Override
	public void timeOutCard(MyWorld world,ICardComponent card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetCard() {
		//System.out.println("Reset disabled card");
		setCardState(new ClosedCard272());
	}

}
