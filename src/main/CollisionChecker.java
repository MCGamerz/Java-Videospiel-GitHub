package main;

import entities.Entity;

public class CollisionChecker {
	
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entity entity) {
		int entityLeftWorldX = entity.worldX + entity.solidArea.x;
		int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width - 1;
		int entityTopWorldZ = entity.worldZ + entity.solidArea.y;
		int entityBottomWorldZ = entity.worldZ + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX/gp.tileSize;
		int entityRightCol = entityRightWorldX/gp.tileSize;
		int entityTopRow = entityTopWorldZ/gp.tileSize;
		int entityBottomRow = entityBottomWorldZ/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
			case "up":
				entityTopRow = (entityTopWorldZ - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
				}
			break;
			
			case "down":
				entityBottomRow = (entityBottomWorldZ + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
				}
			break;
				
			case "left":
				entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
				}
			break;
			
			case "right":
				entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
					entity.collisionOn = true;
				}
			break;
			
			case "up_left":
				entityTopRow = (entityTopWorldZ - entity.speed)/gp.tileSize;
				entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
				if(gp.tileM.tile[tileNum1].collision == true) {
					entity.collisionOn = true;
				}
			break;
			
			case "up_right":
				entityTopRow = (entityTopWorldZ - entity.speed)/gp.tileSize;
				entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
				if(gp.tileM.tile[tileNum1].collision == true) {
					entity.collisionOn = true;
				}
			break;
			
			case "down_left":
				entityBottomRow = (entityBottomWorldZ + entity.speed)/gp.tileSize;
				entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collision == true) {
					entity.collisionOn = true;
				}
			break;
			
			case "down_right":
				entityBottomRow = (entityBottomWorldZ + entity.speed)/gp.tileSize;
				entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
				if(gp.tileM.tile[tileNum1].collision == true) {
					entity.collisionOn = true;
				}
			break;
		}
	}
	
	public int checkObject(Entity entity, boolean player) {
		int index = 999;
		
		for(int i = 0; i < gp.item.length; i++) {
			if(gp.item[i] != null) {
				// Get entity's solid area position
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldZ + entity.solidArea.y;
				
				// Get the object's solid area position
				gp.item[i].solidArea.x = gp.item[i].worldX + gp.item[i].solidArea.x;
				gp.item[i].solidArea.y = gp.item[i].worldZ + gp.item[i].solidArea.y;
				
				switch(entity.direction) {
					case "up_left":
						entity.solidArea.x -= entity.speed;
						entity.solidArea.y -= entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
					
					case "up_right":
						entity.solidArea.x += entity.speed;
						entity.solidArea.y -= entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
					
					case "down_left":
						entity.solidArea.x -= entity.speed;
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
					
					case "down_right":
						entity.solidArea.x += entity.speed;
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
				
					case "up":
						entity.solidArea.y -= entity.speed;
						
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
					
					case "down":
						entity.solidArea.y += entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
					
					case "left":
						entity.solidArea.x -= entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
					
					case "right":
						entity.solidArea.x += entity.speed;
						if(entity.solidArea.intersects(gp.item[i].solidArea)) {
							if(gp.item[i].collision == true) {
								entity.collisionOn = true;
							}
							
							if(player == true) {
								index = i;
							}
						}
					break;
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultZ;
				gp.item[i].solidArea.x = gp.item[i].solidAreaDefaultX;
				gp.item[i].solidArea.y = gp.item[i].solidAreaDefaultZ;
			}
		}
		
		return index;
	}
}