import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Actor
{
    // Gravity
    private double acceleration = 9.8; //m/s^2
    private double velocity = 0; //m/s
    private final double TIME_INTERVAL = .15;
    
    /**
     * Act - do whatever the Rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        applyGravity();
        collisionDetection();
        
        if(isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    
    public void animate() {
        
    }
    
    private void spawnStarduck() {
        getWorld().addObject(new StarDuck(), 25, 338);
    }
    
    private void applyGravity() {
        increaseVelocity();
        setLocation(getX(), (int)(getY() + ((velocity * TIME_INTERVAL) + (.5 * acceleration * (TIME_INTERVAL*TIME_INTERVAL)))));
    }
    
    private void increaseVelocity() {
        velocity = velocity + acceleration * TIME_INTERVAL;
    }
    
    private void collisionDetection() {
        Actor a = this.getOneIntersectingObject(Platform.class);
  
        // Collision
        if(a != null) {
            acceleration = 0;
            velocity = 0;
            spawnStarduck();
            velocity = -80;
        }
    }
}
