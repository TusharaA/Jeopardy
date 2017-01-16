import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.*;
/**
 * Write a description of class MainTopicComposite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainTopicComposite extends Actor implements ICardComponent
{
   int cnt=0;
    int xcoords[] = {66,158,256,349,443,537};
    int ycoords[] = {127,198,269,340,411};
    String score[] = {"100","200","300","400","500"};
    private String categoryName;
    ArrayList<ICardComponent> questionCards = new ArrayList<>();
    QuestionCardFactory factory = new QuestionCardFactory();
    private String filename; 
    private String[] categories;
    private ChallengeQuestion[] questions;
     private String[] answerOrder;
    private int numQuestions;
    private static final int MAX_QUESTS=30;
    private static final int MAX_CATS = 6;
    
    public MainTopicComposite(String text){
        if(text=="202"){
            setImage("202.JPG");
        }else if(text=="272"){
            setImage("272.JPG");
        }else if(text=="273"){
            setImage("273.JPG");
        }else if(text=="207"){
            setImage("207.JPG");
        }
        
    }
    /**
     * Act - do whatever the MainTopicComposite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        
        if(Greenfoot.mouseClicked(this)){
            categories = new String[MAX_CATS];
            questions=new ChallengeQuestion[MAX_QUESTS];
            //Removing the first screen object
            //getWorld().removeObjects(getWorld().getObjects(MainScreen.class));
            //Greenfoot.playSound("202.mp3");
            getWorld().addObject(new GameScreen(),300,225);
            try{
               if(this.getName()=="273"){
                   filename="273.txt";
                }
               else if(this.getName()=="272"){
                   filename="272.txt";
                }
               else if(this.getName()=="202"){
                   filename="202.txt";
                }else{
                   filename="207.txt";
                }
            ArrayList<String> lines=loadFile(filename);
            //System.out.println(lines);
            convertUnicode(lines);
            readCategories(lines);
            readQuestions(lines);
            readAnswers(lines);
            for(int i=0;i<questions.length;i++)
            {
                //System.out.println(questions.length);
                
           // System.out.println(i+questions[i].cat);
        }//System.out.println(questions[29]);
            //System.out.println(answerOrder[1]);
            ((MyWorld)getWorld()).setQuestions(questions);
            createAllQCards(this.getName());
            addAllQCardsToWorld();
            getWorld().addObject(new Score("Score1: "),230,446);
            getWorld().addObject(new Score("Score2: "),330,446);
        }catch(IOException ioe){
            }
        }
        if(checkIfAllCardsDisabled(this.questionCards) && cnt==0){
            getWorld().addObject(new RoundOverText("Game Over",Color.RED),279,232);
            getWorld().removeObject(this);
            cnt++;
            
        }
   }  
   
   private boolean checkIfAllCardsDisabled(ArrayList<ICardComponent> questionCards){
      Iterator<ICardComponent> itr = questionCards.iterator();
       if(questionCards.size()>0){
        while (itr.hasNext()) {
            ICardComponent card=itr.next();
            if(card instanceof QuestionCardLeaf273){
                ICardState state = ((QuestionCardLeaf273)card).getCardState();
                if(!(state instanceof DisabledCard273))
                 return false;
            }else if(card instanceof QuestionCardLeaf272){
                ICardState state = ((QuestionCardLeaf272)card).getCardState();
                if(!(state instanceof DisabledCard272))
                 return false;
            }else if(card instanceof QuestionCardLeaf202){
                ICardState state = ((QuestionCardLeaf202)card).getCardState();
                if(!(state instanceof DisabledCard202))
                 return false;
            }else if(card instanceof QuestionCardLeaf207){
                ICardState state = ((QuestionCardLeaf207)card).getCardState();
                if(!(state instanceof DisabledCard207))
                 return false;
            }
           }
        }
          else{
           return false;
        }
       
        return true;
    
    }
   
    void createAllQCards(String categoryType){
       
        for(int y=0, sc=0;y<ycoords.length;y++, sc++) {
           for(int x=0;x<xcoords.length;x++) {
                ICardComponent ques = factory.generateQCard(categoryType,score[sc]);
                addQCard(ques);
           }
        }
    }
    
    void addAllQCardsToWorld(){
        int pos = 0;
        for(int y=0, sc=0;y<ycoords.length;y++, sc++) {

            for(int x=0;x<xcoords.length;x++) {
                ICardComponent ques = getQCard(pos); 
                addQCardToWorld(ques, x, y);
                pos++;
            }
        }
    }
    
    void addQCardToWorld(ICardComponent ques, int x, int y){
        Actor q = (Actor)ques;
        getWorld().addObject(q, xcoords[x], ycoords[y]);
        
        getWorld().addObject(new TextFieldForMainScreen(categories[0],Color.WHITE,22),66,50);
            getWorld().addObject(new TextFieldForMainScreen(categories[1],Color.WHITE,22),158,50);
            getWorld().addObject(new TextFieldForMainScreen(categories[2],Color.WHITE,22),256,50);
            getWorld().addObject(new TextFieldForMainScreen(categories[3],Color.WHITE,22),349,50);
            getWorld().addObject(new TextFieldForMainScreen(categories[4],Color.WHITE,22),443,50);
            getWorld().addObject(new TextFieldForMainScreen(categories[5],Color.WHITE,22),537,50);
    
    }
    
    public void addQCard(ICardComponent ques){
        questionCards.add(ques);
    }
    
    public void removeQCard(ICardComponent ques){
        questionCards.remove(ques);
    }
    
    public void displayQCard(ICardComponent ques){}
    
    public ICardComponent getQCard(int pos){
        return questionCards.get(pos);
    }
    
    public void setName(String name){
        categoryName=name;
    }
    public String getName(){
        return categoryName;
    }
    private ArrayList<String> loadFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        // Allow loading from JAR files
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        if (is == null) {
            throw new IOException("No such file: " + filename);
        }
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(is));
        String line = reader.readLine();
        while (line != null) {
            if (!line.equals("") && !line.startsWith("#")) {
                lines.add(line);
            }
            line = reader.readLine();
        }
        reader.close();
        return lines;
    }
    private void convertUnicode(ArrayList<String> lines) {
        Pattern unicode = Pattern.compile("\\\\u([0-9A-Fa-f]+)");
        for (int i = 0; i < lines.size(); i++) {
            Matcher m = unicode.matcher(lines.get(i));
            StringBuffer sb = new StringBuffer();
            while (m.find()) {
                int code = Integer.valueOf(m.group(1), 16);
                String uc = "" + Character.valueOf((char)code);
                m.appendReplacement(sb, uc);
            }
            m.appendTail(sb);
            lines.set(i, new String(sb));
        }
    }
    
    private void readCategories(final ArrayList<String> lines) {
        Pattern cat = Pattern.compile("(?i):CAT(\\d+):(.+)");
        Matcher m = cat.matcher("");
        for (int i = 0; i < lines.size(); i++) {
            m.reset(lines.get(i));
            if (m.matches()) {
                int index = Integer.valueOf(m.group(1)) - 1;
                //System.out.println(index);
                if (index >= MAX_CATS) {
                    System.out.println("WARNING: Category number "
                    + (index + 1) + " exceeds maximum allowed ("
                    + MAX_CATS + ")");
                } else if (categories[index] != null ) {
                    System.out.println("WARNING: repeating category "
                        + (index + 1));
                } else {
                    categories[index] = m.group(2);
                    //Map.put(m.group(2),null);
                }
            }
        }
    }

    private void readQuestions(final ArrayList<String> lines) {
        Pattern qst = Pattern.compile("(?i):QUEST(\\d+):(\\d+):(.+)");
        Matcher m = qst.matcher("");
        numQuestions = 0;
        for (int i = 0; i < lines.size(); i++) {
            m.reset(lines.get(i));
            if (m.matches()) {
                int index = Integer.valueOf(m.group(1)) - 1;
                //System.out.println("Q"+index/5);
                if (index >= MAX_QUESTS) {
                    System.out.println("ERROR: QUESTION number "
                    + (index + 1) + " exceeds maximum allowed ("
                    + MAX_QUESTS + ")");
                } else {
                    int value = Integer.valueOf(m.group(2));
                    ChallengeQuestion question = new ChallengeQuestion(m.group(3), value,categories[index/5]);
                    if (questions[index] != null) {
                        System.out.println("WARNING: repeating question "
                            + (index + 1));
                    } else {
                        numQuestions++;
                    }
                    questions[index] = question;
                }
            }
        }
        // Adjust count for final round question
        if (questions[29] != null) numQuestions--;
    }
    
    private void readAnswers(final ArrayList<String> lines) {
        Pattern ans = Pattern.compile("(?i):ANSWER(\\d+):(\\w):(.+)");
        Matcher m = ans.matcher("");
        for (int i = 0; i < lines.size(); i++) {
            m.reset(lines.get(i));
            if (m.matches()) {
                int index = Integer.valueOf(m.group(1)) - 1;
                //System.out.println("Q"+index);
                if (index >= MAX_QUESTS) {
                    System.out.println("ERROR: ANSWER for question number "
                    + (index + 1) + " exceeds maximum allowed question ("
                    + MAX_QUESTS + ")");
                } else if (questions[index] == null) {
                        System.out.println("ERROR: ANSWER number "
                            + (index + 1) + "has no question.");
                } else {
                    String correct = m.group(2);
                    ChallengeQuestion question = questions[index];
                    
                    if (correct.equalsIgnoreCase("T")) {
                        //System.out.println(m.group(3));
                        question.addAnswer(m.group(3), true);
                    } else {
                        question.addAnswer(m.group(3), false);
                    }
                }
            }
        }
    } 
}
