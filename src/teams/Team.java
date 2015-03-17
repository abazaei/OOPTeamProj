package teams;

import java.util.HashMap;

import player.Player;
import player.Position;

public class Team {

	private int OFFENSE;
	private int MID;
	private int DEFENSE;
	private int OVERALL;

	public static int TEAMSIZE = 11;

	public static Player [] tBarcelona = new Player [TEAMSIZE];
	public static Player [] tRealMadrid = new Player [TEAMSIZE];
	public static Player [] tPSG = new Player[TEAMSIZE];
	public static Player [] tChelsea = new Player[TEAMSIZE];

	public static HashMap<String, Player[]> teams = new HashMap<String, Player[]>();

	public Team(){

		//FC Barcelona
		tBarcelona[0] = new Player("Bravo", 83, 32, Position.KEEPER,"FC Barcelona", "Chile");
		tBarcelona[1] = new Player("Montoya", 81, 24, Position.DEFENDER, "FC Barcelona", "Spain"); //ADD BAYERN,CHELSEA
		tBarcelona[2] = new Player("Pique", 87, 28, Position.DEFENDER, "FC Barcelona", "Spain");
		tBarcelona[3] = new Player("Rakitic", 82, 26, Position.MID, "FC Barcelona", "Croatia");
		tBarcelona[4] = new Player("Busquets", 84, 26, Position.MID, "FC Barcelona", "Spain");
		tBarcelona[5] = new Player("Xavi", 86, 34,Position.MID, "FC Barcelona", "Spain");
		tBarcelona[6] = new Player("Pedro", 85, 27,Position.FORWARD, "FC Barcelona", "Spain");
		tBarcelona[7] = new Player("Iniesta", 89, 30,Position.MID, "FC Barcelona", "Spain");
		tBarcelona[8] = new Player("Suarez", 92, 27,Position.FORWARD, "FC Barcelona", "Uruguay");
		tBarcelona[9] = new Player("Messi", 97, 27,Position.FORWARD, "FC Barcelona", "Argentina");
		tBarcelona[10] = new Player("Neymar", 91, 22,Position.FORWARD, "FC Barcelona", "Brazil");

		//Real Madrid
		tRealMadrid[0] = new Player("Casillas", 84, 33, Position.KEEPER, "Real Madrid", "Spain");
		tRealMadrid[1] = new Player("Varane", 83, 21, Position.DEFENDER, "Real Madrid", "France");
		tRealMadrid[2] = new Player("Pepe", 87, 31, Position.DEFENDER, "Real Madrid", "Portugal");
		tRealMadrid[3] = new Player("Ramos", 86, 28, Position.DEFENDER, "Real Madrid", "Spain");
		tRealMadrid[4] = new Player("Coentrao", 83, 29,Position.DEFENDER, "Real Madrid", "Portugal");
		tRealMadrid[5] = new Player("Khedira", 85, 27,Position.MID, "Real Madrid", "Germany");
		tRealMadrid[6] = new Player("Ronaldo", 97, 29, Position.FORWARD, "Real Madrid", "Portugal");
		tRealMadrid[7] = new Player("Kroos", 91, 24, Position.MID, "Real Madrid", "Germany");
		tRealMadrid[8] = new Player("Benzema", 89, 26, Position.FORWARD, "Real Madrid", "France");
		tRealMadrid[9] = new Player("Rodriguez", 86, 23, Position.MID, "Real Madrid", "Spain");
		tRealMadrid[10] = new Player("Bale", 89, 25, Position.MID, "Real Madrid", "Wale");

		//PSG
		tPSG[0] = new Player("Sirigu",84,28,Position.KEEPER,"Paris Saint-Germain F.C.","Italy");
		tPSG[1] = new Player("Silva",91,31,Position.DEFENDER,"Paris Saint-Germain F.C.","Brazil");
		tPSG[2] = new Player("Luiz",89,28,Position.DEFENDER,"Paris Saint-Germain F.C.","Brazil");
		tPSG[3] = new Player("Aurier",81,27,Position.DEFENDER,"Paris Saint-Germain F.C.","Ivory Coast");
		tPSG[4] = new Player("Maxwell",79,34,Position.MID,"Paris Saint-Germain F.C.","Brazil");
		tPSG[5] = new Player("Motta",82,33,Position.MID,"Paris Saint-Germain F.C.","Italy");
		tPSG[6] = new Player("Matuidi",83,28,Position.MID,"Paris Saint-Germain F.C.","France");
		tPSG[7] = new Player("Veratti",80,23,Position.MID,"Paris Saint-Germain F.C.","Italy");
		tPSG[8] = new Player("Lavezzi",82,30,Position.FORWARD,"Paris Saint-Germain F.C.","Argentina");
		tPSG[9] = new Player("Ibrahimovic",91,34,Position.FORWARD,"Paris Saint-Germain F.C.","Sweden");
		tPSG[10] = new Player("Cavani",86,28,Position.FORWARD,"Paris Saint-Germain F.C.","Uruguay");

		//Chelsea
		tChelsea[0] = new Player("Courtois",86,23,Position.KEEPER,"Chelsea","Belgium");
		tChelsea[1] = new Player("Azpilicueta",81,31,Position.DEFENDER,"Chelsea","Spain");
		tChelsea[2] = new Player("Terry",84,28,Position.DEFENDER,"Chelsea","England");
		tChelsea[3] = new Player("Cahill",81,27,Position.DEFENDER,"Chelsea","England");
		tChelsea[4] = new Player("Luis",82,30,Position.DEFENDER,"Chelsea","Brazil");
		tChelsea[5] = new Player("Willian",83,33,Position.MID,"Chelsea","Brazil");
		tChelsea[6] = new Player("Matic",82,26,Position.MID,"Chelsea","Serbia");
		tChelsea[7] = new Player("Fabregas",85,23,Position.MID,"Chelsea","Spain");
		tChelsea[8] = new Player("Hazard",88,24,Position.MID,"Chelsea","Belgium");
		tChelsea[9] = new Player("Oscar",85,24,Position.FORWARD,"Chelsea","Brazil");
		tChelsea[10] = new Player("Costa",89,27,Position.FORWARD,"Chelsea","Spain");

	}



