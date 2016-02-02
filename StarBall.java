import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarBall extends Actor
{
    /**
     * Act - do whatever the StarBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String[] images = {"projectile1.png", "projectile2.png", "projectile3.png", "projectile4.png"};
    private boolean isRight;
    private boolean goingDown = true;
    private int count = 0;
    public void act() 
    {   
        if(isRight) {
            setLocation(getX() + 4, getY());
        }
        else {
            setLocation(getX() - 4, getY());
        }
        
        if(count == 3)
            goingDown = true;
        else if(count == 0)
            goingDown = false;

        if(goingDown) {
            count--;
        }
        else {
            count++;
        }
        
        setImage(images[count]);
        
        checkAtEdge();
        collisionDetection();
    }  
    
    public StarBall(boolean isRight) {
        super();
        this.isRight = isRight;
    }
    
    public void checkAtEdge(){
        boolean ballAtEdge = this.isAtEdge();
        
        if(ballAtEdge) {
             getWorld().removeObject(this);
        }
        
    }
    
    private void collisionDetection() {
        Actor zombie = this.getOneIntersectingObject(Zombie.class);

        // Collision
        if(zombie != null) {
            ((Zombie)zombie).takeDamage(1);
            getWorld().removeObject(this);
        }
    }
}
