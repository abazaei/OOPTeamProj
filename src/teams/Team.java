package teams;

import player.Player;
import player.Position;

public class Team {
	
	private int OFFENSE;
	private int MID;
	private int DEFENSE;

	public static int TEAMSIZE = 11;
	
	public static Player [] Barcelona = new Player [TEAMSIZE];
	public static Player [] RealMadrid = new Player [TEAMSIZE];
	public static Player [] PSG = new Player[TEAMSIZE];
	public Player [] Chelsea = new Player[TEAMSIZE];
	
	public Team()
	{
		//FC Barcelona
		Barcelona[0] = new Player("Bravo", 83, 32, Position.KEEPER,"FC Barcelona", "Chile");
		Barcelona[1] = new Player("Montoya", 81, 24, Position.DEFENDER, "FC Barcelona", "Spain"); //ADD BAYERN,CHELSEA
		Barcelona[2] = new Player("Pique", 87, 28, Position.DEFENDER, "FC Barcelona", "Spain");
		Barcelona[3] = new Player("Rakitic", 82, 26, Position.MID, "FC Barcelona", "Croatia");
		Barcelona[4] = new Player("Busquets", 84, 26, Position.MID, "FC Barcelona", "Spain");
		Barcelona[5] = new Player("Xavi", 86, 34,Position.MID, "FC Barcelona", "Spain");
		Barcelona[6] = new Player("Pedro", 85, 27,Position.FORWARD, "FC Barcelona", "Spain");
		Barcelona[7] = new Player("Iniesta", 89, 30,Position.MID, "FC Barcelona", "Spain");
		Barcelona[8] = new Player("Suarez", 92, 27,Position.FORWARD, "FC Barcelona", "Uruguay");
		Barcelona[9] = new Player("Messi", 97, 27,Position.FORWARD, "FC Barcelona", "Argentina");
		Barcelona[10] = new Player("Neymar", 91, 22,Position.FORWARD, "FC Barcelona", "Brazil");
		
		//Real Madrid
		RealMadrid[0] = new Player("Casillas", 84, 33, Position.KEEPER, "FC Barcelona", "Spain");
		RealMadrid[1] = new Player("Varane", 83, 21, Position.DEFENDER, "FC Barcelona", "France");
		RealMadrid[2] = new Player("Pepe", 87, 31, Position.DEFENDER, "FC Barcelona", "Portugal");
		RealMadrid[3] = new Player("Ramos", 86, 28, Position.DEFENDER, "FC Barcelona", "Spain");
		RealMadrid[4] = new Player("Coentrao", 83, 29,Position.DEFENDER, "FC Barcelona", "Portugal");
		RealMadrid[5] = new Player("Khedira", 85, 27,Position.MID, "FC Barcelona", "Germany");
		RealMadrid[6] = new Player("Ronaldo", 97, 29, Position.FORWARD, "FC Barcelona", "Portugal");
		RealMadrid[7] = new Player("Kroos", 91, 24, Position.MID, "FC Barcelona", "Germany");
		RealMadrid[8] = new Player("Benzema", 89, 26, Position.FORWARD, "FC Barcelona", "France");
		RealMadrid[9] = new Player("Rodriguez", 86, 23, Position.MID, "FC Barcelona", "Spain");
		RealMadrid[10] = new Player("Bale", 89, 25, Position.MID, "FC Barcelona", "Wale");
		
		//PSG
		PSG[0] = new Player("Sirigu",84,28,Position.KEEPER,"Paris Saint-Germain F.C.","Italy");
		PSG[1] = new Player("Silva",91,31,Position.DEFENDER,"Paris Saint-Germain F.C.","Brazil");
		PSG[2] = new Player("Luiz",89,28,Position.DEFENDER,"Paris Saint-Germain F.C.","Brazil");
		PSG[3] = new Player("Aurier",81,27,Position.DEFENDER,"Paris Saint-Germain F.C.","Ivory Coast");
		PSG[4] = new Player("Maxwell",79,34,Position.MID,"Paris Saint-Germain F.C.","Brazil");
		PSG[5] = new Player("Motta",82,33,Position.MID,"Paris Saint-Germain F.C.","Italy");
		PSG[6] = new Player("Matuidi",83,28,Position.MID,"Paris Saint-Germain F.C.","France");
		PSG[7] = new Player("Veratti",80,23,Position.MID,"Paris Saint-Germain F.C.","Italy");
		PSG[8] = new Player("Lavezzi",82,30,Position.FORWARD,"Paris Saint-Germain F.C.","Argentina");
		PSG[9] = new Player("Ibrahimovic",91,34,Position.FORWARD,"Paris Saint-Germain F.C.","Sweden");
		PSG[10] = new Player("Cavani",86,28,Position.FORWARD,"Paris Saint-Germain F.C.","Uruguay");
		
		//Chelsea
		Chelsea[0] = new Player("Courtois",86,23,Position.KEEPER,"Chelsea","Belgium");
		Chelsea[1] = new Player("Azpilicueta",81,31,Position.DEFENDER,"Chelsea","Spain");
		Chelsea[2] = new Player("Terry",84,28,Position.DEFENDER,"Chelsea","England");
		Chelsea[3] = new Player("Cahill",81,27,Position.DEFENDER,"Chelsea","England");
		Chelsea[4] = new Player("Luis",82,30,Position.DEFENDER,"Chelsea","Brazil");
		Chelsea[5] = new Player("Willian",83,33,Position.MID,"Chelsea","Brazil");
		Chelsea[6] = new Player("Matic",82,26,Position.MID,"Chelsea","Serbia");
		Chelsea[7] = new Player("Fabregas",85,23,Position.MID,"Chelsea","Spain");
		Chelsea[8] = new Player("Hazard",88,24,Position.MID,"Chelsea","Belgium");
		Chelsea[9] = new Player("Oscar",85,24,Position.FORWARD,"Chelsea","Brazil");
		Chelsea[10] = new Player("Costa",89,27,Position.FORWARD,"Chelsea","Spain");
		
	}

		

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
