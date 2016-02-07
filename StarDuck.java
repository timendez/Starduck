import greenfoot.*;
import java.util.List;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StarDuck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StarDuck extends Character
{
    // CONSTS
    private final int TRANSPARENCY = 60;
    private final int OPAQUE = 255;
    
    private String[] walking = new String[4];
    private int walkIdx = 0;
    
    // Health
    private int health = 3;
    private boolean recentlyHit = false;
    private int hitCoolDown = 40;

    // Level advancement
    private boolean allowAdvance = false;

    // Direction
    private boolean isRight = true;
    
    // Shooting Time
    private int count = 0;
    public int WAIT_TIME = 50;
    private boolean coolDown = false;

    // Upgrades
    private boolean hasSpower = false;
    private boolean hasCape = false;
    
    public StarDuck() {
        super();
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
        super.act();
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 3, getY());
            
            walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
            setImage(walking[walkIdx]);
            getImage().mirrorHorizontally();
            
            isRight = false;
        }
        else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            if(getX() + 3 < getWorld().getWidth() || allowAdvance)
                setLocation(getX() + 3, getY());

            walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
            setImage(walking[walkIdx]);
                
            isRight = true;
        }
        
        if(Greenfoot.isKeyDown("b") && hasSpower && !coolDown) {
            shootBall();
            count = WAIT_TIME;
            coolDown = true;
        }
        
        if(coolDown) {
            if (count-- == 0) {
                coolDown = false;
            } 
        }
        
        if(Greenfoot.isKeyDown("space") && velocity == 0 && hasSpower) {
            velocity = -50;
            
            walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
            
            setImage(walking[walkIdx]);
        }
        

        if(getX() == getWorld().getWidth() - 1) {
            ((Scene)getWorld()).nextScene(this);
        }
        
        if(recentlyHit && hitCoolDown-- == 0) {
            recentlyHit = false;
            hitCoolDown = 40;
        }
        
        if(recentlyHit)
            getImage().setTransparency(TRANSPARENCY);
        else
            getImage().setTransparency(OPAQUE); 
            
        detectZombie();
    }
   
    
    public void setAdvance(boolean allow) {
        allowAdvance = allow;
    }

   public void setSPower(boolean has) {
        hasSpower = has;
        
        // Updating current sprite to reflect new SPower
        String curImg = getImage().toString();
        curImg = curImg.substring(17);
        curImg = curImg.substring(0, curImg.indexOf(' '));
        setImage("s" + curImg);
        
        // Updating all sprites to reflect SPower
        walking[0] = "swalking1.png";
        walking[1] = "swalking2.png";
        walking[2] = "swalking3.png";
        walking[3] = "swalking4.png";
   }

   public boolean getIsRight(){
       return isRight;
   }

   public void shootBall() {
       StarBall sBall = new StarBall(isRight);
       getWorld().addObject(sBall, getX(), getY());
   }
   
   public void decreaseHealth(int byThisMany) {
       if(!recentlyHit) {
           health -= byThisMany;
           recentlyHit = true;
           
           if(health <= 0)
               killSelf();
        }
   }
   
   private void killSelf() {
       Greenfoot.setWorld(new GameOver());
   }
   
   private void detectZombie() { 
       Actor zombie = this.getOneIntersectingObject(Zombie.class);
       
       if(zombie != null){
           decreaseHealth(1);
       }
   }
}
