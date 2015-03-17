package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import player.Player;
import teams.Team;

public class PlayMenu extends JPanel{

	Random randomn = new Random();
	private static final int WIDTH = 500;
	private static final int HEIGHT = 600;
	private Team team = new Team();
	public String[] teamNames = {
			"Empty","Barcelona","RealMadrid","PSG","Chelsea"
	};
	JComboBox team1 = new JComboBox(teamNames);
	@SuppressWarnings("unchecked")
	JComboBox team2 = new JComboBox(teamNames);
	JPanel playMenu = new JPanel();
	JFrame frame;

	public PlayMenu(JFrame frame){
		this.frame = frame;
		setDesign();

		this.setLayout(null);

		JLabel title = new JLabel("Play Page");

		JButton run = new JButton("Run Simulation");
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		this.add(title);
		this.add(run);
		this.add(team1);
		this.add(team2);
		team1.addActionListener(new t1Listener());
		team2.addActionListener(new t2Listener());

		team1.setBounds(75, 100, 150, 35);
		team2.setBounds(275, 100, 150, 35);
		title.setBounds(225,50,100,45);
		run.setBounds(150, 400, 200, 100);

		setFocusable(true);

		this.setBackground(Color.WHITE);
		this.setVisible(true);

	}

	//read comments to understand what you need to put there (recursion and jlabel wise)
	public Boolean strikeChance(int strikechance, Player [] team1, Player [] team2){
		boolean goal = false;
		if(randomn.nextInt(100) <= strikechance /*Passed in through read write io*/){
			if((team.getMID(team1)+team.getOFFENSE(team1))/2> (team.getMID(team2)+team.getOFFENSE(team2)/2)) // team 1 stats > team 2 stats
			{
				int teamdiff = (team.getMID(team1)+team.getOFFENSE(team1))/2 - (team.getMID(team2)+team.getOFFENSE(team2))/2; //diff in stats that modifies chance
				System.out.println();
				int team1chance = ((team.getMID(team1)+team.getOFFENSE(team1)))/2 + teamdiff*3/5;
				if(randomn.nextInt(((team.getMID(team1)+team.getOFFENSE(team1))*2)) <= team1chance) //team1scorechance
				{
					//team 1 is trying to score
					//recursion to find striker (random through team and if player is forward or middle bring player here and compare skill to goalie
					//if player skill > goalie, playerskill - 2/5*goalieskill = chance to score
					//if player skill < goalie, playerskill - 3/4*goalieskill = chance to score
					//set goal to true ------------ JLabel, print: "Goal scored by" +player+ "at  
				}
				else
				{
					//team 2 is trying to score
					//same as above comments
				}
			}
			else if((team.getMID(team2)+team.getOFFENSE(team2))> (team.getMID(team1)+team.getOFFENSE(team1))) // team 2 stats > team 1 stats
			{
				int teamdiff = (team.getMID(team2)+team.getOFFENSE(team2))/2 - (team.getMID(team1)+team.getOFFENSE(team1))/2; //diff in stats that modifies chance
				System.out.println();
				int team2chance = ((team.getMID(team2)+team.getOFFENSE(team2)))/2 + teamdiff*3/5;
				if(randomn.nextInt(100) <= team2chance) //team2score chance
				{
					//team 2 trying to score
					//recursion to find striker (random through team and if player is forward or middle bring player here and compare skill to goalie
					//if player skill > goalie, playerskill - 2/5*goalieskill = chance to score
					//if player skill < goalie, playerskill - 3/4*goalieskill = chance to score
					//set goal to true -----------  JLabel, print: "Goal scored by" +player+ "at " +MainMenu.gameTime 
				}
				else
				{
					//team 1 is trying to score
					//same as above comments
				}
			}
			else // tie
			{
				if(1 < randomn.nextInt(50))
				{
					//team1 trying to score
				}
				else
				{
					//team2 trying to score
				}
			}
		}
		return goal;
	}
	public Boolean foulChance(int foulchance, Player [] team1, Player [] team2){
		boolean foul = false;
		if(randomn.nextInt(100) < foulchance){
			if((team.getOVERALL(team1))> (team.getOVERALL(team2))){
				
				int teamdiff = (team.getOVERALL(team1)) - (team.getOVERALL(team2)); //diff in stats that modifies chance
				int team1chance = team.getOVERALL(team1) + teamdiff*3/5;
				if(randomn.nextInt(team.getOVERALL(team1)*2) <= team1chance); //team1scorechance
			}
		}
		return foul;
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

	private class t1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {

			//			frame.getRootPane().updateUI();
			Team t = new Team();

			Player[] pa = Team.teams.get(team1.getSelectedItem());
			int O = t.getOFFENSE(pa);
			int M = t.getMID(pa);
			int D = t.getDEFENSE(pa);
			int total = (O + M + D)/3;

			JLabel O1 = new JLabel("Offensive score: " + O);
			JLabel M1 = new JLabel("Mid score: " + M);
			JLabel D1 = new JLabel("Defensive score: " + D);
			JLabel Total1 = new JLabel("Total score: " + total);

			add(O1);
			add(M1);
			add(D1);
			add(Total1);

			O1.setBounds(75, 150, 150, 35);
			M1.setBounds(75, 200, 150, 35);
			D1.setBounds(75, 250, 150, 35);
			Total1.setBounds(75, 300, 150, 35);
			//			frame.getRootPane().updateUI();
			//			frame.getRootPane().remove(Total1);
			//			frame.getRootPane().updateUI();
			//			playMenu.removeAll();
			//			revalidate();
			//			repaint();
			//			playMenu.updateUI();
		}
	}

	private class t2Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("TEST: REMOVE");
			frame.remove(playMenu);
			frame.validate();
			Team t = new Team();

			Player[] pa = Team.teams.get(team2.getSelectedItem());
			int O = t.getOFFENSE(pa);
			int M = t.getMID(pa);
			int D = t.getDEFENSE(pa);
			int total = (O + M + D)/3;


			JLabel O2 = new JLabel("Offensive score: " + O);
			JLabel M2 = new JLabel("Mid score: " + M);
			JLabel D2 = new JLabel("Defensive score: " + D);
			JLabel Total2 = new JLabel("Total score: " + total);

			add(O2);
			add(M2);
			add(D2);
			add(Total2);

			O2.setBounds(275, 150, 150, 35);
			M2.setBounds(275, 200, 150, 35);
			D2.setBounds(275, 250, 150, 35);
			Total2.setBounds(275, 300, 150, 35);
			revalidate();
			repaint();

		}
	}

	private class playGame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {


		}

	}

}
