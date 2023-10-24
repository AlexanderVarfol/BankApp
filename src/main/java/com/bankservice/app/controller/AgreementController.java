package com.bankservice.app.controller;

import com.bankservice.app.entity.Agreement;
import com.bankservice.app.service.util.AgreementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/agreement")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @GetMapping("/{id}")
    public Agreement getAgreement(@PathVariable("id") String id) {

        Optional<Agreement> opt = agreementService.getAgreementById(id);

        if(opt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unreal id");
        }
        return opt.get();
        
 // оно мам возвращяет оптионал, єто значит что надо проверить на пустоту
    }
}
