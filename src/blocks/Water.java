package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends Block{

	public Water() {
		name = "Water";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Water.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}