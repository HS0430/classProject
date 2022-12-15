package com.first.app.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    @Query("select d from Dept d where d.deptno = ?1")
    Dept findByDeptno(Integer deptno);

    @Query("select d from Dept d where d.dname like ?1 order by d.loc")
    List<Dept> findByDnameLikeOrderByLocAsc(String dname);

    @Query("select d from Dept d where d.deptno >= ?1 and d.dname like ?2 and d.loc like ?3")
    List<Dept> findByDeptnoGreaterThanEqualAndDnameLikeAndLocLikeOOrderByDeptnoDesc(Integer deptno, String dname, String loc);

    @Query("select d from Dept d where d.loc like :loc")
    List<Dept> findByLocLike(@Param("loc") String loc);

    @Query("select d from Dept d where d.deptno between :startNum and :endNum")
    List<Dept> findByDeptnoBetween(@Param("startNum") Integer startNum, @Param("endNum") Integer endNum);

}
