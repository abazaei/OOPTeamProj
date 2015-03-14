package JSONstuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.*;

import org.json.JSONException;
import org.json.JSONObject;

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
//		try {
//			breader = new BufferedReader(new FileReader("TeamsAndPlayers.json"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		root = parser.parse(breader);
//		rootarray = root.getAsJsonObject(); //rootarray now = teams array
//		teams = rootarray.get("Teams").getAsJsonObject();
//		teamname = teams.get("FC Barcelona").getAsJsonObject();
//		player = teamname.getAsJsonObject("Bravo");
//		System.out.println(player.get("age").getAsString());

		JSONIterator();


	}
	public void JSONIterator(){
		try {
		breader = new BufferedReader(new FileReader("TeamsAndPlayers.json"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 try {
             JSONObject root = new JSONObject(breader);
             JSONObject team = root.getJSONObject("Teams").getJSONObject("FC Barcelona");
             Iterator keys =  team.keys(); 

             //iterate each object
             while (keys.hasNext()){
                 JSONObject obj = team.getJSONObject((String)keys.next());
                 String age = obj.getString("age");
                 System.out.println(age);
             }


         } catch (JSONException e1) {
             e1.printStackTrace();
         }
	}
}