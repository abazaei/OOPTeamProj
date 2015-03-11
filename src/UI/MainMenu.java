package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import JSONstuff.JSONManager;



public class MainMenu extends JFrame{

	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	private static final Dimension DIMENSION = new Dimension(WIDTH,HEIGHT);

	public MainMenu() {
		JFrame frame = new JFrame();
		setDesign();
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		JPanel panel = new JPanel();
		JLabel title = new JLabel("Soccer Simulator");
		JButton play = new JButton("Play");
		JButton create = new JButton("Create");
		JButton playerCatalog = new JButton("Player Catalog");
		panel.setLayout(null);
		panel.setPreferredSize(DIMENSION);
		
		panel.add(play);
		panel.add(create);
		panel.add(playerCatalog);
		panel.add(title);
		
		
		play.setBounds(75, 250, 150, 50);
		create.setBounds(275, 250, 150, 50);
		playerCatalog.setBounds(175, 375, 150, 50);
		//title.setPreferredSize(FONT_SIZE);
		title.setBounds(200, 25, 100, 50);
		frame.setContentPane(new Catalog()); 
		frame.pack();
		//frame.getContentPane().add(new PlayMenu());
	}
	public static void main(String[] args) {
		MainMenu main = new MainMenu();
	}
	
	private final static void setDesign(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
