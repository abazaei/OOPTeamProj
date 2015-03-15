package teams;

import player.Player;

public class Team {
	
	private int OFFENSE;
	private int MID;
	private int DEFENSE;

	public static int TEAMSIZE = 11;
	
	static Player [] Barcelona = new Player [TEAMSIZE];
	static Player [] RealMadrid = new Player [TEAMSIZE];

	
	public Team()
	{
		//FC Barcelona
		Barcelona[0] = new Player("Bravo", 83, 32, "Goalie","FC Barcelona", "Chile");
		Barcelona[1] = new Player("Montoya", 81, 24, "Defender"); //FINISH AND ADD PSG, BAYERN,CHELSEA
		Barcelona[2] = new Player("Pique", 87, 28, "Defender");
		Barcelona[3] = new Player("Rakitic", 82, 26,"Midfielder");
		Barcelona[4] = new Player("Busquets", 84, 26,"Midfielder");
		Barcelona[5] = new Player("Xavi", 86, 34,"Midfielder");
		Barcelona[6] = new Player("Pedro", 85, 27,"Forward");
		Barcelona[7] = new Player("Iniesta", 89, 30,"Midfielder");
		Barcelona[8] = new Player("Suarez", 92, 27,"Forward");
		Barcelona[9] = new Player("Messi", 97, 27,"Forward");
		Barcelona[10] = new Player("Neymar", 91, 22,"Forward");
		
		//Real Madrid
		RealMadrid[0] = new Player("Casillas", 91, 33, "Goalie");
		RealMadrid[1] = new Player("Varane", 83, 21, "Defender");
		RealMadrid[2] = new Player("Pepe", 87, 31, "Defender");
		RealMadrid[3] = new Player("Ramos", 86, 28, "Defender");
		RealMadrid[4] = new Player("Coentrao", 83, 29, "Defender");
		RealMadrid[5] = new Player("Khedira", 85, 27, "Midfielder");
		RealMadrid[6] = new Player("Ronaldo", 97, 29, "Forward");
		RealMadrid[7] = new Player("Kroos", 91, 24, "Midfielder");
		RealMadrid[8] = new Player("Benzema", 89, 26, "Benzema");
		RealMadrid[9] = new Player("Rodriguez", 86, 23, "Midfielder");
		RealMadrid[10] = new Player("Bale", 89, 25, "Midfielder");	

		

	public int getOFFENSE() {
		return OFFENSE; //math to average for us
	}

	public void setOFFENSE(int oFFENSE) {
		OFFENSE = oFFENSE;
	}

	public int getMID() {
		return MID;
	}

	public void setMID(int mID) {
		MID = mID;
	}

	public int getDEFENSE() {
		return DEFENSE;
	}

	public void setDEFENSE(int dEFENSE) {
		DEFENSE = dEFENSE;
	}
	
	

}
