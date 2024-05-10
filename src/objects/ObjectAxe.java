package objects;

import main.GamePanel;

public class ObjectAxe extends SuperObject{
    
    public ObjectAxe(GamePanel gp){
        this.gp = gp;
        this.name = "axe";
        
        setup("axe");
    }
}
