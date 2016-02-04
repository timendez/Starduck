import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene5 extends World implements Scene
{
    private StarDuck starduck;
    private Text text = new Text();
    private String[] texts = {"scene4_1.png"};
    private int textsIdx = 0;
    private int kills = 0;
    private int numZombiesLeft = 20; 
    
    /**
     * Constructor for objects of class Scene3.
     * 
     */
    public Scene5(StarDuck starduck)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        this.starduck = starduck;
        starduck.setAdvance(false);

        Platform platform = new Platform();
        addObject(platform, 300, 400);
        
        Platform rightPlatform = new Platform();
        rightPlatform.getImage().scale(200, 25);
        addObject(rightPlatform, 500, 200);
        
        Platform leftPlatform = new Platform();
        leftPlatform.getImage().scale(200, 25);
        addObject(leftPlatform, 100, 200);
        
        Platform centerPlatform = new Platform();
        centerPlatform.getImage().scale(200, 25);
        addObject(centerPlatform, 300, 300);
        
        addObject(starduck, 0, starduck.getY()); 
        addZombie(true);
    }
    
    public void beginDialog() {
    //    addObject(text, 200, 50);
    //    text.setImage(texts[textsIdx++]);
    }

    public void dismissDialog() {
    //    removeObject(text);
    }

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene5(starduck));
    }
    
    private void addZombie(boolean fromRight) {
        if (fromRight) { 
            if(numZombiesLeft % 5 == 0) {
                addObject(new Zombie(this), 600, 150);
            }
            else {
                addObject(new Zombie(this), 600, 340);
            }
        }
        else {
            if(numZombiesLeft % 5 == 0) {
                addObject(new Zombie(this), 0, 150);
            }
            else {
                addObject(new Zombie(this), 0, 340);
            }
        }
        
        numZombiesLeft--;
    }
    
    public void zombieDied() {
       kills++;
       if(kills < 10) {
           if (kills % 20 == 0) {
               addZombie(true);
               addZombie(true);
           }
           else {
               addZombie(false);
               addZombie(true);
           }
       }
       else {
           starduck.setAdvance(true);
       }
       
    }
}
