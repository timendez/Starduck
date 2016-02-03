import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class PlayText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayText extends Actor
{
    /**
     * Act - do whatever the PlayText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        setImage("playButton.png");
        if(mouse != null) {
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), PlayText.class);
            for (Object object : objects) {
                if (object == this) {
                    //change the file to what you want for when the mouse is over the button.
                    setImage("playButtonHover.png");
                }
            }
        }
        
        if(Greenfoot.mouseClicked(this)) {
            ((MyWorld)getWorld()).nextScene();
        }
    }    
}
