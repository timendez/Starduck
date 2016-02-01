import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Giraffe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Giraffe extends Actor
{
    public int WAIT_TIME = 5;//300; // 5 seconds
    private int count = 0;
    private int numTimes = 0;
    
    private boolean ignore = false;
    /**
     * Act - do whatever the Giraffe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       try {
           if(!ignore && getWorld().getObjects(StarDuck.class).get(0).getX() >= getX() - 100 && numTimes < 4) {
               ignore = true;
               ((MyWorld)getWorld()).beginDialog();
               numTimes++;
           }

           if(ignore && count++ == WAIT_TIME) {
               ((MyWorld)getWorld()).dismissDialog();
               ignore = false;
               count = 0;
               
               if(numTimes == 4)
                   ((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).setAdvance(true);
           }
       }
       catch (IndexOutOfBoundsException e) {
           
       }
    }
    
    
}