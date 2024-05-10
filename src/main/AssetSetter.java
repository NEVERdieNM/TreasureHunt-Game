package main;

import objects.ObjectAxe;
import objects.ObjectBoots;
import objects.ObjectBranches;
import objects.ObjectChest;
import objects.ObjectDoor;
import objects.ObjectKey;

public class AssetSetter {
    
    GamePanel gp;

    public AssetSetter(GamePanel gp){

        this.gp = gp;

    }

    public void setObject(){
        gp.obj[0] = new ObjectAxe(gp);
        gp.obj[0].worldX = 23 * gp.TILE_SIZE;
        gp.obj[0].worldY = 7 * gp.TILE_SIZE;

        gp.obj[1] = new ObjectAxe(gp);
        gp.obj[1].worldX = 38 * gp.TILE_SIZE;
        gp.obj[1].worldY = 9 * gp.TILE_SIZE;

        gp.obj[2] = new ObjectKey(gp);
        gp.obj[2].worldX = 23 * gp.TILE_SIZE;
        gp.obj[2].worldY = 40 * gp.TILE_SIZE;

        gp.obj[3] = new ObjectDoor(gp);
        gp.obj[3].worldX = 10 * gp.TILE_SIZE;
        gp.obj[3].worldY = 12 * gp.TILE_SIZE;

        gp.obj[4] = new ObjectBranches(gp);
        gp.obj[4].worldX = 8 * gp.TILE_SIZE;
        gp.obj[4].worldY = 28 * gp.TILE_SIZE;

        gp.obj[5] = new ObjectBranches(gp);
        gp.obj[5].worldX = 12 * gp.TILE_SIZE;
        gp.obj[5].worldY = 23 * gp.TILE_SIZE;

        gp.obj[6] = new ObjectChest(gp);
        gp.obj[6].worldX = 10 * gp.TILE_SIZE;
        gp.obj[6].worldY = 7 * gp.TILE_SIZE;

        gp.obj[7] = new ObjectBoots(gp);
        gp.obj[7].worldX = 37 * gp.TILE_SIZE;
        gp.obj[7].worldY = 42 * gp.TILE_SIZE;
    }

}