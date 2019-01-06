package com.sda.javagda17.checklist.controller;

import com.sda.javagda17.checklist.model.Checklist;
import com.sda.javagda17.checklist.model.dto.request.AddCheckListRequest;
import com.sda.javagda17.checklist.service.ChecklistService;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/checklistform")
    public String getChecklistPage() {
        return "/checklist";
    }

    @GetMapping("/checklistform")
    public String getChecklistForm(Model model) {
        model.addAttribute("formObject", new AddCheckListRequest());
        return "/checklistform";
    }

    @PostMapping("/checklistform")
    public String sendNewChecklist(Model model, AddCheckListRequest request) {
        Optional<Checklist> checklistOptional = checklistService.addChecklist(request);
        if (checklistOptional.isPresent()) {
            Checklist createdChecklist = checklistOptional.get();

            return "/";
        }
        model.addAttribute("message", "Could not create checklist");
        model.addAttribute("formObject", request);

        return "redirect:/checklistform";
    }
}
