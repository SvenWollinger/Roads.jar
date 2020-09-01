package net.svenwollinger.roads;
import javax.swing.JFrame;

public class Main {
	
	public static Render render;
	public static JFrame wnd;
	
	public static int x = 0;
	public static int y = 0;
	
	public static void main(String[] args) {
		wnd = new JFrame();
		wnd.setSize(512,512);
		render = new Render();
		wnd.add(render);
		wnd.addKeyListener(new KeyInput());
		wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wnd.setVisible(true);
	}

}
