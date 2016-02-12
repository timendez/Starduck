import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Scene5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene6 extends World implements Scene
{
    private StarDuck starduck;
    private Text text = new Text();
    private String[] texts = {"scene4_1.png"};
    private int textsIdx = 0;
    private int kills = 0;
    private int numZombiesLeft = 6; 
    private Text healthText = new Text();
    
    /**
     * Constructor for objects of class Scene3.
     * 
     */
    public Scene6(StarDuck starduck)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        
        // Starduck
        this.starduck = starduck;
        starduck.setAdvance(false);
        addObject(starduck, 0, starduck.getY()); 

        // Base platform
        Platform platform = new Platform();
        addObject(platform, 300, 400);
        
        // Oscillators
        addObject(new OscillatingPlatform(0, 300, 1), 150, 600);
        addObject(new OscillatingPlatform(0, 300, 2), 300, 300);
        addObject(new OscillatingPlatform(0, 300, 1), 450, 600);
        
        // Baddies
        addObject(new Zombie(this, false), 400, 340);
        addObject(new Zombie(this, false), 500, 340);
        addObject(new Zombie(this, false), 600, 340);
        
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
        Greenfoot.setWorld(new Scene7(starduck));
    }
    
    private void addZombie() {
        Random ran = new Random();
        int x = ran.nextInt(3);
        
        if(x == 0)
            addObject(new Zombie(this, false), 0, 0);
        else if(x == 1)
            addObject(new Zombie(this, false), 300, 0);
        else
            addObject(new Zombie(this, false), 600, 0);

        numZombiesLeft--;
    }
    
    public void zombieDied() {
       kills++;
       if(kills < 4) {
           addZombie();
       }
       else {
           starduck.setAdvance(true);
       }
       
    }
    
    public void healthHUD(int health) {
        healthText.setImage(health + ".png");
    }
}
