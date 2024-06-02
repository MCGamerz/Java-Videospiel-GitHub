package entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Entity {

	public int worldX, worldZ;
	public int speed;
	public BufferedImage idle_up, idle_down, idle_left, idle_right, idle_up_left, idle_up_right, idle_down_left, idle_down_right, up1, up2, down1, down2, left1, left2, right1, right2, up_left1, up_left2, up_right1, up_right2, down_left1, down_left2, down_right1, down_right2;
	public String direction;
	public int spriteCounter = 0;
	public int spriteNum = 1;
	public Rectangle solidArea;
	public int solidAreaDefaultX, solidAreaDefaultZ;
	public boolean collisionOn = false;
}
