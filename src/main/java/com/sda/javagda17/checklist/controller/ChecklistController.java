package com.sda.javagda17.checklist.controller;

import com.sda.javagda17.checklist.model.Checklist;
import com.sda.javagda17.checklist.model.ItemStatus;
import com.sda.javagda17.checklist.model.dto.request.AddCheckListRequest;
import com.sda.javagda17.checklist.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

//    @GetMapping("/checklistForm")
//    public String getChecklistForm() {
//        return "checklistForm";
//    }
//
//    @PostMapping("/checklistForm")
//    public String submitChecklistForm(AddCheckListRequest addCheckListRequest) {
//        Optional<Checklist> checklistOptional = checklistService.addChecklist(addCheckListRequest);
//        if (checklistOptional.isPresent()) {
//            return "index";
//        }
//        return "checklistForm";
//    }

    @GetMapping("/checklistForm")
    public String getChecklistForm(Model model) {
        model.addAttribute("formObject", new AddCheckListRequest());
        return "checklist/checklistForm";
    }

    @PostMapping("/checklistForm")
    public String sendNewChecklist(Model model, AddCheckListRequest request) {
        Optional<Checklist> checklistOptional = checklistService.addChecklist(request);
        if (checklistOptional.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("message", "Could not create checklist");
        model.addAttribute("formObject", request);

        return "checklist/checklistForm";
    }

    @GetMapping("/list")
    public String getChecklists(Model model) {
        List<Checklist> listOfChecklists = checklistService.getAllChecklists();

        model.addAttribute("checklists", listOfChecklists);

        return "checklist/list";
    }

    @GetMapping("/archived")
    public String getArchivedChecklists(Model model) {
        List<Checklist> listOfArchivedChecklists = checklistService.getArchivedChecklists();

        model.addAttribute("archived", listOfArchivedChecklists);
        return "checklist/archived";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(Model model, @PathVariable(name = "id") Long id) {
        Optional<Checklist> checkListOptional = checklistService.getChecklistById(id);
        Checklist checklistArchived = checkListOptional.get();
        if (checkListOptional.isPresent()) {
//            model.addAttribute("checklistOptions", ItemStatus.values()); // <- to jest do poprawy
            // mozliwosc wyboru zamiast zwyklego booleana
            model.addAttribute("checklistChoice", checklistArchived.isArchived()); // <- to jest do poprawy
            model.addAttribute("checklistToEdit", checkListOptional.get());
            return "checklist/editForm";
        }
        return "redirect:/list";
    }

    @PostMapping("/edit/{id}")
    public String getEditForm(Model model, @PathVariable(name = "id") Long id, Checklist checklistUpdate) {
        checklistService.update(checklistUpdate);
        return "redirect:/list";

    }
}

