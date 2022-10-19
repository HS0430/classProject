package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest2 {

	public static void main(String[] args) {
		
		// 1. 드라이버 로드 (생략 가능)
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 객체 생성
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//			String dbUrl = "jdbc:mysql://localhost:3306/project";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			if(conn != null) {
				System.out.println("데이터베이스 연결");
			}
			// 3. Statement / PreparedStatement
//			Statement stmt = conn.createStatement();
			
			String sql = "SELECT * FROM dept WHERE deptno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			
//			stmt.executeQuery(sql);
			
			// 4. ResultSet
			// Select의 결과를 담고있는 객체
			ResultSet rs = pstmt.executeQuery();
			
			// 다중 행
//			while(rs.next()){
////				int deptno = rs.getInt("deptno");
////				String dname = rs.getString("dname");
////				String loc = rs.getString("loc");
//				int deptno = rs.getInt(1);
//				String dname = rs.getString(2);
//				String loc = rs.getString(3);
//				
//				System.out.printf("%d \t %s \t %s \n", deptno, dname, loc);
//			}
			
			// 행이 하나 나오느 경우
			if(rs.next()){
//				int deptno = rs.getInt("deptno");
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
				int deptno = rs.getInt(1);
				String dname = rs.getString(2);
				String loc = rs.getString(3);
				
				System.out.printf("%d \t %s \t %s \n", deptno, dname, loc);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
