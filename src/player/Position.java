package player;

public enum Position {
	FORWARD("Forward"), MID("Midfielder"), DEFENDER("Defender"), KEEPER("Goalie");


	protected String position;

	Position(String position){
		position = position;
	}

}	