	public int getOFFENSE( Player [] team) {
		int pCounted = 0;
		int oFFENSE = 0;
		for(Player p : team){
			if(p.getPosition() == Position.FORWARD){
				pCounted++;
				oFFENSE += p.getSkill();
			}
		}
		oFFENSE = oFFENSE/pCounted;
		return oFFENSE; //math to average for us
	}

	public void setOFFENSE(int oFFENSE) {
		OFFENSE = oFFENSE;
	}

	public int getMID(Player [] team) {
		int pCounted = 0;
		int mID = 0;
		for(Player p : team){
			if( p.getPosition() == Position.MID){
				pCounted++;
				mID += p.getSkill();
			}
		}
		mID = mID/pCounted;
		return mID;
	}

	public void setMID(int mID) {
		MID = mID;
	}

	public int getDEFENSE(Player [] team) {
		int pCounted = 0;
		int dEFENSE = 0;
		for(Player p : team){
			if(p.getPosition() == Position.DEFENDER){
				pCounted++;
				dEFENSE += p.getSkill();
			}
		}
		dEFENSE = dEFENSE/pCounted;
		return dEFENSE;
	}
	public int getOVERALL(Player [] team){
		int overallsc = 0;
		int pCounted = 0;
		for(Player p : team){
			pCounted++;
			overallsc += p.getSkill();
		}
		overallsc = overallsc/pCounted;
		return overallsc;
	}
	public void setOVERALL(int oVERALL){
		OVERALL = oVERALL;
	}

	public void setDEFENSE(int dEFENSE) {
		DEFENSE = dEFENSE;
	}
	public static void addTeam(){
		teams.put("Barcelona",tBarcelona );
		teams.put("RealMadrid", tRealMadrid );
		teams.put("PSG", tPSG);
		teams.put("Chelsea", tChelsea);
	}



}
