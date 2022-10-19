package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		
		try {
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(dbUrl, "SCOTT", "tiger");
			
			if(conn != null) {
				System.out.println("데이터베이스 연결");
			}
			
			String sql = "DELETE FROM dept WHERE deptno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("삭제되었습니다.");
			}
			
			pstmt.close();
			conn.close();
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
