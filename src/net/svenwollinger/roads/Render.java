package net.svenwollinger.roads;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Render extends JPanel{
	private static final long serialVersionUID = -6319199314679703103L;
	
	final int w = 25;
	final int h = 25;
	
	public boolean[][] map = new boolean[w][h];
	int tileSize = 64;
	
	public void paint(Graphics g) {
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				Image img = null;
				if(!map[x][y]) {
					img = grass; 
				} else if (map[x][y]) {
					boolean t = t(x,y-1);
					boolean b = t(x,y+1);
					boolean l = t(x-1,y);
					boolean r = t(x+1,y);
					
					if(img == null) if(!t && !b && !l && !r) img = end;
					if(img == null) if( t &&  b &&  l &&  r) img = cross;
					
					if(img == null) if(!t && !b &&  l &&  r) img = straight_horizontal;
					if(img == null) if(!t && !b &&  l && !r) img = end_right;
					if(img == null) if(!t && !b && !l &&  r) img = end_left;
					
					if(img == null) if( t &&  b && !l && !r) img = straight_vertical;
					if(img == null) if( t && !b && !l && !r) img = end_bottom;
					if(img == null) if(!t &&  b && !l && !r) img = end_top;
					
					if(img == null) if(!t &&  b &&  l && !r) img = corner_topright;
					if(img == null) if(!t &&  b && !l &&  r) img = corner_topleft;
					
					if(img == null) if( t && !b && !l &&  r) img = corner_bottomleft;
					if(img == null) if( t && !b &&  l && !r) img = corner_bottomright;
					
					if(img == null) if( t && !b &&  l &&  r) img = junc_top;
					if(img == null) if(!t &&  b &&  l &&  r) img = junc_bottom;
					if(img == null) if( t &&  b &&  l && !r) img = junc_left;
					if(img == null) if( t &&  b && !l &&  r) img = junc_right;
				}
				g.drawImage(img, x*tileSize, y*tileSize, tileSize, tileSize, null);
				g.drawRect(x*tileSize, y*tileSize, tileSize, tileSize);
				
			}
		}
		
		g.setColor(Color.YELLOW);
		g.drawRect(Main.x * tileSize, Main.y * tileSize, tileSize, tileSize);
		g.setColor(Color.BLACK);
		
		Main.wnd.repaint();
	}

	public boolean t(int x, int y) {
		boolean returnVal = false;
		if(x >= 0 && y >= 0 && x < Main.render.w && y - 1 < Main.render.h - 1) returnVal = map[x][y];
		return returnVal;
	}
	
	public Image grass = new ImageIcon(getClass().getResource("/res/terrainTile3.png")).getImage();
	public Image end = new ImageIcon(getClass().getResource("/res/end.png")).getImage();
	public Image cross = new ImageIcon(getClass().getResource("/res/cross.png")).getImage();

	
	public Image straight_horizontal = new ImageIcon(getClass().getResource("/res/straight_horizontal.png")).getImage();
	public Image end_right = new ImageIcon(getClass().getResource("/res/end_right.png")).getImage();
	public Image end_left = new ImageIcon(getClass().getResource("/res/end_left.png")).getImage();
	
	public Image straight_vertical = new ImageIcon(getClass().getResource("/res/straight_vertical.png")).getImage();
	public Image end_top = new ImageIcon(getClass().getResource("/res/end_top.png")).getImage();
	public Image end_bottom = new ImageIcon(getClass().getResource("/res/end_bottom.png")).getImage();
	
	public Image corner_bottomleft = new ImageIcon(getClass().getResource("/res/corner_bottomleft.png")).getImage();
	public Image corner_bottomright = new ImageIcon(getClass().getResource("/res/corner_bottomright.png")).getImage();
	public Image corner_topleft = new ImageIcon(getClass().getResource("/res/corner_topleft.png")).getImage();
	public Image corner_topright = new ImageIcon(getClass().getResource("/res/corner_topright.png")).getImage();
	
	public Image junc_bottom = new ImageIcon(getClass().getResource("/res/junc_bottom.png")).getImage();
	public Image junc_left = new ImageIcon(getClass().getResource("/res/junc_left.png")).getImage();
	public Image junc_top = new ImageIcon(getClass().getResource("/res/junc_top.png")).getImage();
	public Image junc_right = new ImageIcon(getClass().getResource("/res/junc_right.png")).getImage();
	
}
