package chapter12.exam;

import java.io.Serializable;

public class FootballPlayer implements Serializable{

	private String name;
	private int number;
	private String team;
	private int age;

	public FootballPlayer(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	public FootballPlayer() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		return age;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj != null && obj instanceof FootballPlayer) {
			// 팀과 이름 그리고 나이가 같으면
			FootballPlayer player = (FootballPlayer) obj;
			result = player.getTeam().equals(this.team) && player.getName().equals(this.name) && player.getAge() == this.age;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}
	
	public void showPlayer() {
		System.out.println("================");
		System.out.println("name = " + name);
		System.out.println("number = " + number);
		System.out.println("team = " + team);
		System.out.println("age = " + age);
		
	}
}
