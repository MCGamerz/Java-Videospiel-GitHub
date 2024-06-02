package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Grass_Block extends Block{

	public Grass_Block() {
		name = "Grass_Block";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Grass_Block.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}