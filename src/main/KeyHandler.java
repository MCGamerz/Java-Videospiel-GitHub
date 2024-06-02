package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	// Debug
	boolean checkDrawTime = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public synchronized void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}

		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}

		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		
		if(code == KeyEvent.VK_ESCAPE) {
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
			}
			
			else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
			}
		}
		
		// Debug
		if(code == KeyEvent.VK_F3) {
			if(checkDrawTime == false) {
				checkDrawTime = true;
			}
			
			else if(checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}

		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}

		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
	}
}
