import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Waste here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Waste extends Actor
{
    private String Name;
    private boolean Organic;
    private boolean Recycle;
    private int Type;
    private boolean drag = false;
    private int rx = 0, ry = 0;
    
    /**
     * Act - do whatever the Waste wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void AutomaticMovement(){
        move(1);
    }
    
    public void DragAndDrop(){
        if(Greenfoot.mouseDragged(this)){
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(!drag){
                drag = true;
                rx = getX()- mouse.getX();
                ry = getY()- mouse.getY();
            }
            else{
                setLocation(mouse.getX()+rx, mouse.getY() +ry);
            }
        }
    }
    
    public void DetectEnd(){
        if(getX() >= 580){
            World world;
            world = getWorld();
            
            int gameScore = ((Juego)world).getScore();
            ((Juego)world).setScore(gameScore - 50);
            
            world.removeObject(this);
            
        }
    }
    
    public int getType(){
        return Type;
    }
    
    public void setType(int type){
        Type = type;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setName(String name){
        Name = name;
    }
    
    public boolean isOrganic(){
        return Organic;
    }
    
    public void setOrganic(boolean organic){
        Organic = organic;
    }
    
    public boolean isRecycle(){
        return Recycle;
    }
    
    public void setRecycle(boolean recycle){
        Recycle = recycle;
    }
}
