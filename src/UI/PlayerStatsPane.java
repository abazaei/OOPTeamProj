package UI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import player.Player;


public class PlayerStatsPane extends JPanel{
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	
	public PlayerStatsPane(Player player){
		PlayerStatsPane pane = new PlayerStatsPane(player);
		
		JLabel title = new JLabel("Player Stats");
		JLabel name = new JLabel("Will be Player Name");
		
			
		
		
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
