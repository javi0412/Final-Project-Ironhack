package com.ironhack.expensesservice.repository;

import com.ironhack.expensesservice.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Party, Integer> {
}
