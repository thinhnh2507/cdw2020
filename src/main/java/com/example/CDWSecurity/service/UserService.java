package com.example.CDWSecurity.service;

import com.example.CDWSecurity.model.SanPham;
import com.example.CDWSecurity.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    void delete(User user);
    List<User> searchUserByKey(String key);
}
