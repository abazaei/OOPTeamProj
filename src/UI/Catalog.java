package UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class Catalog extends JPanel {

	

	public  Catalog(){

	

		JPanel panel = new JPanel();
		this.setLayout(null);
		
		JComboBox teamBox = new JComboBox();
		teamBox.setSelectedItem(6);
		JLabel title = new JLabel(" Player Catalog");
		JLabel teams = new JLabel(  " Our Teams ");
		JLabel players = new JLabel("Players: ");
		this.setPreferredSize(new Dimension(PlayMenu.WIDTH,PlayMenu.HEIGHT));
		this.add(teamBox);
		this.add(title);
		this.add(teams);
		this.add(players);
		
		title.setBounds(200,10,100,45);
		teamBox.setBounds(180,70,100,45);
		teams.setBounds(100,70,100,45);
		players.setBounds(100,150,100,45);
		

	}


	public class ComboBoxListener implements ActionListener {





		@Override
		public void actionPerformed(ActionEvent e) {
			
		}



	}


}
