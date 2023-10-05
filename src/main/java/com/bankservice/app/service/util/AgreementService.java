package com.bankservice.app.service.util;

import com.bankservice.app.entity.Agreement;

import java.util.List;
import java.util.Optional;

public interface AgreementService {

   Optional<Agreement> getAgreementById(String id);
    //List<Agreement>
}
