package entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenZ;
	
	String lastPressed;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
		screenZ = gp.screenHeight / 2 - (gp.tileSize / 2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 15;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultZ = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 31;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldX = gp.tileSize * 43;
		worldZ = gp.tileSize * 7;
		speed = 4;
		direction = "idle_down";
	}
	
    public void update() {
    	this.playerIdle();
    	this.playerMovement();
    	this.playerWalkAnimation();
	}
	
	public void getPlayerImage() {
		idle_up = setup("steve_idle_up");
		idle_down = setup("steve_idle_down");
		idle_left = setup("steve_idle_left");
		idle_right = setup("steve_idle_right");
		idle_down = setup("steve_idle_down");
		idle_left = setup("steve_idle_left");
		idle_right = setup("steve_idle_right");
		idle_up_left = setup("steve_idle_up_left");
		idle_up_right = setup("steve_idle_up_right");
		idle_down_left = setup("steve_idle_down_left");
		idle_down_right = setup("steve_idle_down_right");
		up1 = setup("steve_up_1");
		up2 = setup("steve_up_2");
		down1 = setup("steve_down_1");
		down2 = setup("steve_down_2");
		left1 = setup("steve_left_1");
		left2 = setup("steve_left_2");
		right1 = setup("steve_right_1");
		right2 = setup("steve_right_2");
		up_left1 = setup("steve_up_left_1");
		up_left2 = setup("steve_up_left_2");
		up_right1 = setup("steve_up_right_1");
		up_right2 = setup("steve_up_right_2");
		down_left1 = setup("steve_down_left_1");
		down_left2 = setup("steve_down_left_2");
		down_right1 = setup("steve_down_right_1");
		down_right2 = setup("steve_down_right_2");
	}
	
	public BufferedImage setup(String imageName) {
		UtilityTool uTool = new UtilityTool();
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName + ".png"));
			image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	public void playerIdle() {
		if(lastPressed == "up_left") {
			direction = "idle_up_left";
		}
		
		if(lastPressed == "up_right") {
			direction = "idle_up_right";
		}
		
		if(lastPressed == "down_left") {
			direction = "idle_down_left";
		}
		
		if(lastPressed == "down_right") {
			direction = "idle_down_right";
		}
		
		if(lastPressed == "up") {
			direction = "idle_up";
		}
		
		if(lastPressed == "down") {
			direction = "idle_down";
		}
		
		if(lastPressed == "left") {
			direction = "idle_left";
		}
		
		if(lastPressed == "right") {
			direction = "idle_right";
		}
	}

	public void playerMovement() {
	    if(keyH.upPressed == true ||
		   keyH.downPressed == true ||
		   keyH.leftPressed == true ||
		   keyH.rightPressed == true) {
	    	collisionOn = false;
	    	if(keyH.upPressed == true && keyH.leftPressed == true) {
	    	   	if(keyH.downPressed == false && keyH.rightPressed == false) {
	    	   		direction = "up_left";
	    	   		lastPressed = "up_left";
	    	   	}
	    	}
			
	    	if(keyH.upPressed == true && keyH.rightPressed == true) {
	    	   	if(keyH.downPressed == false && keyH.leftPressed == false) {
	    	   		direction = "up_right";
	    	   		lastPressed = "up_right";
	    	   	}
	    	}
			
	    	if(keyH.downPressed == true && keyH.leftPressed == true) {
	    	   	if(keyH.upPressed == false && keyH.rightPressed == false) {
	    	   		direction = "down_left";
	    	   		lastPressed = "down_left";
	    	   	}
	    	}
			
	    	if(keyH.downPressed == true && keyH.rightPressed == true) {
	    	   	if(keyH.upPressed == false && keyH.leftPressed == false) {
	    	   		direction = "down_right";
	    	   		lastPressed = "down_right";
	    	   	}
	    	}
			
	    	if(keyH.upPressed == true) {
	    	   	if(keyH.downPressed == false && keyH.leftPressed == false && keyH.rightPressed == false) {	
	    	   		direction = "up";
 	    	   		lastPressed = "up";
	    	   	}
	    	}
			
	    	if(keyH.downPressed == true) {
	    	   	if(keyH.upPressed == false && keyH.leftPressed == false && keyH.rightPressed == false) {
	    	   		direction = "down";
	    	   		lastPressed = "down";
	    	   	}
	    	}
			
	    	if(keyH.leftPressed == true) {
	    	   	if(keyH.upPressed == false && keyH.downPressed == false && keyH.rightPressed == false) {
	    	   		direction = "left";
	    	   		lastPressed = "left";
	    	   	}
	    	}
			
	    	if(keyH.rightPressed == true) {
	    	   	if(keyH.upPressed == false && keyH.downPressed == false && keyH.leftPressed == false) {
	    	   		direction = "right";
	    	   		lastPressed = "right";
	    	   	}
	    	}
	    	
		    // Check tile collision
	    	collisionOn = false;
	    	gp.cChecker.checkTile(this);
	    	
	    	// Check Object collision
	    	int blockIndex = gp.cChecker.checkObject(this,  true);
	    	pickUpObject(blockIndex);
	    	
	    	//If collision is false, player can move
	    	if(collisionOn == false) {
	    		switch(direction) {
		    		case "up_left":
		    			worldX -= speed;
	    	   			worldZ -= speed;
	    			break;
	    			
		    		case "up_right":
		    			worldX += speed;
	    	   			worldZ -= speed;
	    			break;
	    			
		    		case "down_left":
		    			worldX -= speed;
	    	   			worldZ += speed;
	    			break;
	    			
		    		case "down_right":
		    			worldX += speed;
	    	   			worldZ += speed;
	    			break;
	    		
	    			case "up":
	    				worldZ -= speed;
	    			break;
	    			
	    			case "down":
	    				worldZ += speed;
	    			break;
	    			
	    			case "left":
	    				worldX -= speed;
	    			break;
	    			
	    			case "right":
	    				worldX += speed;
	    			break;
	    		}
	    	}
	    }
	}
	
	public void playerWalkAnimation() {
	    spriteCounter++;
	    if(spriteCounter > 15) {
	        if(spriteNum == 1) {
	    	    spriteNum = 2;
	    	}
					
	    	else if(spriteNum == 2) {
	    	   	spriteNum = 1;
	    	}
	    	spriteCounter = 0;
		}
	}
	
	public void pickUpObject(int i) {
		if(i != 999) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch(direction) {
			case "idle_up":
				image = idle_up;
			break;
			
			case "idle_down":
				image = idle_down;
			break;
			
			case "idle_left":
				image = idle_left;
			break;
			
			case "idle_right":
				image = idle_right;
			break;
			
			case "idle_up_left":
				image = idle_up_left;
			break;
			
			case "idle_up_right":
				image = idle_up_right;
			break;
			
			case "idle_down_left":
				image = idle_down_left;
			break;
			
			case "idle_down_right":
				image = idle_down_right;
			break;
		
			case "up":
				if(spriteNum == 1) {
					image = up1;
				}
				if(spriteNum == 2) {
					image = up2;
				}
			break;
		
			case "down":
				if(spriteNum == 1) {
					image = down1;
				}
				if(spriteNum == 2) {
					image = down2;
				}
			break;
		
			case "left":
				if(spriteNum == 1) {
					image = left1;
				}
				if(spriteNum == 2) {
					image = left2;
				}
			break;
		
			case "right":
				if(spriteNum == 1) {
					image = right1;
				}
				if(spriteNum == 2) {
					image = right2;
				}
			break;
		
			case "up_left":
				if(spriteNum == 1) {
					image = up_left1;
				}
				if(spriteNum == 2) {
					image = up_left2;
				}
			break;
			
			case "up_right":
				if(spriteNum == 1) {
					image = up_right1;
				}
				if(spriteNum == 2) {
					image = up_right2;
				}
			break;
			
			case "down_left":
				if(spriteNum == 1) {
					image = down_left1;
				}
				if(spriteNum == 2) {
					image = down_left2;
				}
			break;
			
			case "down_right":
				if(spriteNum == 1) {
					image = down_right1;
				}
				if(spriteNum == 2) {
					image = down_right2;
				}
			break;
		}
		
		g2.drawImage(image, screenX, screenZ, null);
	}
}