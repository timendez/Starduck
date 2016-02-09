import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Scene7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene7 extends World implements Scene
{
    private StarDuck starduck;
    private Text text = new Text();
    private String[] texts = {"scene4_1.png"};
    private int textsIdx = 0;
    private int kills = 0;
    private int numZombiesLeft = 6; 
    
    /**
     * Constructor for objects of class Scene3.
     * 
     */
    public Scene7(StarDuck starduck)
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
        
        Platform sideWall = new Wall();
        sideWall.getImage().scale(25, 350);
        addObject(sideWall, 575, 250);
        
        // Cape 
        addObject(new Cape(), 500, 300); 
    }
    
    public void beginDialog() {
    }

    public void dismissDialog() {
    }

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene8(starduck));
    }
    
    private void addZombie() {
        Random ran = new Random();
        int x = ran.nextInt(3);
        
        if(x == 0)
            addObject(new Zombie(this), 0, 0);
        else if(x == 1)
            addObject(new Zombie(this), 300, 0);
        else
            addObject(new Zombie(this), 600, 0);

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
}
