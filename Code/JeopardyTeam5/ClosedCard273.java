import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class ClosedCard273 extends QuestionCardLeaf273 implements ICardState {
    String cats="";
    public ICardComponent displayQCard(MyWorld world,ICardState state, ICardComponent card,String typeOfTopic,String score, int x) {
        world.setCurrentCard(card);
        ChallengeQuestion[] q=world.getQuestions();
        world.addObject(new QuestionScreen(),100,100);
        if(x==66) {
            cats="Node";
        } else if(x==158) {
            cats="Angular";
        } else if(x==256) {
            cats="JS-1";
        } else if(x==349) {
             cats="JS-2";
        } else if(x==443) {
             cats="MongoDb";
        } else if(x==537) {
             cats="Mixed";
        }
        for(int i=0;i<q.length;i++)
        {
			if(cats.equalsIgnoreCase(q[i].cat) && (Integer.parseInt(score))==q[i].value)
			{
			world.addObject(new Question(q[i].que,card),305,60);
			world.addObject(new TextField(q[i].answers.get(0).ans,card,q[i].answers.get(0).isCorrect,Integer.parseInt(score)),91,191);
			world.addObject(new TextField(q[i].answers.get(1).ans,card,q[i].answers.get(1).isCorrect,Integer.parseInt(score)),91,247);
			world.addObject(new TextField(q[i].answers.get(2).ans,card,q[i].answers.get(2).isCorrect,Integer.parseInt(score)),91,302);
			world.addObject(new TextField(q[i].answers.get(3).ans,card,q[i].answers.get(3).isCorrect,Integer.parseInt(score)),91,356);
			world.answerClicked=false;
			world.startTimer();
		   ((QuestionCardLeaf273)card).setCardState(new OpenCard273());
			
		   }
		}
    return card;
    }

    @Override
    public void timeOutCard(MyWorld world,ICardComponent card) {
        ((QuestionCardLeaf273)card).setCardState(new DisabledCard273());

    }

    @Override
    public void resetCard() {
        //System.out.println("Reset closed Card");
        setCardState(new ClosedCard273());

    }

}
