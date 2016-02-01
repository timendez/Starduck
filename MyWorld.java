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
    private String[] texts = new String[4];
    private int textsIdx = 0;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld() { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Rocket rocket = new Rocket();
        
        addObject(rocket, 50, 50);
        rocket.animate();
        addObject(new Platform(), 300, 400);
        addObject(new Giraffe(), 500, 340);
        
        texts[0] = "giraffeText1.png";
        texts[1] = "starText1.png";
        texts[2] = "giraffeText2.png";
        texts[3] = "starText2.png";
    }
    
    public void beginDialog() {
        addObject(text, 350, 200);
        text.setImage(texts[textsIdx++]);
    }
    
    public void dismissDialog() {
        removeObject(text);
    }
}
