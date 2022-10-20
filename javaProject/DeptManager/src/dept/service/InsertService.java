package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.Dao.Dao;
import dept.Dao.OracleDao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class InsertService {

	Dao dao = new OracleDao();
	
	public int insert(Dept dept) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			result = dao.insert(conn, dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
}
