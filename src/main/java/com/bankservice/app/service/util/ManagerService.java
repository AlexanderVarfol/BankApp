package com.bankservice.app.service.util;

import com.bankservice.app.entity.Manager;

import java.util.Optional;

public interface ManagerService {
    Optional<Manager> getManagerById(String id);
}
