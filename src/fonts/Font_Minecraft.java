package fonts;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class Font_Minecraft extends GameFont {

	public Font minecraft_plain, minecraft_bold;
	public String name;
	
	public Font_Minecraft() {
		try {
			stream = getClass().getResourceAsStream("/fonts/minecraft_plain.ttf");
			minecraft_plain = Font.createFont(Font.PLAIN, stream).deriveFont(30F);
			stream = getClass().getResourceAsStream("/fonts/minecraft_bold.otf");
			minecraft_bold = Font.createFont(Font.PLAIN, stream).deriveFont(30F);
		}
		
		catch(FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}