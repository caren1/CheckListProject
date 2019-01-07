package com.sda.javagda17.checklist.repository;

import com.sda.javagda17.checklist.model.ChecklistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckListItemRepository extends JpaRepository <ChecklistItem, Long> {
}
