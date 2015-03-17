package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import teams.Team;


public class MainMenu extends JFrame{
	
	public static int gameTime = 0;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	private static final Dimension DIMENSION = new Dimension(WIDTH,HEIGHT);
	private playListener plistener = new playListener();
	private catalogListener clistener = new catalogListener();

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

		play.addActionListener(plistener);
		playerCatalog.addActionListener(clistener);

		panel.add(play);
		panel.add(create);
		panel.add(playerCatalog);
		panel.add(title);

		play.setBounds(75, 250, 150, 50);
		create.setBounds(275, 250, 150, 50);
		playerCatalog.setBounds(175, 375, 150, 50);
		title.setBounds(200, 25, 100, 50);
		frame.setContentPane(panel); 
		frame.pack();

	}
	public static void main(String[] args) {
		MainMenu main = new MainMenu();
		while(true) {
			long millis = System.currentTimeMillis();
			gameTime++; //Seconds in the game passed
			try {
				Thread.sleep(1000 - millis % 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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

	private class playListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new JFrame();
			setDesign();
			frame.setSize(WIDTH,HEIGHT);
			frame.setVisible(true);
			frame.setContentPane(new PlayMenu(frame));
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setLayout(null);
			frame.pack();

		}

	}

	private class catalogListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new JFrame();
			setDesign();
			frame.setSize(WIDTH,HEIGHT);
			frame.setVisible(true);
			frame.setContentPane(new Catalog());
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setLayout(null);
			frame.pack();

		}

	}

}
