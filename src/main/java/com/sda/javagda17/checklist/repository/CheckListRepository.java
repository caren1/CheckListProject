package com.sda.javagda17.checklist.repository;

import com.sda.javagda17.checklist.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckListRepository extends JpaRepository <Checklist, Long> {
}
