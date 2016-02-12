import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scene4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scene4 extends World implements Scene
{
    private StarDuck starduck;
    private Text text = new Text();
    private String[] texts = {"scene4_1.png"};
    private int textsIdx = 0;
    private int kills = 0;
    private Text healthText = new Text();
    
    /**
     * Constructor for objects of class Scene3.
     * 
     */
    public Scene4(StarDuck starduck)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        setBackground("background.png");
        this.starduck = starduck;
        starduck.setAdvance(false);

        Platform platform = new Platform();
        addObject(platform, 300, 400);
        
        addObject(starduck, 0, starduck.getY()); 
        addZombie(true);
        
        healthHUD(starduck.getHealth());
        addObject(healthText, 75, 20);
    }
    
    public void beginDialog() {
    //    addObject(text, 200, 50);
    //    text.setImage(texts[textsIdx++]);
    }

    public void dismissDialog() {
    //    removeObject(text);
    }

    public void nextScene(StarDuck starduck) {
        Greenfoot.setWorld(new Scene5(starduck));
    }
    
    private void addZombie(boolean fromRight) {
        if (fromRight) {  
            addObject(new Zombie(this, false), 600, 340);
        }
        else {
            addObject(new Zombie(this, false), 0, 340);
        }
    }
    
    public void zombieDied() {
       kills++;
       if(kills <= 3) {
           if (kills % 3 == 0) {
               addZombie(true);
           }
           else {
               addZombie(false);
           }
       }
       else {
           starduck.setAdvance(true);
       }
       
    }
    
    public void healthHUD(int health) {
        healthText.setImage(health + ".png");
    }
}
