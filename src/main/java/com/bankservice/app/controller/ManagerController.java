package com.bankservice.app.controller;


import com.bankservice.app.entity.Manager;
import com.bankservice.app.service.util.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @GetMapping(value = "/{id}")
    public Manager getManagerById(@PathVariable("id")String id){

        Optional<Manager> opt = managerService.getManagerById(id);

        if(opt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unreal id");
        }
        return opt.get();
    }
}
