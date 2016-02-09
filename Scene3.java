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
    private String[] texts = {"giraffeText3.png", "giraffeText4.png"};
    private int textsIdx = 0;
    private boolean zombieSpawned = false;
    private GreenfootSound voice;
    private String[] audio = {"audio/effarig_3.wav", "audio/effarig_4.wav"};

    
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
        starduck.setAdvance(false);

        Platform platform = new Platform();
        addObject(platform, 300, 400);
        
        addObject(starduck, 0, starduck.getY()); 

        addObject(new Giraffe(), 300, 340);
    }
    
    public void beginDialog() {
        if(textsIdx <= 1) {
            addObject(text, 300, 200);
            voice = new GreenfootSound(audio[textsIdx]);
            voice.play();
            text.setImage(texts[textsIdx++]);
        }
    }

    public void dismissDialog() {
        removeObject(text);
        if(!zombieSpawned)
            addZombie();
    }

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene4(starduck));
    }
    
    private void addZombie() {
        addObject(new Zombie(this), 600, 340);
        zombieSpawned = true;
    }
    
    public void zombieDied(){
        starduck.setAdvance(true);
    }
}
