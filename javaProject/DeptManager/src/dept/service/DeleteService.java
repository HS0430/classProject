package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.Dao.Dao;
import dept.Dao.OracleDao;
import dept.util.ConnectionProvider;

public class DeleteService {

	Dao dao = new OracleDao();
	
	public int delete(int deptno) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			result = dao.delete(conn, deptno);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
