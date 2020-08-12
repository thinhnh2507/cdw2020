package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String usename);

   @Query(value = "select '*' from User where username like %:key%")
    List<User> searchUserByKey(@Param("key") String key);
}
