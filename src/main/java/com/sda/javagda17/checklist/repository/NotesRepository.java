package com.sda.javagda17.checklist.repository;

import com.sda.javagda17.checklist.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Long> {
}
