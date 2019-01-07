package com.sda.javagda17.checklist.service;

import com.sda.javagda17.checklist.model.Checklist;
import com.sda.javagda17.checklist.model.dto.request.AddCheckListRequest;
import com.sda.javagda17.checklist.repository.CheckListItemRepository;
import com.sda.javagda17.checklist.repository.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

    @Autowired
    private CheckListRepository checkListRepository;

    @Autowired
    private CheckListItemRepository checkListItemRepository;


    public Optional<Checklist> addChecklist(AddCheckListRequest addCheckListRequest) {
        Optional<Checklist> checklistOptional = checkListRepository.findByName(addCheckListRequest.getName());
        if (!checklistOptional.isPresent()) {
            Checklist checklist = new Checklist();
            checklist.setName(addCheckListRequest.getName());
            checklist.setDateCreated(LocalDateTime.now());

            return Optional.of(checkListRepository.save(checklist));
        }
        return Optional.empty();
    }

    public List<Checklist> getAllChecklists() {
        return checkListRepository.findAll();
    }

    public List<Checklist> getArchivedChecklists() {
        List<Checklist> allChecklists = checkListRepository.findAll();

        List<Checklist> archivedChecklists = new ArrayList<>();

        for (Checklist singleArchivedChecklist : allChecklists) {
            if (singleArchivedChecklist.isArchived()) {
                archivedChecklists.add(singleArchivedChecklist);

                return archivedChecklists;
            }
        }
        return archivedChecklists;
    }
}
