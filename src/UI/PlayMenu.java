package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import player.Player;
import player.Position;
import teams.Team;

public class PlayMenu extends JPanel{


	public static int fChance;
	public static int sChance;
	public static String [] dataArray = new String[2];
	public int foulChanceSetting = 60;
	public int strikeChanceSetting = 40;
	public static boolean gameIsPlaying = false;
	public static int gameTime = 0;
	public static int gameEnds = 90;
	public int goalModteam1 = 0;
	public int goalModteam2 = 0;
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

		JPanel panel1 = new JPanel();
		JTextField sim = new JTextField(5);
		panel1.add(new JLabel("Scoring Chance"));
		panel1.add(sim);

		JPanel panel2 = new JPanel();
		JTextField gen = new JTextField(5);
		panel2.add(new JLabel("Foul Chance"));
		panel2.add(gen);

		this.add(title);
		this.add(run);
		this.add(team1);
		this.add(team2);
		this.add(panel1);
		this.add(panel2);
		team1.addActionListener(new t1Listener());
		team2.addActionListener(new t2Listener());


		panel1.setBounds(75, 60, 150, 35);
		panel2.setBounds(275,60,150,35);

		team1.setBounds(75, 120, 150, 35);
		team2.setBounds(275, 120, 150, 35);
		title.setBounds(225,20,100,45);
		run.addActionListener(new runListener());
		run.setBounds(150, 450, 200, 100);



		setFocusable(true);

