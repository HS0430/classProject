package chapter11.exam;

import java.util.HashMap;
import java.util.Map;

public class Exam4Main {
	public static void main(String[] args) {
//		4. 축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는 
//		Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다

		Map<Integer, FootballPlayer> players = new HashMap<>();

		// 저장 : put
//		FootballPlayer fbp = new FootballPlayer("손흥민", 7, "토트넘", 20);
//		players.put(fbp.getNumber(), fbp);
		
		players.put(7, new FootballPlayer("손흥민", 7, "토트넘", 20));
		players.put(10, new FootballPlayer("케인", 10, "토트넘", 25));
		players.put(9, new FootballPlayer("루니", 9, "맨유", 33));
		players.put(113, new FootballPlayer("루니5", 113, "맨유", 20));
		players.put(77, new FootballPlayer("손흥민", 77, "토트넘", 30));
		players.put(1, new FootballPlayer("케인77", 1, "토트넘", 25));
		players.put(5, new FootballPlayer("이강인99", 5, "토트넘", 19));
		
		System.out.println(players.get(7));
		System.out.println(players.get(10));
		System.out.println(players.get(113));

	}
}
