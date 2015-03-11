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
		this.setPreferredSize(new Dimension(500,600));
		this.add(teamBox);
		this.add(title);
		this.add(teams);
		
		title.setBounds(850,50,100,45);
		teamBox.setBounds(800,100,100,45);
		teams.setBounds(725,100,100,45);
		

	}


	public class ComboBoxListener implements ActionListener {





		@Override
		public void actionPerformed(ActionEvent e) {
			
		}



	}


}
