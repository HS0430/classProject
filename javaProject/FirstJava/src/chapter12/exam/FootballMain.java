package chapter12.exam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FootballMain {
	public static void main(String[] args) {
		ObjectOutputStream oout = null;
		ObjectInputStream oin = null;

//		① 축구선수 정보 인스턴스를 List<E>에 저장
		List<FootballPlayer> players = new ArrayList<>();

		FootballPlayer fbpl = new FootballPlayer("단일", 99, "토트넘", 20);
		
		
		players.add(new FootballPlayer("손흥민", 7, "토트넘", 20));
		players.add(new FootballPlayer("케인", 10, "토트넘", 25));
		players.add(new FootballPlayer("이강인", 25, "토트넘", 19));
		players.add(new FootballPlayer("박지성", 7, "맨유", 35));
		players.add(new FootballPlayer("루니", 10, "맨유", 35));

		
		try {
//			② 이 인스턴스 들을 파일로 저장
			oout = new ObjectOutputStream(new FileOutputStream("FootballPlayer.ser"));
			oout.writeObject(fbpl);
			oout.writeObject(players); 
			
			oin = new ObjectInputStream(new FileInputStream("FootballPlayer.ser"));
//			③ 저장된 파일을 객체로 만드는 기능
			fbpl = (FootballPlayer) oin.readObject();
			fbpl.showPlayer();	// 단일
			
			ArrayList<FootballPlayer> fpList = (ArrayList<FootballPlayer>)oin.readObject(); // 리스트

			for(FootballPlayer fp : fpList) {
				fp.showPlayer();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
