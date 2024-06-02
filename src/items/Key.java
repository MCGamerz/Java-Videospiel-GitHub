package items;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Key extends Item {
	
	GamePanel gp;
	
	public Key(GamePanel gp) {
		name = "Key";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/key.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}