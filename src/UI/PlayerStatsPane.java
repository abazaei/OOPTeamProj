package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
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
		
//		PlayerStatsPane pane = new PlayerStatsPane(player);
		JPanel panel = new JPanel();
		this.setLayout(null);
		JLabel title = new JLabel(player.getName());
		JLabel position = new JLabel("Position played: " + player.getPosition());
		JLabel age = new JLabel("Player age: " + player.getAge());
		JLabel skill = new JLabel("Player skill: " + player.getSkill());
		JLabel club = new JLabel("Player club: " + player.getClub());
		JLabel nationality = new JLabel("Player nationality: " + player.getNationality());
		
		add(title);
		add(position);
		add(age);
		add(skill);
		add(club);
		add(nationality);
		
		title.setBounds(200,10,100,100);
		position.setBounds(100,150,200,100);
		age.setBounds(100,200,200,100);
		skill.setBounds(100,250,200,100);
		club.setBounds(100,300,200,100);
		nationality.setBounds(100,350,200,100);
		
		
		
		
		
	}

	private final static void setDesign(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			
			e.printStackTrace();
		}
	}
	
}
