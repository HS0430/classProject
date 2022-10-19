package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			if(conn != null) {
				System.out.println("데이터베이스 연결");
			}
			
			String sql = "INSERT INTO dept VALUES(?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);
			pstmt.setString(2, "개발");
			pstmt.setString(3, "서울");
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("입력되었습니다.");
			}
			
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
