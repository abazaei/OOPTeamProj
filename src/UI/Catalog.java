package UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import player.Player;
import teams.Team;



public class Catalog extends JPanel {

	public String [] teamNames = { "Empty","Barcelona","RealMadrid","PSG","Chelsea"};
	Team team = new Team();
	JComboBox teamBox = new JComboBox(teamNames);
	
	public  Catalog(){



		JPanel panel = new JPanel();
		this.setLayout(null);

		JLabel title = new JLabel(" Player Catalog");
		JLabel teams = new JLabel(" Selected Team ");
		JLabel players = new JLabel("Players: ");
		this.setPreferredSize(new Dimension(500,600));
		this.add(teamBox);
		this.add(title);
		this.add(teams);
		this.add(players);

		title.setBounds(200,10,100,45);
		teamBox.setBounds(180,70,100,45);
		teams.setBounds(100,70,100,45);
		players.setBounds(100,150,100,45);
		teamBox.addActionListener(new ComboBoxListener());


	}

	public Player findPlayer(JButton button){
		Player [] players = Team.teams.get(teamBox.getSelectedItem());
		Player finalPlayer = null;
		for(Player p : players){
			if(p.getName() == button.getText()){
				finalPlayer = p;

			}
		}

		return finalPlayer;


	}


	public class ComboBoxListener implements ActionListener {


		public void actionPerformed(ActionEvent e) {
			Player [] players = Team.teams.get(teamBox.getSelectedItem());
			int y = 150;

			for(Player p : players){
				JButton button = new JButton(p.getName());
				add(button);
				button.setBounds(150, y,100,30);
				y+=40;
				button.addActionListener(new ButtonListener());
			}
			


		}


	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Player p = findPlayer((JButton) e.getSource());
			JFrame frame = new JFrame();

			frame.setSize(500,600);
			frame.setVisible(true);
			frame.setContentPane(new PlayerStatsPane(p));
			
			frame.setLayout(null);
			

			
		}
		
	}




}