		this.setBackground(Color.WHITE);
		this.setVisible(true);

	}

	//read comments to understand what you need to put there (recursion and jlabel wise)
	public void strikeChance(int strikechance, Player [] team1, Player [] team2){
		if(randomn.nextInt(100) <= strikechance /*Passed in through read write io*/){
			if((team.getMID(team1)+team.getOFFENSE(team1))/2> (team.getMID(team2)+team.getOFFENSE(team2)/2)) // team 1 stats > team 2 stats
			{
				int teamdiff = (team.getMID(team1)+team.getOFFENSE(team1))/2 - (team.getMID(team2)+team.getOFFENSE(team2))/2; //diff in stats that modifies chance
				int team1chance = ((team.getMID(team1)+team.getOFFENSE(team1)))/2 + teamdiff*3/5;
				if(randomn.nextInt(((team.getMID(team1)+team.getOFFENSE(team1))*2)) <= team1chance){
					//team 1 is trying to score
					//recursion to find striker (random through team and if player is forward or middle bring player here and compare skill to goalie
					//if player skill > goalie, goalModteam1 + playerskill - 2/5*goalieskill = chance to score
					//if player skill < goalie, goalModteam1 + playerskill - 3/4*goalieskill = chance to score
					//set goal to true ------------ JLabel, print: "Goal scored by" +player+ "at  
					Player scorer = scoreBro(team1);
					int scoreChance = 0;
					if(scorer.getSkill() >= team2[0].getSkill()){
						scoreChance = (int) (goalModteam1 + scorer.getSkill() - (2/5)*team2[0].getSkill());
					}
					else if(scorer.getSkill() < team2[0].getSkill()){
						scoreChance = (int) (goalModteam1 + scorer.getSkill() - (3/4)*team2[0].getSkill());
					}
					int score = randomn.nextInt(100);
					if(score <= scoreChance){
						System.out.println("Team 1 scored");
					}
					else{
						System.out.println("Team 2 blocked");
					}

				}
				else
				{
					//team 2 is trying to score
					//same as above comments, except use goalModteam2
					Player scorer = scoreBro(team2);
					int scoreChance = 0;
					if(scorer.getSkill() >= team1[0].getSkill()){
						scoreChance = (int) (goalModteam2 + scorer.getSkill() - (2/5)*team1[0].getSkill());
					}
					else if(scorer.getSkill() < team1[0].getSkill()){
						scoreChance = (int) (goalModteam2 + scorer.getSkill() - (3/4)*team1[0].getSkill());
					}
					int score = randomn.nextInt(100);
					if(score <= scoreChance){
						System.out.println("Team 2 scored");
					}
					else{
						System.out.println("Team 1 blocked");
					}

				}
			}

			else if((team.getMID(team2)+team.getOFFENSE(team2))> (team.getMID(team1)+team.getOFFENSE(team1))) // team 2 stats > team 1 stats
			{
				int teamdiff = (team.getMID(team2)+team.getOFFENSE(team2))/2 - (team.getMID(team1)+team.getOFFENSE(team1))/2; //diff in stats that modifies chance
				int team2chance = ((team.getMID(team2)+team.getOFFENSE(team2)))/2 + teamdiff*3/5;
				if(randomn.nextInt(100) <= team2chance) //team2score chance
				{
					//team 2 trying to score
					//recursion to find striker (random through team and if player is forward or middle bring player here and compare skill to goalie
					//if player skill > goalie, goalModteam2 + playerskill - 2/5*goalieskill = chance to score
					//if player skill < goalie, goalModteam2 + playerskill - 3/4*goalieskill = chance to score
					//set goal to true -----------  JLabel, print: "Goal scored by" +player+ "at " +MainMenu.gameTime 
					Player scorer = scoreBro(team2);
					int scoreChance = 0;
					if(scorer.getSkill() >= team1[0].getSkill()){
						scoreChance = (int) (goalModteam2 + scorer.getSkill() - (2/5)*team1[0].getSkill());
					}
					else if(scorer.getSkill() < team1[0].getSkill()){
						scoreChance = (int) (goalModteam2 + scorer.getSkill() - (3/4)*team1[0].getSkill());
					}
					int score = randomn.nextInt(100);
					if(score <= scoreChance){
						System.out.println("Team 2 scored");
					}
					else{
						System.out.println("Team 1 blocked");
					}
				}
				else
				{
					//team 1 is trying to score except use goalModteam1
					//same as above comments
					Player scorer = scoreBro(team1);
					int scoreChance = 0;
					if(scorer.getSkill() >= team2[0].getSkill()){
						scoreChance = (int) (goalModteam1 + scorer.getSkill() - (2/5)*team2[0].getSkill());
					}
					else if(scorer.getSkill() < team2[0].getSkill()){
						scoreChance = (int) (goalModteam1 + scorer.getSkill() - (3/4)*team2[0].getSkill());
					}
					int score = randomn.nextInt(100);
					if(score <= scoreChance){
						System.out.println("Team 1 scored");
					}
					else{
						System.out.println("Team 2 blocked");
					}
				}
			}
			else // tie
			{
				if(1 < randomn.nextInt(50))
				{
					//team1 trying to score
					//same as all the rest
					Player scorer = scoreBro(team1);
					int scoreChance = 0;
					if(scorer.getSkill() >= team2[0].getSkill()){
						scoreChance = (int) (goalModteam1 + scorer.getSkill() - (2/5)*team2[0].getSkill());
					}
					else if(scorer.getSkill() < team2[0].getSkill()){
						scoreChance = (int) (goalModteam1 + scorer.getSkill() - (3/4)*team2[0].getSkill());
					}
					int score = randomn.nextInt(100);
					if(score <= scoreChance){
						System.out.println("Team 1 scored");
					}
					else{
						System.out.println("Team 2 blocked");
					}
				}
				else
				{
					//team2 trying to score
					//same as all the rest
					Player scorer = scoreBro(team2);
					int scoreChance = 0;
					if(scorer.getSkill() >= team1[0].getSkill()){
						scoreChance = (int) (goalModteam2 + scorer.getSkill() - (2/5)*team1[0].getSkill());
					}
					else if(scorer.getSkill() < team1[0].getSkill()){
						scoreChance = (int) (goalModteam2 + scorer.getSkill() - (3/4)*team1[0].getSkill());
					}
					int score = randomn.nextInt(100);
					if(score <= scoreChance){
						System.out.println("Team 2 scored");
					}
					else{
						System.out.println("Team 1 blocked");
					}
				}
			}
		}
	}
	public void gameTime(Player[] team1, Player[] team2){
		//read in the foulChanceSetting and strikeChanceSetting
		//gameIsPlaying = true when button pressed
		while(gameIsPlaying) {
			long millis = System.currentTimeMillis();
			gameTime++;
			System.out.println(gameTime);
			foulChance(foulChanceSetting, team1, team2);
			strikeChance(strikeChanceSetting, team1, team2);//Seconds in the game passed
			if(gameTime >= gameEnds)
			{
				gameIsPlaying = false;

				//Determine Winner in new frame
			}
			try {
				Thread.sleep(1000 - millis % 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void foulChance(int foulchance, Player [] team1, Player [] team2){
		if(randomn.nextInt(100) <= foulchance){
			if((team.getOVERALL(team1))> (team.getOVERALL(team2))){
				int cardsev = randomn.nextInt(100);

				int teamdiff = (team.getOVERALL(team1)) - (team.getOVERALL(team2)); 
				int team1chance = team.getOVERALL(team1) + teamdiff*3/5;

				if(randomn.nextInt(team.getOVERALL(team1)*2) <= team1chance){ 
					//random team 1 player that fouls someone
					//JLABEL the name of the player that fouled 
					String fouler = team1[randomn.nextInt(10)].getName();
					if(cardsev < 20){
						//JLABEL Red Card to the player
						//goalModteam2+= 4    goalModteam2 is a int at the class level
						System.out.println(fouler + " fouled " +team2[randomn.nextInt(10)].getName()+ ", he has been red carded!");
						goalModteam2 += 4;

					}
					else if(cardsev< 65 && cardsev > 20){
						//JLABEL Yellow Card
						System.out.println(fouler + " fouled " +team2[randomn.nextInt(10)].getName()+ ", he has been yellow carded");
						goalModteam2++;
					}
					else{
						//JLABEL The Referee Says Play On!
						System.out.println(fouler + " fouled " +team2[randomn.nextInt(10)].getName()+ ", the referee issues a warning!");
					}
				}
				else{
					String fouler = team2[randomn.nextInt(10)].getName();
					if(cardsev < 20){
						//JLABEL Red Card to the player
						//goalModteam2+= 4    goalModteam2 is a int at the class level
						System.out.println(fouler + " fouled " +team1[randomn.nextInt(10)].getName()+ ", he has been red carded!");
						goalModteam2 += 4;

					}
					else if(cardsev< 65 && cardsev > 20){
						//JLABEL Yellow Card
						System.out.println(fouler + " fouled " +team1[randomn.nextInt(10)].getName()+ ", he has been yellow carded");
						goalModteam2++;
					}
					else{
						//JLABEL The Referee Says Play On!
						System.out.println(fouler + " fouled " +team1[randomn.nextInt(10)].getName()+ ", the referee issues a warning!");
					}
				}
			}
			else if ((team.getOVERALL(team2)) < (team.getOVERALL(team1))){
				int cardsev = randomn.nextInt(100);

				int teamdiff = (team.getOVERALL(team2)) - (team.getOVERALL(team1)); 
				int team1chance = team.getOVERALL(team2) + teamdiff*3/5;

				if(randomn.nextInt(team.getOVERALL(team2)*2) <= team1chance){ 
					//random team 1 player that fouls someone
					//JLABEL the name of the player that fouled 
					String fouler = team2[randomn.nextInt(10)].getName();
					if(cardsev < 20){
						//JLABEL Red Card to the player
						//goalModteam2+= 4    goalModteam2 is a int at the class level
						System.out.println(fouler + " fouled " +team1[randomn.nextInt(10)].getName()+ ", he has been red carded!");
						goalModteam2 += 4;

					}
					else if(cardsev< 65 && cardsev > 20){
						//JLABEL Yellow Card
						System.out.println(fouler + " fouled " +team1[randomn.nextInt(10)].getName()+ ", he has been yellow carded");
						goalModteam2++;
					}
					else{
						//JLABEL The Referee Says Play On!
						System.out.println(fouler + " fouled " +team1[randomn.nextInt(10)].getName()+ ", the referee issues a warning!");
					}
				}
				else{
					String fouler = team1[randomn.nextInt(10)].getName();
					if(cardsev < 20){
						//JLABEL Red Card to the player
						//goalModteam2+= 4    goalModteam2 is a int at the class level
						System.out.println(fouler + " fouled " +team2[randomn.nextInt(10)].getName()+ ", he has been red carded!");
						goalModteam2 += 4;

					}
					else if(cardsev< 65 && cardsev > 20){
						//JLABEL Yellow Card
						System.out.println(fouler + " fouled " +team2[randomn.nextInt(10)].getName()+ ", he has been yellow carded");
						goalModteam2++;
					}
					else{
						//JLABEL The Referee Says Play On!
						System.out.println(fouler + " fouled " +team2[randomn.nextInt(10)].getName()+ ", the referee issues a warning!");
					}
				}
			}
		}
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
		public static void write(){
			FileWriter outputStream = null;
			try {
				outputStream = new FileWriter("Soccer.txt");
				outputStream.write(sChance + "\r\n");
				outputStream.write(fChance + "\r\n");

			} catch (IOException e) {

				e.printStackTrace();
			}
			finally{
				if(outputStream !=null){
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		public void read(){
			FileInputStream inputData = null;

			try {
				inputData = new FileInputStream("Soccer.txt");
				Scanner scan = new Scanner(inputData);
				for(int i = 0; i<dataArray.length; i++){
					dataArray[i] = scan.nextLine();  
				}

				foulChanceSetting = Integer.parseInt(dataArray[0]);
				strikeChanceSetting = Integer.parseInt(dataArray[1]);

			} catch (IOException e) {
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

		private Player scoreBro(Player[] team1){
			int rP = randomn.nextInt(11);
			Player scorer = team1[rP];
			if(scorer.getPosition() == Position.DEFENDER){
				scorer = scoreBro(team1);
			}
			else{
				scorer = scorer;
			}


			return scorer;

		}

		private class runListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Game Begins");
				Player[] teamOne = Team.teams.get(team1.getSelectedItem());
				Player[] teamTwo = Team.teams.get(team2.getSelectedItem());
				gameIsPlaying = true;
				gameTime(teamOne, teamTwo);

			}

		}


	}
