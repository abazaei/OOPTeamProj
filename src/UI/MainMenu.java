package UI;

import java.awt.Color;

import greenfoot.World;

public class MainMenu extends World {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	private static final int CELL = 1;

	public MainMenu() {
		super(WIDTH,HEIGHT,CELL);
		getBackground().setColor(Color.green);
		getBackground().fill();
	}

	public static void main(String[] args) {
		
	}

}
