package com.example.ungdungblog.repository;

import com.example.ungdungblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByStatusIsFalse();

    @Query(value = "UPDATE Category AS c SET c.status = 1 WHERE c.id = :deleteId")
    @Modifying
    @Transactional
    void setStatus(@Param("deleteId") int deleteId);
//    @Query(value = "select * from category where category.status = 0", nativeQuery = true)
//    List<Category> findAll();
    //@Query(value = "select * from student as s where s.name_student like :name", nativeQuery = true)
    //List<Student> getStudentByName(@Param("name") String name);
}
