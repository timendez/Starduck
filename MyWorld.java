import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Text text = new Text();
    private String[] texts = {"giraffeText1.png", "starText1.png", "giraffeText2.png", "starText2.png"};
    private int textsIdx = 0;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("title.png");
        
        addObject(new PlayText(), 120, 350);
    }

    public void nextScene() {
        Greenfoot.setWorld(new Scene1());
    }
}
