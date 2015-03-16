package player;

public enum Position {
	FORWARD("Forward"), MID("Midfielder"), DEFENDER("Defender"), KEEPER("Goalie");


	protected Position position;

	Position(String position){
		position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	

}	