import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OscillatingPlatform here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OscillatingPlatform extends OscillatingActor
{
    public OscillatingPlatform(int xRange, int yRange, int speed)
    {
        super(xRange, yRange, speed);
    }
    
    /**
     * Act - do whatever the OscillatingPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }   
    
    public void collisionDetection() {
        Actor starD = this.getOneIntersectingObject(StarDuck.class);
        
        if (starD != null) {
            getWorld().getObjects(StarDuck.class).get(0).setLocation(getX(), getY() + 10);
            //getWorld().getObjects(StarDuck.class).get(0).
        }
    }
}
