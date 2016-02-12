import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

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
    private int numZombiesLeft = 1;
    private Text healthText = new Text();
    
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
        
        healthHUD(starduck.getHealth());
        addObject(healthText, 75, 20);
    }
    
    public void beginDialog() {
    //    addObject(text, 200, 50);
    //    text.setImage(texts[textsIdx++]);
    }

    public void dismissDialog() {
    //    removeObject(text);
    }

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene6(starduck));
    }
    
    private void addZombie(boolean fromRight) {
        if (fromRight) { 
            if(numZombiesLeft % 2 == 0) {
                addObject(new Zombie(this, false), 600, 150);
            }
            else {
                addObject(new Zombie(this, false), 600, 340);
            }
        }
        else {
            if(numZombiesLeft % 2 == 0) {
                addObject(new Zombie(this, false), 0, 150);
            }
            else {
                addObject(new Zombie(this, false), 0, 340);
            }
        }
        
        numZombiesLeft--;
    }
    
    public void zombieDied() {
       Random ran = new Random();
       int x = ran.nextInt(1);
       
       kills++;
       if(kills < 6) {
           if (kills % 2 == 0) {
               if(x == 0)
                  addZombie(true);
               else
                  addZombie(false);
           }
           else {
               addZombie(true);
               addZombie(false);
           }
       }
       else {
           starduck.setAdvance(true);
       }
       
    }
    
    public void healthHUD(int health) {
        healthText.setImage(health + ".png");
    }
}
