import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cape here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cape extends Actor
{
    /**
     * Act - do whatever the Cape wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    private boolean got = false;
    
    public Cape(){
        super();
        setImage("cape.png");
    }
    
    public void act() 
    {
        collisionDetection();
    }    
    
    private void collisionDetection() {
        Actor starD = this.getOneIntersectingObject(StarDuck.class);

        // Collision
        if(!got && starD != null) {
            ((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).setCapePower(true);
            //((Scene2)getWorld()).beginDialog();
            getImage().clear();
            got = true;
        }
    }
}
