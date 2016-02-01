import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarDuck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarDuck extends Actor
{
    private String[] walking = new String[4];
    private int walkIdx = 0;

    // Level advancement
    private boolean allowAdvance = false;
    
    // Upgrades
    private boolean hasSpower = false;
    private boolean hasCape = false;
    
    // Gravity
    private double acceleration = 9.8; //m/s^2
    private double velocity = 0; //m/s
    private final double TIME_INTERVAL = .15;
    private boolean resting = false;
    private int touchingCounter = 0;
    
    public StarDuck() {
        walking[0] = "walking1.png";
        walking[1] = "walking2.png";
        walking[2] = "walking3.png";
        walking[3] = "walking4.png";
    }
    
    /**
     * Act - do whatever the StarDuck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 3, getY());
            
            walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
            setImage(walking[walkIdx]);
            getImage().mirrorHorizontally();
        }
        else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            if(getX() + 3 < getWorld().getWidth() || allowAdvance)
                setLocation(getX() + 3, getY());
            
            walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
            setImage(walking[walkIdx]);
        }

        if(Greenfoot.isKeyDown("space")) {
            velocity = -35;
            
            walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
            setImage(walking[walkIdx]);
        }
        
        if(getX() == getWorld().getWidth() - 1) {
            Greenfoot.setWorld(new Scene2(this));
        }
        
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
        Actor a = this.getOneIntersectingObject(Platform.class);
        touchingCounter++;
        
        // Collision
        if(a != null) {
            acceleration = 0;
            velocity = 0;
        }
        else {
            touchingCounter = 0;
            acceleration = 9.8;
        }
    }
    
    public void setAdvance(boolean allow) {
        allowAdvance = allow;
    }

   public void setSPower(boolean has) {
        hasSpower = has;
        walking[0] = "swalking1.png";
        walking[1] = "swalking2.png";
        walking[2] = "swalking3.png";
        walking[3] = "swalking4.png";
   }
}
