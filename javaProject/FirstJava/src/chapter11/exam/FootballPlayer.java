package chapter11.exam;

public class FootballPlayer implements Comparable<FootballPlayer>{

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
	public int compareTo(FootballPlayer o) {
		// 팀 이름 -> 선수이름 -> 번호
		int result = team.compareTo(o.getTeam());
		if(result == 0) {
			result = name.compareTo(o.getName());
			if(result == 0) {
				result = number - o.getNumber();
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "FootballPlayer [name=" + name + ", number=" + number + ", team=" + team + ", age=" + age + "]";
	}
}
