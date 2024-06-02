package items;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.UtilityTool;

public abstract class Item {

	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldZ;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultZ = 0;
	UtilityTool uTool = new UtilityTool();
	
	public void draw(Graphics2D g2, GamePanel gp) {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenZ = worldZ - gp.player.worldZ + gp.player.screenZ;
		
		if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
		   worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
		   worldZ + gp.tileSize > gp.player.worldZ - gp.player.screenZ &&
		   worldZ - gp.tileSize < gp.player.worldZ + gp.player.screenZ) {
			g2.drawImage(image, screenX, screenZ, gp.tileSize, gp.tileSize, null);
		}
	}
}