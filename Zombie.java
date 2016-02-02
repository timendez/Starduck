import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private String[] walking = {"zombiewalk1.png", "zombiewalk2.png", "zombiewalk3.png", "zombiewalk4.png"};
    private int walkIdx = 0;
    private int health = 2;

    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setLocation(getX() - 2, getY());

        walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
        setImage(walking[walkIdx]);
        
        collisionDetection();
    }
    
    private void collisionDetection() {
        Actor starD = this.getOneIntersectingObject(StarDuck.class);

        // Collision
        if(starD != null) {
            ((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).decreaseHealth(1);
        }
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0)
            killSelf();
    }
    
    private void killSelf() {
        getWorld().removeObject(this);
    }
}
