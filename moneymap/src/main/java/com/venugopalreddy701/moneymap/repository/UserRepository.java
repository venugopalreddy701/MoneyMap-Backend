package com.venugopalreddy701.moneymap.repository;

import com.venugopalreddy701.moneymap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email AND u.password = :password")
    boolean existsByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u.id FROM User u WHERE u.email = :email")
    Integer findIdByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
