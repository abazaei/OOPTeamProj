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



public class Catalog extends JPanel {
	
	public String [] teamNames = { "FC Barc", "Liverpool", "Man U", "Bayer Munchen"};

	public  Catalog(){

	

		JPanel panel = new JPanel();
		this.setLayout(null);
		
		JComboBox teamBox = new JComboBox(teamNames);
		teamBox.setSelectedItem(6);
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


	public class ComboBoxListener implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			JButton button1 = new JButton();
			JButton button2 = new JButton();
			JButton button3 = new JButton();
			JButton button4 = new JButton();
			JButton button5 = new JButton();
			JButton button6 = new JButton();
			JButton button7 = new JButton();
			JButton button8 = new JButton();
			JButton button9 = new JButton();
			JButton button10 = new JButton();
			JButton button11 = new JButton();
			
			
			add(button1);
			add(button2);
			add(button3);
			add(button4);
			add(button5);
			add(button6);
			add(button7);
			add(button8);
			add(button9);
			add(button10);
			add(button11);
			
			button1.setBounds(150, 150,100,30);
			button2.setBounds(150, 190,100,30);
			button3.setBounds(150,240,100,30);
			button4.setBounds(150, 280,100,30);
			button5.setBounds(150, 320,100,30);
			button6.setBounds(150, 360,100,30);
			button7.setBounds(150, 400,100,30);
			button8.setBounds(150, 440,100,30);
			button9.setBounds(150, 480,100,30);
			button10.setBounds(150, 520,100,30);
			button11.setBounds(150, 560,100,30);
			
			
			
			
			
				
			}
		}



	}



