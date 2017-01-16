import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //private Timer timer = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private static final int DEFAULT_TIMER = 15;
    private CountDownTimer timer = new CountDownTimer(DEFAULT_TIMER);
    private boolean provideTimer = true;
    ICardComponent currentCard;
    boolean answerClicked=false;
    ChallengeQuestion[] questions;
    int score1=0;
    int score2=0;
    private int player=1;
    
    public void setCurrentCard(ICardComponent card){
       this.currentCard = card;
    }
    
    public ICardComponent getCurrentCard(){
        return this.currentCard;
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x454 cells with a cell size of 1x1 pixels.
        super(600,454,1);
       addObject(new MainScreen(),290,187);
       addObject(new TextFieldForMainScreen("Please Click on the image below to play the game",Color.BLUE),300,70);
        addObject(new TextFieldForMainScreen("MultiPlayer Mode",Color.BLUE),483,338);
        
    }
    
        public void timeout() {
        Greenfoot.playSound("timeout.wav");
        stopTimer();
        
       }
       
        public void stopTimer() {
        timer.stop();
        removeObject(timer);
        
        if(!answerClicked){
       ICardComponent card = getCurrentCard();
        if(card instanceof QuestionCardLeaf273){
           ((QuestionCardLeaf273)card).timeOutCard(this,card);
        }else if (card instanceof QuestionCardLeaf272){
           ((QuestionCardLeaf272)card).timeOutCard(this,card);
        }else if (card instanceof QuestionCardLeaf202){
            ((QuestionCardLeaf202)card).timeOutCard(this,card);
        }else if (card instanceof QuestionCardLeaf207){
            ((QuestionCardLeaf207)card).timeOutCard(this,card);
        }
       
    }
    }
     public void setProvideTimer(boolean b) {
        provideTimer = b;
    }

    /**
     * Return whether a timer is provided or not.
     *
     * @return <code>true</code> if a timer is provided; otherwise
     *         <code>false</code>.
     */
    public boolean getProvideTimer() {
        return provideTimer;
    }
    public void startTimer() {
        timer.start();
        addObject(timer, 565, 35);
        
    }
     public void setQuestions(ChallengeQuestion[] ques) {
        questions=ques;
    }
    
    public void setScore1(int score) {
        score1=score;
    }
    
    public int getScore1() {
        return score1;
    }
    
    public void setScore2(int score) {
        score2=score;
    }
    
    public int getScore2() {
        return score2;
    }
    
    public void setPlayer(int playerTurn) {
        player=playerTurn;
    }
    
    public int getPlayer() {
        return player;
    }

    /**
     * Return whether a timer is provided or not.
     *
     * @return <code>true</code> if a timer is provided; otherwise
     *         <code>false</code>.
     */
    public ChallengeQuestion[] getQuestions() {
        return questions;
    }
}
