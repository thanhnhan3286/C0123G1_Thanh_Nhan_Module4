package com.example.ungdungblog.repository;

import com.example.ungdungblog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.LayoutQueue;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByTitleContaining(String title);
    List<Blog> findAllByStatusIsFalse();
    @Query(value = "UPDATE Blog AS b SET b.status = 1 WHERE b.id = :id")
    @Modifying
    @Transactional
    void setStatus(@Param("id") int id);


//    @Query(value = "INSERT INTO blogers (author, content, title) VALUES (?, ?, ?);", nativeQuery = true)
//    void add(@Param("author") String author, @Param("content") String content, @Param("title") String title );


//@Query(value = "select * from student as s where s.name_student like :name", nativeQuery = true)
//List<Student> getStudentByName(@Param("name") String name);
}
