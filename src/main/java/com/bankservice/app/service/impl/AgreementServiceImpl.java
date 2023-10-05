package com.bankservice.app.service.impl;
import com.bankservice.app.entity.Agreement;
import com.bankservice.app.repository.AgreementRepository;
import com.bankservice.app.service.util.AgreementService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AgreementServiceImpl implements AgreementService {

    private final AgreementRepository agreementRepository;


    @Override
    public Optional<Agreement> getAgreementById(String id) {
        return agreementRepository.findById(Integer.parseInt(id));
    }
}
// interface AgreementRepository extends JPARepository<class, type>

// class AgreementServiceImpl implements AgreementService
//
