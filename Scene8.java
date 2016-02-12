import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Scene8 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene8 extends World implements Scene {
    private StarDuck starduck;
    private int kills = 0;
    private Text healthText = new Text();

    /**
     * Constructor for objects of class Scene8.
     * 
     */
    public Scene8(StarDuck starduck) { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        this.starduck = starduck;
        starduck.setAdvance(false);
        
        Platform platform = new Platform();
        addObject(platform, 300, 400);
        
        Platform botPlatform = new Platform();
        botPlatform.getImage().scale(500, 25);
        addObject(botPlatform, 250, 250);

        Platform topPlatform = new Platform();
        topPlatform.getImage().scale(500, 25);
        addObject(topPlatform, 350, 100);
        
        addObject(starduck, 25, 338);
        
        //Start Zombies
        addZombie();
        addObject(new Zombie(this, false), 600, 338);
        addObject(new Zombie(this, false), 300, 200);
        addObject(new Zombie(this, false), 400, 338);
        addObject(new Zombie(this, false), 4, 200);
        addObject(new Zombie(this, false), 350, 338);
        addObject(new Zombie(this, false), 125, 200);
        
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
        Greenfoot.setWorld(new Scene9(starduck));
    }

    private void addZombie() {
        addObject(new Zombie(this, false), 600, 50);
    }
    
    public void zombieDied() {
       kills++;
       if(kills < 4) {
           addZombie();
       }
       else if (kills == 10) {
           starduck.setAdvance(true);
       }
    }
    
    public void healthHUD(int health) {
        healthText.setImage(health + ".png");
    }
}