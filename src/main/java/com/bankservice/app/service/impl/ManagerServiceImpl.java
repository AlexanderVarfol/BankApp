package com.bankservice.app.service.impl;

import com.bankservice.app.entity.Manager;
import com.bankservice.app.repository.ManagerRepository;
import com.bankservice.app.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public Optional<Manager> getManagerById(String id) {
        return managerRepository.findById(Integer.parseInt(id));
    }
}
