package com.lablogic.store.repository;

import com.lablogic.store.model.Product;
import com.lablogic.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findById(long id);

    @Query(value = "SELECT * FROM users WHERE email=? and password=?", nativeQuery = true)
    User findByEmailAndPassword(String email, String password);
}
