package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int SCREEN_X, SCREEN_Y;

    public int keyCount = 0;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;

        SCREEN_X = gp.SCREEN_WIDTH/2 - (gp.TILE_SIZE/2);
        SCREEN_Y = gp.SCREEN_HEIGHT/2 - (gp.TILE_SIZE/2);

        solidArea = new Rectangle(8, 28, 28, 16);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){

        this.worldX = 23 * gp.TILE_SIZE;
        this.worldY = 21 * gp.TILE_SIZE;
        this.speed = 3 * gp.SCALE / 3;
        this.direction = "down";

    }

    public void getPlayerImage(){

        up1 = setup("boy_up_1");
        up2 = setup("boy_up_2");
        down1 = setup("boy_down_1");
        down2 = setup("boy_down_2");
        left1 = setup("boy_left_1");
        left2 = setup("boy_left_2");
        right1 = setup("boy_right_1");
        right2 = setup("boy_right_2");
    }

    public BufferedImage setup(String imageName){
        
        UtilityTool uTool = new UtilityTool();
        BufferedImage scaledImage = null;

        try{

        scaledImage = uTool.scaleImage(ImageIO.read(new File("res/player/" + imageName + ".png")), gp.TILE_SIZE, gp.TILE_SIZE);

        }catch(IOException e){
            e.printStackTrace();
        }

        return scaledImage;
    }

    public void update(){

        if(keyH.wPressed || keyH.sPressed || keyH.aPressed || keyH.dPressed){

            if(keyH.wPressed){
                direction = "up";
            }
            else if(keyH.sPressed){
                direction = "down";
            }
            else if(keyH.aPressed){
                direction = "left";
            }
            else if(keyH.dPressed){
                direction = "right";
            }
    
            //CHECK TILE COLLISION
            collisionOn = false;
            gp.collisionC.checkTile(this);

            //CHECK OBJECT COLLISION
            int objIndexx = gp.collisionC.checkObject(this, true);
            interactWithObject(objIndexx);

            //IF COLLSION IS FALSE PLAYER CAN MOVE 
            if(collisionOn == false){

                switch (direction) {
                    case "up":
                        this.worldY -= this.speed;
                        break;
                    case "down":
                        this.worldY += this.speed;
                        break;
                    case "left":
                        this.worldX -= this.speed;
                        break;
                    case "right":
                        this.worldX += this.speed;
                        break;
    
                }
            }

            spriteCounter++;
            if(spriteCounter >= 14){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

    }

    public void interactWithObject(int index){

        if(index != 999){
            
            String objectName = gp.obj[index].name;

            switch (objectName) {
                case "key":
                    gp.ui.showMessage("I found a key!");
                    gp.playSoundEffect(1);
                    keyCount++;
                    gp.obj[index] = null;
                    break;
                case "door":
                    if(keyCount > 0){
                        gp.ui.showMessage("Door unlocked!");
                        gp.playSoundEffect(3);
                        gp.obj[index] = null;
                        keyCount--;
                    }else{
                        gp.ui.showMessage("I need a key!");
                    }
                    break;
                case "boots":
                    gp.ui.showMessage("WOW, now I'm fast!");
                    gp.playSoundEffect(2);
                    speed += 1;
                    gp.obj[index] = null;
                    break;
                case "chest":
                    gp.ui.gameFinished = true;
                    gp.stopMusic();
                    gp.playSoundEffect(4);
                    break;
            }

        }

    }

    public void draw(Graphics2D g2){
        
        BufferedImage image = null;

        switch (direction) {

            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                else if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down": 
                if(spriteNum == 1){
                    image = down1;
                }
                else if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                else if(spriteNum == 2){
                    image = right2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                else if(spriteNum == 2){
                    image = left2;
                }
                break;

        }

        g2.drawImage(image, SCREEN_X, SCREEN_Y, null);

    }

}
