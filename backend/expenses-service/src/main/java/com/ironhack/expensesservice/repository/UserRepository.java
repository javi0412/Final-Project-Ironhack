package com.ironhack.expensesservice.repository;

import com.ironhack.expensesservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "SELECT * FROM users_balance_sheet", nativeQuery = true)
    List<Object[]> getNamesFromParty(@Param("id") Integer id);
}
