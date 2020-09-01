package net.svenwollinger.roads;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{

	boolean lock = false;
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		k(arg0);
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) { }
	
	@Override
	public void keyTyped(KeyEvent arg0) { }
	
	public void k(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) {
			if(Main.x > 0)
				Main.x--;
		} else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(Main.x < Main.render.w-1)
				Main.x++;
		} else if(arg0.getKeyCode() == KeyEvent.VK_UP) {
			if(Main.y > 0)
				Main.y--;
		} else if(arg0.getKeyCode() == KeyEvent.VK_DOWN) {
			if(Main.y < Main.render.h-1)
				Main.y++;
		} else {
			int x = Main.x;
			int y = Main.y;
			Main.render.map[x][y] = !Main.render.map[x][y];
		}
		
	}
}
