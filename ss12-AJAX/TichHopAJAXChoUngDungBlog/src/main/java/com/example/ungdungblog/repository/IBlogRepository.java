package com.example.ungdungblog.repository;

import com.example.ungdungblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    <of> Page<Blog> findAllByTitleContainingAndStatusIsFalse(String title, PageRequest PageRequest);

    Page<Blog> findAllByStatusIsFalse(PageRequest createTime);

    @Query(value = "UPDATE Blog AS b SET b.status = 1 WHERE b.id = :id")
    @Modifying
    @Transactional
    void setStatus(@Param("id") int id);

    @Query(value = "SELECT * FROM blogers WHERE category_id = :id AND status = 0", nativeQuery = true)
    List<Blog> findAllByIdCategory(Integer id);
    @Query(value = "SELECT * FROM blogers WHERE title LIKE CONCAT('%',:title,'%') ", nativeQuery = true)
    List<Blog> findAllByTitle(@Param("title") String title);



//    @Query(value = "INSERT INTO blogers (author, content, title) VALUES (?, ?, ?);", nativeQuery = true)
//    void add(@Param("author") String author, @Param("content") String content, @Param("title") String title );


//@Query(value = "select * from student as s where s.name_student like :name", nativeQuery = true)
//List<Student> getStudentByName(@Param("name") String name);
}
