package blocks;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Oak_Log extends Block{

	public Oak_Log() {
		name = "Oak_Log";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/blocks/Oak_Log.png"));
			
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}