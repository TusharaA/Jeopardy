import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class ClosedCard272 extends QuestionCardLeaf272 implements ICardState {
     String cats="";
    public ICardComponent displayQCard(MyWorld world,ICardState state, ICardComponent card,String typeOfTopic,String score, int x) {
       world.setCurrentCard(card);
       ChallengeQuestion[] q=world.getQuestions();
       world.addObject(new QuestionScreen(),100,100);
       if(x==66) {
            cats="Cloud";
        } else if(x==158) {
            cats="Linux";
        } else if(x==256) {
            cats="BigData";
        } else if(x==349) {
             cats="Unix";
        } else if(x==443) {
             cats="Db";
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
		   ((QuestionCardLeaf272)card).setCardState(new OpenCard272());
			
		   }
		}
        return card;
    }

    @Override
    public void timeOutCard(MyWorld world,ICardComponent card) {
        ((QuestionCardLeaf272)card).setCardState(new DisabledCard202());

    }

    @Override
    public void resetCard() {
        //System.out.println("Reset closed Card");
        setCardState(new ClosedCard272());

    }

}
