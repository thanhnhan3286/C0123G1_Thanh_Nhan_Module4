package com.example.validateformdangky.repository;

import com.example.validateformdangky.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user WHERE email = :email",nativeQuery = true)
    List<User> findAllByEmail(@Param("email") String email);
    @Query(value = "SELECT * FROM user WHERE phone_number = :phoneNumber",nativeQuery = true)
    List<User> findAllByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
