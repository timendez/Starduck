import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene5Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene5Zombie extends Character
{
    private String[] walking = {"zombiewalk1.png", "zombiewalk2.png", "zombiewalk3.png", "zombiewalk4.png"};
    private int walkIdx = 0;
    private int health = 2;
    private int kills = 0;
    
    // Gravity
    private double acceleration = 9.8; //m/s^2
    private double velocity = 0; //m/s
    private final double TIME_INTERVAL = .15;
    private boolean resting = false;
    private int touchingCounter = 0;
    /**
     * Act - do whatever the Scene4Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        super.act();
        walkIdx = walkIdx == 3 ? 0 : walkIdx + 1;
        setImage(walking[walkIdx]);
        
        if (((StarDuck)getWorld().getObjects(StarDuck.class).get(0)).getX() < getX()) {
            setLocation(getX() - 1, getY());
        }   
        else {
            setLocation(getX() + 1, getY());
            getImage().mirrorHorizontally();
        }
    }
    
    public void takeDamage(int damage) {
        health -= damage;
        if(health <= 0)
            killSelf();
    }
    
    private void killSelf() {
        ((Scene4)getWorld()).zombieDied();
        getWorld().removeObject(this);
    }
    
    /* Pixel perfect detection taken from http://www.greenfoot.org/scenarios/9908 */
    public boolean touch(Actor a_big)
    {
        Actor a_small;
        if(getImage().getWidth()*getImage().getHeight()>a_big.getImage().getHeight()*a_big.getImage().getWidth())
        {
            a_small=a_big;
            a_big=this;
        }
        else
            a_small=this;

        int i_hypot=(int)Math.hypot(a_small.getImage().getWidth(),a_small.getImage().getHeight());

        GreenfootImage i=new GreenfootImage(i_hypot,i_hypot);
        i.drawImage(a_small.getImage(),i_hypot/2-a_small.getImage().getWidth()/2,i_hypot/2-a_small.getImage().getHeight()/2);
        i.rotate(a_small.getRotation());
        int w=i_hypot;

        GreenfootImage Ai = a_big.getImage(),
        i2=new GreenfootImage(i_hypot=(int)Math.hypot(Ai.getWidth(),Ai.getHeight()),i_hypot);
        i2.drawImage(Ai,i2.getWidth()/2-Ai.getWidth()/2,i2.getHeight()/2-Ai.getHeight()/2);
        i2.rotate(a_big.getRotation());
        Ai=i2;

        int
        x_Offset=a_big.getX()-a_small.getX()-(Ai.getWidth()/2-w/2),
        y_Offset=a_big.getY()-a_small.getY()-(Ai.getHeight()/2-w/2);

        boolean b = true;
        for(int yi =Math.max(0,y_Offset); yi<w && yi<i_hypot+y_Offset && b; yi++)
            for(int xi =Math.max(0,x_Offset); xi<w && xi<i_hypot+x_Offset && b; xi++)
                if(Ai.getColorAt(xi-x_Offset,yi-y_Offset).getAlpha()>0 && i.getColorAt(xi,yi).getAlpha()>0)
                    b=false;
        return !b;
    }
}
