import com.firstcoding.todo.dept.Dept;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeptTest {

    @Test
    public void DeptTest(){
        Dept dept = new Dept(10, "Test", "Loc");

        dept.setDeptno(60);

        System.out.println(dept);

        Assertions.assertEquals(60, dept.getDeptno(), "부서번호 확인 테스트");
    }
}
