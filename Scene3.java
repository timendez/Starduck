import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Scene3 extends World
{
    private StarDuck starduck;
    /**
     * Constructor for objects of class Scene3.
     * 
     */
    public Scene3(StarDuck starduck)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.starduck = starduck;
        
        Platform platform = new Platform();
        addObject(platform, 300, 400);
        addObject(starduck, 0, starduck.getY()); 
        
        addObject(new Giraffe(), 500, 340);
    }
}
