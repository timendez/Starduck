import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Scene3 extends World implements Scene
{
    private StarDuck starduck;
    private Text text = new Text();
    private String[] texts = {"scene3_1.png"};
    private int textsIdx = 0;
    private boolean zombieSpawned = false;
    
    /**
     * Constructor for objects of class Scene3.
     * 
     */
    public Scene3(StarDuck starduck)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        this.starduck = starduck;

        Platform platform = new Platform();
        addObject(platform, 300, 400);
        
        addObject(starduck, 0, starduck.getY()); 

        addObject(new Giraffe(), 300, 340);
    }
    
    public void beginDialog() {
    //    addObject(text, 200, 50);
    //    text.setImage(texts[textsIdx++]);
    }

    public void dismissDialog() {
    //    removeObject(text);
        if(!zombieSpawned)
            addZombie();
    }

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene3(starduck));
    }
    
    private void addZombie() {
        addObject(new Zombie(), 600, 340);
        zombieSpawned = true;
    }
}
