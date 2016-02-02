import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SPower extends Actor
{
    private String[] images = {"sPower1.png", "sPower2.png", "sPower3.png", "sPower4.png", "sPower5.png"};
    private int count = 0;
    private boolean goingDown = false;
    private int WAIT_TIME = 300; // 5 seconds
    private int waitCount = 0;
    private boolean ignore = true;
    private boolean got = false;
    
    /**
     * Act - do whatever the SPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(count == 4)
            goingDown = true;
        else if(count == 0)
            goingDown = false;

        if(goingDown) {
            count--;
        }
        else {
            count++;
        }
        
        if(!got)
            setImage(images[count]);
        
        collisionDetection();
        
        if(ignore)
            ((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).setAdvance(false);
        
        if(ignore && waitCount++ == WAIT_TIME) {
               ((Scene2)getWorld()).dismissDialog();
               ignore = false;
               ((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).setAdvance(true);
        }
        
        
    }
    
     private void collisionDetection() {
        Actor starD = this.getOneIntersectingObject(StarDuck.class);

        // Collision
        if(!got && starD != null) {
            ((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).setSPower(true);
            ((Scene2)getWorld()).beginDialog();
            getImage().clear();
            got = true;
        }
    }
}
