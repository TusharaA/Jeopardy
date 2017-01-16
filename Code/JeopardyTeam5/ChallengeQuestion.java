/**
 * Write a description of class ChallengeQuestion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ChallengeQuestion  
{
    // instance variables - replace the example below with your own
    //private int x;
    String cat;
    String que;
    List<Answer> answers;
    int value;

    /**
     * Constructor for objects of class ChallengeQuestion
     */
    public ChallengeQuestion(String que,int value)
    {
        this.cat=cat;
        this.que=que;
        //this.answers=ans;
    }
    
    public ChallengeQuestion(String que,int value,String cat)
    {
        this.que=que;
        this.value=value;
        answers = new ArrayList<Answer>();
        this.cat=cat;
        //this.ans=ans;
    }
     public void addAnswer(String answerText, boolean correct) {
        //System.out.println(answerText);
        answers.add(new Answer(answerText, correct));
        //System.out.println("A"+this.answers.get(0).ans);
    }
    }
