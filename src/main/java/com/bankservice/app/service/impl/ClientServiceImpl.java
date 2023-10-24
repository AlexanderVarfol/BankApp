package com.bankservice.app.service.impl;

import com.bankservice.app.entity.Client;
import com.bankservice.app.repository.ClientRepository;
import com.bankservice.app.service.util.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> getClientById(String id) {
        return clientRepository.findById(Integer.parseInt(id));
    }
}
