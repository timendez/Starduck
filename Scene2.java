import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene2 extends World
{
    private Text text = new Text("starText3.png");
    private StarDuck starduck;
    
    /**
     * Constructor for objects of class Scene2.
     * 
     */
    public Scene2(StarDuck starduck)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Platform platform = new Platform();

        addObject(platform, 300, 400);
        addObject(starduck, 0, starduck.getY());
        
        addObject(new OscillatingPlatform(0,500,2), 530, 300); 
        addObject(new SPower(), 530, 350); // y == 70
        
        this.starduck = starduck;
    }
    
    public void beginDialog() {
        addObject(text, 200, 50);
    }
    
    public void dismissDialog() {
        removeObject(text);
    }
}
