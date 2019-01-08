package com.sda.javagda17.checklist.model.dto.request;

import com.sda.javagda17.checklist.model.ChecklistItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCheckListRequest {

    private String name;
    private Long id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateCompleted;
    private boolean archived;
    private Set<ChecklistItem> checklistItemSet;
}
