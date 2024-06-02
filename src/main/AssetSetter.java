package main;

import items.Boots;
import items.Chest;
import items.Door;
import items.Key;

public class AssetSetter {

	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.item[0] = new Key(gp);
		gp.item[0].worldX = 22 * gp.tileSize;
		gp.item[0].worldZ = 9 * gp.tileSize;

		gp.item[1] = new Door(gp);
		gp.item[1].worldX = 11 * gp.tileSize;
		gp.item[1].worldZ = 8 * gp.tileSize;

		gp.item[2] = new Boots(gp);
		gp.item[2].worldX = 15 * gp.tileSize;
		gp.item[2].worldZ = 7 * gp.tileSize;

		gp.item[3] = new Chest(gp);
		gp.item[3].worldX = 11 * gp.tileSize;
		gp.item[3].worldZ = 3 * gp.tileSize;
	}
}