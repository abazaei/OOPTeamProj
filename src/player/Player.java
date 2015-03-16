package player;

import java.util.HashMap;






import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player {

	private String name;
	private int age;
	private double skill;
	private Position position;
	private String club;
	private String nationality;



	public Player(String n, double sk, int a, Position p, String cl, String nat)
	{
		name = n;
		skill = sk;
		age = a;
		position = p;
		club = cl;
		nationality = nat;
	}
	public String getName(){
		return name;
	}
	@XmlElement
	public void setName(String name){
		name = this.name;
	}
	@XmlElement
	public void setAge(int i) {
		this.age = i;
	}
	public int getAge(){
		return age;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public double getSkill() {
		return skill;
	}
	public void setSkill(double skill) {
		this.skill = skill;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}
