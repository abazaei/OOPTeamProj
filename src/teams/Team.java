package teams;

import player.Player;

public class Team {
	
	private int OFFENSE;
	private int MID;
	private int DEFENSE;

	public static int TEAMSIZE = 11;
	
	static Player [] Barcelona = new Player [TEAMSIZE];
	static Player [] RealMadrid = new Player [TEAMSIZE];
	static Player [] PSG = new Player[TEAMSIZE];
	static Player [] Chelsea = new Player[TEAMSIZE];
	
	public Team()
	{
		//FC Barcelona
		Barcelona[0] = new Player("Bravo", 83, 32, "Goalie","FC Barcelona", "Chile");
		Barcelona[1] = new Player("Montoya", 81, 24, "Defender", "FC Barcelona", "Spain"); //ADD BAYERN,CHELSEA
		Barcelona[2] = new Player("Pique", 87, 28, "Defender", "FC Barcelona", "Spain");
		Barcelona[3] = new Player("Rakitic", 82, 26,"Midfielder", "FC Barcelona", "Croatia");
		Barcelona[4] = new Player("Busquets", 84, 26,"Midfielder", "FC Barcelona", "Spain");
		Barcelona[5] = new Player("Xavi", 86, 34,"Midfielder", "FC Barcelona", "Spain");
		Barcelona[6] = new Player("Pedro", 85, 27,"Forward", "FC Barcelona", "Spain");
		Barcelona[7] = new Player("Iniesta", 89, 30,"Midfielder", "FC Barcelona", "Spain");
		Barcelona[8] = new Player("Suarez", 92, 27,"Forward", "FC Barcelona", "Uruguay");
		Barcelona[9] = new Player("Messi", 97, 27,"Forward", "FC Barcelona", "Argentina");
		Barcelona[10] = new Player("Neymar", 91, 22,"Forward", "FC Barcelona", "Brazil");
		
		//Real Madrid
		RealMadrid[0] = new Player("Casillas", 84, 33, "Goalie", "FC Barcelona", "Spain");
		RealMadrid[1] = new Player("Varane", 83, 21, "Defender", "FC Barcelona", "France");
		RealMadrid[2] = new Player("Pepe", 87, 31, "Defender", "FC Barcelona", "Portugal");
		RealMadrid[3] = new Player("Ramos", 86, 28, "Defender", "FC Barcelona", "Spain");
		RealMadrid[4] = new Player("Coentrao", 83, 29, "Defender", "FC Barcelona", "Portugal");
		RealMadrid[5] = new Player("Khedira", 85, 27, "Midfielder", "FC Barcelona", "Germany");
		RealMadrid[6] = new Player("Ronaldo", 97, 29, "Forward", "FC Barcelona", "Portugal");
		RealMadrid[7] = new Player("Kroos", 91, 24, "Midfielder", "FC Barcelona", "Germany");
		RealMadrid[8] = new Player("Benzema", 89, 26, "Forward", "FC Barcelona", "France");
		RealMadrid[9] = new Player("Rodriguez", 86, 23, "Midfielder", "FC Barcelona", "Spain");
		RealMadrid[10] = new Player("Bale", 89, 25, "Midfielder", "FC Barcelona", "Wale");
		
		//PSG
		PSG[0] = new Player("Sirigu",84,28,"Goalie","Paris Saint-Germain F.C.","Italy");
		PSG[1] = new Player("Silva",91,31,"Defender","Paris Saint-Germain F.C.","Brazil");
		PSG[2] = new Player("Luiz",89,28,"Defender","Paris Saint-Germain F.C.","Brazil");
		PSG[3] = new Player("Aurier",81,27,"Defender","Paris Saint-Germain F.C.","Ivory Coast");
		PSG[4] = new Player("Maxwell",79,34,"Midfielder","Paris Saint-Germain F.C.","Brazil");
		PSG[5] = new Player("Motta",82,33,"Midfielder","Paris Saint-Germain F.C.","Italy");
		PSG[6] = new Player("Matuidi",83,28,"Midfielder","Paris Saint-Germain F.C.","France");
		PSG[7] = new Player("Veratti",80,23,"Midfielder","Paris Saint-Germain F.C.","Italy");
		PSG[8] = new Player("Lavezzi",82,30,"Forward","Paris Saint-Germain F.C.","Argentina");
		PSG[9] = new Player("Ibrahimovic",91,34,"Forward","Paris Saint-Germain F.C.","Sweden");
		PSG[10] = new Player("Cavani",86,28,"Forward","Paris Saint-Germain F.C.","Uruguay");
		
		//Chelsea
		Chelsea[0] = new Player("Courtois",86,23,"Goalie","Chelsea","Belgium");
		Chelsea[1] = new Player("Azpilicueta",81,31,"Defender","Chelsea","Spain");
		Chelsea[2] = new Player("Terry",84,28,"Defender","Chelsea","England");
		Chelsea[3] = new Player("Cahill",81,27,"Defender","Chelsea","England");
		Chelsea[4] = new Player("Luis",82,30,"Defender","Chelsea","Brazil");
		Chelsea[5] = new Player("Willian",83,33,"Midfielder","Chelsea","Brazil");
		Chelsea[6] = new Player("Matic",82,26,"Midfielder","Chelsea","Serbia");
		Chelsea[7] = new Player("Fabregas",85,23,"Midfielder","Chelsea","Spain");
		Chelsea[8] = new Player("Hazard",88,24,"Midfielder","Chelsea","Belgium");
		Chelsea[9] = new Player("Oscar",85,24,"Forward","Chelsea","Brazil");
		Chelsea[10] = new Player("Costa",89,27,"Forward","Chelsea","Spain");
		
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
