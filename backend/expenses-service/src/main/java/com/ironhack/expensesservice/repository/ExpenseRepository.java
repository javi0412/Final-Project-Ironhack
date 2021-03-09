package com.ironhack.expensesservice.repository;

import com.ironhack.expensesservice.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query(value = "SELECT * FROM expense WHERE party_id=:id", nativeQuery = true)
    List<Expense> getExpensesByGroupId(@Param("id") Integer id);
}
