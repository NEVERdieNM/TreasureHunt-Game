package objects;

import main.GamePanel;

public class ObjectBranches extends SuperObject {
    
    public ObjectBranches(GamePanel gp){
        this.gp = gp;
        this.name = "branches";

        collsion = true;
        
        setup("branches");
    }
    
}
