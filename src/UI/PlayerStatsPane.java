package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import player.Forward;
import player.Player;
import player.Position;


public class PlayerStatsPane extends JPanel{
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	//protected Player chosenPlayer = null;

	public PlayerStatsPane(Player player){
		
		PlayerStatsPane pane = new PlayerStatsPane(player);
		JLabel title = new JLabel(player.getName());
		JLabel position = new JLabel("Position played: " + player.getPosition().toString());
		JLabel age = new JLabel("Player age: " + player.getAge());
		setStats(player, pane);
	}

	private final static void setDesign(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
	}

	private void setStats(Player player,JPanel pane){
		
	}
}
