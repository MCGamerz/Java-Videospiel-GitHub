package items;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Boots extends Item {
	
	GamePanel gp;
	
	public Boots(GamePanel gp) {
		name = "Boots";
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Boots.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}