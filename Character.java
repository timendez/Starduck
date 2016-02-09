import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    // Gravity
    private double acceleration = 9.8; //m/s^2
    public double velocity = 0; //m/s
    private final double TIME_INTERVAL = .15;
    private boolean resting = false;
    private int touchingCounter = 0;
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        applyGravity();
        collisionDetection();
    }   
    
    private void applyGravity() {
        increaseVelocity();
        setLocation(getX(), (int)(getY() + ((velocity * TIME_INTERVAL) + (.5 * acceleration * (TIME_INTERVAL*TIME_INTERVAL)))));
    }
    
    private void increaseVelocity() {
        velocity = velocity + acceleration * TIME_INTERVAL;
    }
    
    private void collisionDetection() {
        yDirectionCollisionDetection();
        xDirectionCollisionDetection();
    }
    
    private void yDirectionCollisionDetection(){
        List<Platform> touchings = this.getObjectsAtOffset(0, this.getImage().getHeight() / 2 + 5, Platform.class);
        int yMin = 600;
        touchingCounter++;
        
        for (Actor actor: touchings){
            if (actor.getY() - actor.getImage().getHeight() / 2 < yMin) {
                yMin = actor.getY() - actor.getImage().getHeight() / 2;
            }
        }
        
        // Collision
        if(!touchings.isEmpty()) {
            acceleration = 0;
            velocity = 0;
            setLocation(getX(), yMin - this.getImage().getHeight() / 2);
        }
        else {
            touchingCounter = 0;
            acceleration = 9.8;
        }
    }
    
    private void xDirectionCollisionDetection() {
        List<Wall> wallTouchings = this.getIntersectingObjects(Wall.class);
        
        int xMin = -getImage().getWidth(), xMax = 600 + getImage().getWidth(); 
        int myMin = getX() - getImage().getWidth() / 2, myMax = getX() + getImage().getWidth() / 2; 
        
        for (Actor wall: wallTouchings) {
            if(wall.getX() < this.getX()){ 
                xMin = wall.getX() + wall.getImage().getWidth() / 2;
            }
            else if (wall.getX() > this.getX()){
                xMax = wall.getX() - wall.getImage().getWidth() / 2;
            }
        }
        
        if(myMin < xMin) {
            // left side of character touching right side of left wall
            setLocation(xMin + getImage().getWidth() / 2 + 2, getY());
        }
        else if (myMax > xMax) {
            // right side of character touching left side of right wall
            setLocation(xMax - getImage().getWidth() / 2 - 2, getY());
        }
        
    }
}
