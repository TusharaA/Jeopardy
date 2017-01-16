import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public interface Subject {

public void attach(Observer obj);


public void detach(Observer obj);

public void notifyObserver(int p);


}
