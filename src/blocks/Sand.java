package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Sand extends Block{

	public Sand() {
		name = "Sand";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Sand.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}