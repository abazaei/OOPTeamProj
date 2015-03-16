package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import teams.Team;

public class PlayMenu extends JPanel{
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	private Team team = new Team();
	public String[] teams = {
			team.Barcelona[0].getClub(), team.PSG[0].getClub(), team.RealMadrid[0].getClub()
	};
	JComboBox team1 = new JComboBox(teams);
	@SuppressWarnings("unchecked")
	JComboBox team2 = new JComboBox(teams);
	JPanel playMenu = new JPanel();
	Boolean filled = false;
	
	public PlayMenu(){
			
		setDesign();
		this.setLayout(null);
				
		JLabel title = new JLabel("Play Page");
		
		JButton run = new JButton("Run Simulation");
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
				
		this.add(title);
		this.add(run);
		this.add(team1);
		this.add(team2);
		team1.addActionListener(new listener());
		team2.addActionListener(new listener());
		
		team1.setBounds(75, 100, 150, 35);
		team2.setBounds(275, 100, 150, 35);
		title.setBounds(225,50,100,45);
		run.setBounds(150, 400, 200, 100);
				
		setFocusable(true);
		
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		
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
	
	private class listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
						
			JLabel O1 = new JLabel(team1.getSelectedItem() + "'s Offensive score: " + );
			JLabel O2 = new JLabel(team2.getSelectedItem() + "'s Offensive score: " + 5);
			JLabel M1 = new JLabel(team1.getSelectedItem() + "'s Mid score: " + 5);
			JLabel M2 = new JLabel(team2.getSelectedItem() + "'s Mid score: " + 5);
			JLabel D1 = new JLabel(team1.getSelectedItem() + "'s Defensive score: " + 5);
			JLabel D2 = new JLabel(team2.getSelectedItem() + "'s Defensive score: " + 5);
			JLabel Total1 = new JLabel(team1.getSelectedItem() + "'s Total score: " + 5);
			JLabel Total2 = new JLabel(team2.getSelectedItem() + "'s Total score: " + 5);
							
			add(O1);
			add(O2);
			add(M1);
			add(M2);
			add(D1);
			add(D2);
			add(Total1);
			add(Total2);
			filled = true;
								
			O1.setBounds(75, 150, 150, 35);
			M1.setBounds(75, 200, 150, 35);
			D1.setBounds(75, 250, 150, 35);
			Total1.setBounds(75, 300, 150, 35);
			O2.setBounds(275, 150, 150, 35);
			M2.setBounds(275, 200, 150, 35);
			D2.setBounds(275, 250, 150, 35);
			Total2.setBounds(275, 300, 150, 35);
			
		}
	}
}
