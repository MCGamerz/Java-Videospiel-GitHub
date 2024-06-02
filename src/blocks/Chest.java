package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Chest extends Block{

	public Chest() {
		name = "Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/chest.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}