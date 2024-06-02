package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entities.Player;
import items.Item;
import tiles.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	// Screen Settings
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 4;
	
	public final int tileSize = originalTileSize * scale; // 48x48 tile
	public int maxScreenCol = 16;
	public int maxScreenRow = 9;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public final int screenHeight = tileSize * maxScreenRow; // 432 pixels
	
	// World Settings
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	// For full screen
	int screenWidth2 = screenWidth;
	int screenHeight2 = screenHeight;
	
	// FPS
	int FPS = 60;
	
	// System
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler(this);
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	// Entity and Item
	public Player player = new Player(this, keyH);
	public Item item[] = new Item[10];
	
	// Game state
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		gameState = playState;
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		while(gameThread != null) {
			
			double drawInterval = 1000000000 / FPS;
			double delta = 0;
			long lastTime = System.nanoTime();
			long currentTime;
			long timer = 0;
			//int drawCount = 0;
			
			while(gameThread != null) {
				
				currentTime = System.nanoTime();
				
				delta += (currentTime - lastTime) / drawInterval;
				timer += (currentTime - lastTime);
				lastTime = currentTime;
				
				if(delta >= 1) {
					// 1 UPDATE: Update information such as character positions
					update();
					// 2 DRAW: Draw the screen with the updated information
					repaint();
					delta--;
					//drawCount++;
				}
				
				if(timer >= 1000000000) {
					/*System.out.println("FPS:" + drawCount);
					drawCount = 0;*/
					timer = 0;
				}
			}
		}
	}
	
	public void update() {
		if(gameState == playState) {
			player.update();
		}
		
		if(gameState == pauseState) {
			
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		// Debug
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();
		}	
		
		// Tile
		tileM.draw(g2);
		
		// Item
		for(int i = 0; i< item.length; i++) {
			if(item[i] != null) {
				item[i].draw(g2, this);
			}
		}
		
		// Player
		player.draw(g2);
		
		// UI
		ui.draw(g2);
		
		// Debug
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
			System.out.println("Draw Time: " + passed);
		}
		
		g2.dispose();
	}
}