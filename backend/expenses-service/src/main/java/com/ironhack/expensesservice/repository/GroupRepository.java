package com.ironhack.expensesservice.repository;

import com.ironhack.expensesservice.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Party, Integer> {
    @Query(value = "SELECT DISTINCT users_id FROM users_group", nativeQuery = true)
    List<Integer> getIdsFromParty();
}
