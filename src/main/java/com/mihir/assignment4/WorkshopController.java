package com.mihir.assignment4;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkshopController {

	
	 @Autowired
	    private WorkshopService workshopService;

	 
    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("workshop", new Workshop());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("workshop") Workshop workshop, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        
        // Save the workshop registration
        workshopService.saveRegistration(workshop);
        
        return "success";
    }
    
    @GetMapping("/workshopRegistrations")
    public String listWorkshops(Model model) {
        List<Workshop> workshops = workshopService.getAllWorkshops();
        model.addAttribute("workshops", workshops);
        return "workshops"; 
    }
}

