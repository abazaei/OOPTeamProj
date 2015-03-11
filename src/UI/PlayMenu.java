package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PlayMenu extends JPanel{
	
	protected static final int WIDTH = 500;
	protected static final int HEIGHT = 600;
	public String[] bits = {
			"empty","bits","bits2","bits3"
	};
	
	public PlayMenu(){
		
		JPanel playMenu = new JPanel();
		setDesign();
		this.setLayout(null);
		
		
		JComboBox team1 = new JComboBox(bits);
		@SuppressWarnings("unchecked")
		JComboBox team2 = new JComboBox(bits);
		JLabel title = new JLabel("Play Page");
		JLabel O1 = new JLabel(team1.getSelectedItem() + "'s Offensive score: " + 5);
		JLabel O2 = new JLabel(team2.getSelectedItem() + "'s Offensive score: " + 5);
		JLabel M1 = new JLabel(team1.getSelectedItem() + "'s Mid score: " + 5);
		JLabel M2 = new JLabel(team2.getSelectedItem() + "'s Mid score: " + 5);
		JLabel D1 = new JLabel(team1.getSelectedItem() + "'s Defensive score: " + 5);
		JLabel D2 = new JLabel(team2.getSelectedItem() + "'s Defensive score: " + 5);
		JLabel Total1 = new JLabel(team1.getSelectedItem() + "'s Total score: " + 5);
		JLabel Total2 = new JLabel(team2.getSelectedItem() + "'s Total score: " + 5);
		JButton run = new JButton("Run Simulation");
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		this.add(team1);
		this.add(team2);
		this.add(title);
		this.add(O1);
		this.add(O2);
		this.add(M1);
		this.add(M2);
		this.add(D1);
		this.add(D2);
		this.add(Total1);
		this.add(Total2);
		this.add(run);
		
		title.setBounds(225,50,100,45);
		team1.setBounds(75, 100, 150, 35);
		O1.setBounds(75, 150, 150, 35);
		M1.setBounds(75, 200, 150, 35);
		D1.setBounds(75, 250, 150, 35);
		Total1.setBounds(75, 300, 150, 35);
		team2.setBounds(275, 100, 150, 35);
		O2.setBounds(275, 150, 150, 35);
		M2.setBounds(275, 200, 150, 35);
		D2.setBounds(275, 250, 150, 35);
		Total2.setBounds(275, 300, 150, 35);
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

}
