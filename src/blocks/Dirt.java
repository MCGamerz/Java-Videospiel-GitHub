package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Dirt extends Block{

	public Dirt() {
		name = "Dirt";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/dirt.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}