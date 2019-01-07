package com.sda.javagda17.checklist.repository;

import com.sda.javagda17.checklist.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CheckListRepository extends JpaRepository<Checklist, Long> {

    Optional<Checklist> findByName(String name);
}
