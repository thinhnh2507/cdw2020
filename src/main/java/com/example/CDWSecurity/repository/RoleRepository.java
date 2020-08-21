package com.example.CDWSecurity.repository;

import com.example.CDWSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
    Role findRoleByUsers(long id);

}
