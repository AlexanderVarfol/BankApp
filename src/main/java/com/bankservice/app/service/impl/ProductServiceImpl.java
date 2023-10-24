package com.bankservice.app.service.impl;

import com.bankservice.app.entity.Product;
import com.bankservice.app.repository.ProductRepository;
import com.bankservice.app.service.util.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(Integer.parseInt(id));
    }
}
