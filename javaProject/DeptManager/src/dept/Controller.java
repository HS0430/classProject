package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Controller {
	
	// 기능 클래스
	// 사용자 요청의 실제 처리 클래스 : 사용자에게 데이터를 받고 DB처리 결과 출력
	
	Scanner sc;
	
	public Controller() {
		sc = new Scanner(System.in);
	}
	
	
//	1. 전체 부서 리스트
	public void select() {
		
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			String sql = "SELECT * FROM dept ORDER BY deptno";
			
			System.out.println("------------------- 부서 리스트 -------------------");
			System.out.println("------------------------------------------------");
			System.out.printf("%10s \t %10s \t %10s \n", "부서번호", "부서이름", "위치");
			System.out.println("------------------------------------------------");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				
				System.out.printf("%10d \t %10s \t %10s \n", deptno, dname, loc);
			}
			System.out.println("------------------------------------------------");
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	2. 부서검색
	public void selectByDeptno() {
		
		try {
			
			System.out.println("검색할 부서 번호를 입력해주세요. >>");
			int no = Integer.parseInt(sc.nextLine());
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			String sql = "SELECT * FROM dept WHERE deptno = ?";
			
			System.out.println("------------------ 부서 검색 결과 ------------------");
			System.out.println("------------------------------------------------");
			System.out.printf("%10s \t %10s \t %10s \n", "부서번호", "부서이름", "위치");
			System.out.println("------------------------------------------------");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()){
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				
				System.out.printf("%10d \t %10s \t %10s \n", deptno, dname, loc);
			}
			else {
				System.out.println("검색하신 번호의 부서는 존재하지 않습니다.");
			}
			System.out.println("------------------------------------------------");
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	3. 부서 정보 저장 
	public void insert() {
		
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			
			System.out.println("------------------ 부서 정보 입력 ------------------");
			System.out.print("부서 번호 입력 >> ");
			int deptno = Integer.parseInt(sc.nextLine());
			
			System.out.print("부서 이름 입력 >> ");
			String dname = sc.nextLine();
			
			System.out.print("부서 위치 입력 >> ");
			String loc = sc.nextLine();
			
			String sql = "INSERT INTO dept VALUES(?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("-------------------- 저장성공 --------------------");
			}
			
			System.out.println("------------------------------------------------");
			
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	4. 부서 정보 수정
	public void update() {
		
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			
			System.out.println("------------------ 부서 정보 수정 ------------------");
			System.out.print("변경할 부서 번호 입력 >> ");
			int deptno = Integer.parseInt(sc.nextLine());
			
			System.out.print("새로운 부서 이름 입력 >> ");
			String dname = sc.nextLine();
			
			System.out.print("새로운 부서 위치 입력 >> ");
			String loc = sc.nextLine();
			
			String sql = "UPDATE dept SET dname = ?, loc = ? WHERE deptno =?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.setInt(3, deptno);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("-------------------- 수정성공 --------------------");
			}
			
			System.out.println("------------------------------------------------");
			
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	5. 부서 정보 삭제
	public void delete() {
		
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			
			System.out.println("------------------ 부서 정보 삭제 ------------------");
			System.out.print("삭제할 부서 번호 입력 >> ");
			int deptno = Integer.parseInt(sc.nextLine());
			
			String sql = "DELETE FROM dept WHERE deptno =?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("-------------------- 삭제성공 --------------------");
			}
			
			System.out.println("------------------------------------------------");
			
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	6. 종료
	public void exit() {
		
		System.out.println("------------------ 프로그램 종료 ------------------");
		System.exit(0);
		
	}
	
}
