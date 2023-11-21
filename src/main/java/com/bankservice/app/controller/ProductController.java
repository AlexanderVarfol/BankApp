package com.bankservice.app.controller;

import com.bankservice.app.entity.Manager;
import com.bankservice.app.entity.Product;
import com.bankservice.app.service.util.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    //Posзапрос из dto в entity
    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable("id")String id){

        Optional<Product> opt = productService.getProductById(id);

        if(opt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "unreal id");
        }
        return opt.get();
    }

}
