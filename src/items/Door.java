package items;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Door extends Item {
	
	GamePanel gp;
	
	public Door(GamePanel gp) {
		name = "Door";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Door.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}