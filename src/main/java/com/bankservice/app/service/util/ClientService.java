package com.bankservice.app.service.util;

import com.bankservice.app.entity.Client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> getClientById(String id);
}
