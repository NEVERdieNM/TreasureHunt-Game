package main;

import objects.ObjectBoots;
import objects.ObjectChest;
import objects.ObjectDoor;
import objects.ObjectKey;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp){

        this.gp = gp;

    }

    public void setObject(){
        gp.obj[0] = new ObjectKey(gp);
        gp.obj[0].worldX = 23 * gp.TILE_SIZE;
        gp.obj[0].worldY = 7 * gp.TILE_SIZE;

        gp.obj[1] = new ObjectKey(gp);
        gp.obj[1].worldX = 23 * gp.TILE_SIZE;
        gp.obj[1].worldY = 40 * gp.TILE_SIZE;

        gp.obj[2] = new ObjectKey(gp);
        gp.obj[2].worldX = 38 * gp.TILE_SIZE;
        gp.obj[2].worldY = 8 * gp.TILE_SIZE;

        gp.obj[3] = new ObjectDoor(gp);
        gp.obj[3].worldX = 10 * gp.TILE_SIZE;
        gp.obj[3].worldY = 11 * gp.TILE_SIZE;

        gp.obj[4] = new ObjectDoor(gp);
        gp.obj[4].worldX = 8 * gp.TILE_SIZE;
        gp.obj[4].worldY = 28 * gp.TILE_SIZE;

        gp.obj[5] = new ObjectDoor(gp);
        gp.obj[5].worldX = 12 * gp.TILE_SIZE;
        gp.obj[5].worldY = 22 * gp.TILE_SIZE;

        gp.obj[6] = new ObjectChest(gp);
        gp.obj[6].worldX = 10 * gp.TILE_SIZE;
        gp.obj[6].worldY = 7 * gp.TILE_SIZE;

        gp.obj[7] = new ObjectBoots(gp);
        gp.obj[7].worldX = 37 * gp.TILE_SIZE;
        gp.obj[7].worldY = 42 * gp.TILE_SIZE;
    }

}