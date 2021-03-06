import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene2 extends World implements Scene
{
    private Text text = new Text("starText3.png");
    private Text tip = new Text("spacebarTip.png");
    private StarDuck starduck;
    private GreenfootSound voice = new GreenfootSound("audio/starduck_3.wav");
    private Text healthText = new Text();

    /**
     * Constructor for objects of class Scene2.
     * 
     */
    public Scene2(StarDuck starduck)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        starduck.setAdvance(false);

        Platform platform = new Platform();

        addObject(platform, 300, 400);
        addObject(starduck, 0, starduck.getY());
        
        addObject(new OscillatingPlatform(0, 300, 1), 530, 600); 
        addObject(new SPower(), 530, 70); // spower y = 70 
        
        this.starduck = starduck;
        healthHUD(starduck.getHealth());
        addObject(healthText, 75, 20);
    }
    
    public void beginDialog() {
        voice.play();
        addObject(text, 300, 100);
        addObject(tip, 190, 390);
        starduck.setAdvance(true);
    }

    public void dismissDialog() {
        removeObject(text);
        voice.stop();
    }
    
    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene3(starduck));
    }
    
    public void zombieDied(){
        
    }
    
    public void healthHUD(int health) {
        healthText.setImage(health + ".png");
    }
}
