package com.autoflex.tms.services;

import com.autoflex.tms.entities.Manager;
import com.autoflex.tms.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public void createManager(Manager manager) {
        managerRepository.save(manager);
    }
}
