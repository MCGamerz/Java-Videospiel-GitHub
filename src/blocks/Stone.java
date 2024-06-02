package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Stone extends Block{

	public Stone() {
		name = "Stone";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Stone.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}