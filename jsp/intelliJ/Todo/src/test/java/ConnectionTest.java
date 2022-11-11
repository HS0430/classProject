import com.firstcoding.todo.util.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

    @Test
    public void testConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "SCOTT", "tiger");

        Assertions.assertNotNull(conn, "커넥션이 널이 아니면 성공");

        conn.close();
    }

    @Test
    public void testPoolConnection() throws Exception {
        Connection conn = ConnectionUtil.getInstance().getConnection();

        System.out.println(conn);

        Assertions.assertNotNull(conn, "커넥션이 널이 아니면 성공");

        conn.close();
    }
}
