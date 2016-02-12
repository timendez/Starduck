import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Scene9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene9 extends World implements Scene {
    private StarDuck starduck;
    private int kills = 0;
    private Text healthText = new Text();

    /**
     * Constructor for objects of class Scene8.
     * 
     */
    public Scene9(StarDuck starduck) { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        this.starduck = starduck;
        starduck.setAdvance(false);
        
        Platform platform = new Platform();
        addObject(platform, 300, 400);

        addObject(starduck, 0, starduck.getY());
        
        // Air Zombies
        addObject(new Zombie(this, true), 275, 40);
        addObject(new Zombie(this, true), 550, 40);
        addObject(new Zombie(this, true), 100, 40);
        addObject(new Zombie(this, true), 200, 150);
        addObject(new Zombie(this, true), 365, 150);
        addObject(new Zombie(this, true), 560, 260);

        healthHUD(starduck.getHealth());
        addObject(healthText, 75, 20);
    }
        
    public void beginDialog() {}

    public void dismissDialog() {}

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Victory());
    }
    
    public void zombieDied() {
       kills++;
       if (kills == 6) {
           starduck.setAdvance(true);
       }
    }
    
    public void healthHUD(int health) {
        healthText.setImage(health + ".png");
    }
}