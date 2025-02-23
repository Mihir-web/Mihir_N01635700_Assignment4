package com.mihir.assignment4;


import com.mihir.assignment4.Workshop;
import com.mihir.assignment4.WorkshopRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopService {

    @Autowired
    private WorkshopRepository repository;

    public Workshop saveRegistration(Workshop registration) {
        return repository.save(registration);
    }
    
    public List<Workshop> getAllWorkshops() {
        return repository.findAll(); // Fetch all workshops from DB
    }
}

