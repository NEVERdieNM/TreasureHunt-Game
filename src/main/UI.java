package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import objects.ObjectKey;

public class UI{

    GamePanel gp;
    Font arial40;
    BufferedImage keyImage;

    public boolean messageOn;
    public String message = "";
    int messageCounter = 0;

    public boolean gameFinished = false;

    double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp){

        this.gp = gp;
        arial40 = new Font("Arial", Font.BOLD, 40);
        ObjectKey key = new ObjectKey(gp);
        keyImage = key.image;
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        //GAME OVER
        if(gameFinished){
            
            g2.setFont(arial40);
            g2.setColor(Color.white);

            String text = "You found the Treasure!";
            int textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x = gp.SCREEN_WIDTH/2 - textLenght/2;
            int y = gp.SCREEN_HEIGHT/2 - gp.TILE_SIZE*2;

            g2.drawString(text, x, y);

            //PLAYTIME
            g2.setFont(g2.getFont().deriveFont(30f));
            g2.setColor(Color.green);
            text = "Playtime: " + dFormat.format(playTime);
            textLenght = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.SCREEN_WIDTH/2 - textLenght/2;
            y += gp.TILE_SIZE;
            
            g2.drawString(text, x, y);;

            gp.gameThread = null;
            
        }
        else {

            //KEYCOUNTER UI
            for(int i = 0; i < gp.player.keyCount; i++){
                g2.drawImage(keyImage, gp.TILE_SIZE * i + gp.TILE_SIZE/2, gp.TILE_SIZE/2, (gp.TILE_SIZE/3)*5, (gp.TILE_SIZE/3)*5, null);
            }
        
            //PLAYTIME
            playTime += (double)1/60;
            int timerOffset = 1;
            if((int)playTime > 9 && (int)playTime < 100){
                timerOffset = 2;
            }else if((int)playTime > 99){
                timerOffset = 3;
            }
            

            g2.setFont(g2.getFont().deriveFont(40f));
            g2.setColor(Color.green);
            g2.drawString(Integer.toString((int)playTime), gp.SCREEN_WIDTH - timerOffset*gp.TILE_SIZE/2 - gp.TILE_SIZE/2, gp.TILE_SIZE);

            //MESSAGE
            if(messageOn){

                g2.setFont(g2.getFont().deriveFont(20f).deriveFont(Font.BOLD));
                g2.setColor(Color.white);
                g2.drawString(message, gp.SCREEN_WIDTH/2 - message.length()*5, gp.SCREEN_HEIGHT/2 - gp.TILE_SIZE);
                messageCounter++;
                if(messageCounter == 120){
                    messageOn = false;
                    messageCounter = 0;
                }
            }

        }
    }

}