package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends Block{

	public Door() {
		name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/door.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		collision = true;
	}
}