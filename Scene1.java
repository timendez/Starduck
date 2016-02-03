import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene1 extends World implements Scene
{
    private Text text = new Text();
    private String[] texts = {"giraffeText1.png", "starText1.png", "giraffeText2.png", "starText2.png"};
    private int textsIdx = 0;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Scene1() { 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");

        Rocket rocket = new Rocket();
        
        addObject(rocket, 50, 50);
        rocket.animate();
        addObject(new Platform(), 300, 400);
        addObject(new Giraffe(), 500, 340);
    }
    
    public void beginDialog() {
        addObject(text, 350, 200);
        text.setImage(texts[textsIdx++]);
    }
    
    public void dismissDialog() {
        removeObject(text);
    }
    
    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene2(starduck));
    }
}
