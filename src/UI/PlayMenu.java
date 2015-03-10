package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PlayMenu extends JPanel{
	
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	public String[] tits = {
			"empty","tits","tits2","tits3"
	};
	
	public PlayMenu(){
		
		JPanel playMenu = new JPanel();
		setDesign();
		this.setLayout(new GridLayout());
		
		JComboBox team1 = new JComboBox(tits);
		JComboBox team2 = new JComboBox(tits);
		JLabel title = new JLabel("Play Page");
		JLabel O1 = new JLabel(team1.getSelectedItem() + "'s Offensive score: " + 5);
		JLabel O2 = new JLabel(team2.getSelectedItem() + "'s Offensive score: " + 5);
		JLabel M1 = new JLabel(team1.getSelectedItem() + "'s Mid score: " + 5);
		JLabel M2 = new JLabel(team2.getSelectedItem() + "'s Mid score: " + 5);
		JLabel D1 = new JLabel(team1.getSelectedItem() + "'s Defensive score: " + 5);
		JLabel D2 = new JLabel(team2.getSelectedItem() + "'s Defensive score: " + 5);
		JLabel Total1 = new JLabel(team1.getSelectedItem() + "'s Total score: " + 5);
		JLabel Total2 = new JLabel(team2.getSelectedItem() + "'s Total score: " + 5);
		
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
		
		title.setBounds(100,200,100,45);
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
