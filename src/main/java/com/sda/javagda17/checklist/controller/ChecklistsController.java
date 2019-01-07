package com.sda.javagda17.checklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChecklistsController {

    @GetMapping("/checklists")
    public String getCheckListsPage() {
        return "checklists";
    }


}
