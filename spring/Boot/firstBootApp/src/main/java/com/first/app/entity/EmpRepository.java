package com.first.app.entity;

import com.first.app.domain.ListItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

    @Query(value = "SELECT e FROM Emp e join fetch e.dept")
   List<Emp> findEmpDept();

    @Query("SELECT e FROM Emp e, Dept d WHERE e.dept=d")
//    Page<Emp> findEmpWithDept(Pageable pageable);
    List<Emp> findEmpWithDept();

    // 게시물 리스트 => 제목 [12] <= 댓글의 개수
    // 게시물[de[t], count 사원수
    @Query(value = "SELECT" +
            " d, COUNT(e)" +
            "FROM Emp e LEFT OUTER JOIN Dept d" +
            " ON e.dept = d " +
            " GROUP BY d "
            , countQuery = "SELECT COUNT(d) FROM Dept d")
    public Page<Object[]> listWithCnt(Pageable pageable);

    @Query("SELECT " +
            " new com.first.app.domain.ListItemDTO(e.empno, e.ename, e.job, d.dname, d.loc)" +
            " FROM Emp e, Dept d" +
            " WHERE e.dept=d")
    List<ListItemDTO> findListItem();

}
