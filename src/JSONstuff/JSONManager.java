package JSONstuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.*;

public class JSONManager{
	
	
	BufferedReader breader;
	
	JsonParser parser = new JsonParser();
	JsonElement root;
	JsonObject rootarray;
	JsonObject teams;
	JsonObject teamname;
	JsonObject player;
	int age;
	String reaction;
	String overall;
	
	
	public JSONManager(){
		 try {
			breader = new BufferedReader(new FileReader("TeamsAndPlayers.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		root = parser.parse(breader);
		rootarray = root.getAsJsonObject(); //rootarray now = teams array
		teams = rootarray.get("Teams").getAsJsonObject();
		teamname = teams.get("FC Barcelona").getAsJsonObject();
		player = teamname.getAsJsonObject("Bravo");
		System.out.println(player.get("age").getAsString());
		
		
	}
}